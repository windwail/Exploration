package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by icetusk on 06.08.16.
 */
public class TrySimpleCommonResource {


    private static volatile boolean stop;

    private static  int resource;


    private static class MyRunnable extends Thread {

        private int threadIndex;

        public MyRunnable(String name) {
            this.threadIndex = Integer.valueOf(name);
        }

        @Override
        public void run() {
            while(!stop) {
                resource = threadIndex;
            }
        }
    }


    public static class MyClass {

        public MyClass someFunc() {
            System.out.println("My func");
            return this;
        }

        public void someFunc2() {
            System.out.println("My func 2");
        }
    }

    public static void main(String[] args) throws Exception {


        for(int i = 0; i < 20; i++) {
            new MyRunnable(String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(10);

        stop = true;

        TimeUnit.SECONDS.sleep(1);

        System.out.println(resource);

        new MyClass().someFunc().someFunc2();
    }

}
