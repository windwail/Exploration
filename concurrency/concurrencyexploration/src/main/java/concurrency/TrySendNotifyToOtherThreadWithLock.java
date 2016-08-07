package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by icetusk on 07.08.16.
 */
public class TrySendNotifyToOtherThreadWithLock {

    private static volatile Object message = null;

    private static void work1() {

        System.out.println("Work1 does some work. Then try to notify Work2.");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        message = "Greeting to all extraterrastrials!";

        System.out.println("Work1 finished without gettting response from Work2.");
    }

    private static void work2() {
            System.out.println("Work2 does some work. Then wait for signal from Work1.");

            while(message == null) {

            }

            System.out.println("Work2 get message from work1:"+message);

    }

    public static void main(String... args) throws Exception {

        // Главная проблема здесь - мы еще не дошли в потоке до wait, но уже вызвали notify.
        // Поэтому наш notify затерялся и программа подвисла.
        new Thread(() -> work1()).start();
        new Thread(() -> work2()).start();
    }
}
