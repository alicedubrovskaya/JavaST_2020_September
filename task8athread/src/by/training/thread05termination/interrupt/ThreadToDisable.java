package by.training.thread05termination.interrupt;

public class ThreadToDisable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started work");
        int counter = 1;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Cycle " + counter++);
        }
        System.out.println("Thread ended work " + Thread.currentThread().getName());
    }
}
