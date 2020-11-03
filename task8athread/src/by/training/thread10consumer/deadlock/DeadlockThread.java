package by.training.thread10consumer.deadlock;

public class DeadlockThread implements Runnable {
    private final CommonResource resource1;
    private final CommonResource resource2;

    public DeadlockThread() {
        this.resource1 = new CommonResource();
        this.resource2 = new CommonResource();
    }

    @Override
    public void run() {
        action1();
        action2();
    }

    public void action1() {
        synchronized (resource1) {
            System.out.println("Using of resource 1");
            synchronized (resource2) {
                System.out.println("Using of resource 2 + resource 1");
            }
        }
    }

    public void action2() {
        synchronized (resource2) {
            System.out.println("Using of resource 2");
            synchronized (resource1) {
                System.out.println("Using of resource 2 + resource 1");
            }
        }
    }
}
