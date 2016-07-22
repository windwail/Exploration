package ru.windwail;

import java.util.concurrent.*;

/**
 * Created by icetusk on 22.07.16.
 */
public class MyCallable {

    public static void main(String[] args) throws Exception {

        Callable<Integer> c = () -> {
            System.out.println("hi!");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("bye!");
            return 10;
        };


        ExecutorService es = Executors.newFixedThreadPool(10);

        Future<Integer> future = es.submit(c);

        while(!future.isDone()) {
        }
        System.out.println("Horay, he is done!");

    }
}
