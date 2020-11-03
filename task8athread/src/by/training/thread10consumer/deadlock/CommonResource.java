package by.training.thread10consumer.deadlock;

public class CommonResource {
    public static void main(String[] args) {
        DeadlockThread deadlockThread = new DeadlockThread();
        Thread thread1 = new Thread(deadlockThread, "First");
        Thread thread2 = new Thread(deadlockThread, "Second");
        thread1.start();
        thread2.start();
    }
}
