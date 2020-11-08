package by.training.thread14dining;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    Semaphore sem;
    int num = 0;
    int id;

    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3)
            {
                sem.acquire();
                System.out.println("Философ " + id + " садится за стол");
                sleep(500);
                num++;

                System.out.println("Философ " + id + " выходит из-за стола");
                sem.release();

                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " проблемы со здоровьем");
        }
    }

}
