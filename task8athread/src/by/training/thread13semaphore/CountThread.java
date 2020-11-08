package by.training.thread13semaphore;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable {
    CommonResource res;
    Semaphore sem;
    String name;

    CountThread(CommonResource res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for access");
            sem.acquire();
            res.x = 1;
            for (int i = 0; i < 5; i++) {
                System.out.println(this.name + ": " + res.x);
                res.x++;
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " releases permission");
        sem.release();
    }
}
