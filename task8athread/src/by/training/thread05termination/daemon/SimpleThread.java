package by.training.thread05termination.daemon;

public class SimpleThread extends Thread {

    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("Daemon thread started");
                Thread.sleep(10_000);
            } else {
                System.out.println("Simple thread started");
            }
        } catch (InterruptedException e) {
            System.err.print(e);
        } finally {
            if (!isDaemon()) {
                System.out.println("Simple thread ended work");
            } else {
                System.out.println("Daemon thread ended work");
            }
        }
    }
}
