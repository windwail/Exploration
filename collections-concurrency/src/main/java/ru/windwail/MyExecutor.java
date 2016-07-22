package ru.windwail;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by icetusk on 22.07.16.
 */
public class MyExecutor {

    public static class Work extends Thread {
        public Work(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Thread "+getName()+ " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 40; i++) {
            ex.execute(new Work("Thread-"+i));
        }

        ex.shutdown();
        ex.awaitTermination(5, TimeUnit.SECONDS);
    }
}
