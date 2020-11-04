package by.training.thread03priority.controller;

import by.training.thread03priority.PriorThread;

public class PriorityGroupRunner {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Thread Group");
        PriorThread thread1 = new PriorThread(threadGroup,"First");
        PriorThread thread2 = new PriorThread(threadGroup,"Second");

        thread1.setPriority(5);
        thread2.setPriority(8);

        thread1.start();
        thread2.start();
    }
}
