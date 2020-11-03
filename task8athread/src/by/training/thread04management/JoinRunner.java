package by.training.thread04management;

public class JoinRunner {
    static {
        System.out.println("Start of thread main");
    }

    public static void main(String[] args) {
        JoinThread th1 = new JoinThread("First");
        JoinThread th2 = new JoinThread("Second");
        th1.start();
        th2.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
