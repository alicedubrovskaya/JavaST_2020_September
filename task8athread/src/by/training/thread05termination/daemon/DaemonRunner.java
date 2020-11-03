package by.training.thread05termination.daemon;

public class DaemonRunner {
    public static void main(String[ ] args) {
        SimpleThread usual = new SimpleThread();
        SimpleThread daemon = new SimpleThread();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();
        System.out.println("Last operator from main");
    }
}
