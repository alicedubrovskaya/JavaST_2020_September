package by.training.thread12consumerlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product = 0;
    ReentrantLock locker;
    Condition notFull;
    Condition notEmpty;

    Store() {
        locker = new ReentrantLock();
        notFull = locker.newCondition();
        notEmpty = locker.newCondition();
    }

    public void put() {
        locker.lock();
        try {
            //store is full
            while (product >= 3) {
                notFull.await();
            }
            product++;
            System.out.println("Producer added one product ");
            System.out.println("Count of products at the store: " + product);

            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        locker.lock();
        try {
            while (product < 1) {
                notEmpty.await();
            }
            product--;
            System.out.println("Consumer bought 1 product");
            System.out.println("Count of products at the store: " + product);

            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
