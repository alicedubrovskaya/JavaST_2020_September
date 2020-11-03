package by.training.thread11locker;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    CommonResource res;
    ReentrantLock locker;

    public CountThread(CommonResource res, ReentrantLock lock) {
        this.res = res;
        locker = lock;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            res.x = 1;
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
