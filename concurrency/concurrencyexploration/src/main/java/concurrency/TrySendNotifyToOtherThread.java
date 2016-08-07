package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by icetusk on 07.08.16.
 */
public class TrySendNotifyToOtherThread {

    private static Object monitor1 = new Object();

    private static Object monitor2 = new Object();

    private static void work1() {
        try {
            System.out.println("Work1 does some work. Then try to notify Work2.");
            TimeUnit.SECONDS.sleep(1);
            synchronized (monitor2) {
                monitor2.notify();
            }
            System.out.println("Work1 finished without gettting response from Work2.");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void work2() {
        try {
            System.out.println("Work2 does some work. Then wait for signal from Work1.");
            synchronized (monitor2) {
                monitor2.wait();
            }
            System.out.println("Work2 get message from work1. And continues.");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String... args) throws Exception {

        // Главная проблема здесь - мы еще не дошли в потоке до wait, но уже вызвали notify.
        // Поэтому наш notify затерялся и программа подвисла.
        // Чтобы все заработало нужно чтобы первый поток изначально подзавис перед тем как
        // второй поток вызовет wait, тогда notify не теряется.
        new Thread(() -> work1()).start();
        new Thread(() -> work2()).start();
    }
}
