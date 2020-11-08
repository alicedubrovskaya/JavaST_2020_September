package by.training.thread16blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Runner {
    private Runner() { }

    public static void main(final String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        new Thread() {
            public void run() {
                for (int i = 1; i < 4; i++) {
                    try {
                        queue.put("Java" + i); //add 3 elements
                        System.out.println("Element " + i + " added");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                    System.out.println("Element " + queue.take() + " took");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
