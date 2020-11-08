package by.training.thread14dining;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(5);
        for (int i = 1; i <= 13; i++)
            new Philosopher(sem, i).start();
    }

}
