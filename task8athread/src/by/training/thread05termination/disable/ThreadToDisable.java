package by.training.thread05termination.disable;

public class ThreadToDisable implements Runnable {
    private boolean isActive;

    public ThreadToDisable() {
        isActive = true;
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started work");
        int counter = 1;
        while (isActive) {
            System.out.println("Cycle " + counter);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread ended work " + Thread.currentThread().getName());
    }
}
