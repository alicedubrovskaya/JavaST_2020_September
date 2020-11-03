package by.training.thread12consumerlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product = 0;
    ReentrantLock locker;
    Condition condition;

    Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void get() {
        locker.lock();
        try {
            while (product < 1) {
                condition.await();
            }
            product--;
            System.out.println("Consumer bought 1 product");
            System.out.println("Count of products at the store: " + product);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        locker.lock();
        try {
            while (product >= 3) {
                condition.await();
            }
            product++;
            System.out.println("Producer added one product ");
            System.out.println("Count of products at the store: " + product);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
