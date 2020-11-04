package by.training.thread03priority;

public class PriorThread extends Thread {
    public PriorThread(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }

    public PriorThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 71; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}