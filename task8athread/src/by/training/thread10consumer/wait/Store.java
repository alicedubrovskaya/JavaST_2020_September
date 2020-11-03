package by.training.thread10consumer.wait;

public class Store {
    private int product = 0;

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Producer added 1 product");
        System.out.println("Products count at store: " + product);
        notifyAll();
    }

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Consumer bought 1 product");
        System.out.println("Products count at the store: " + product);
        notifyAll();
    }

}
