package by.training.thread9consumer;

public class Consumer extends Thread {
    Store store;
    int product = 0;
    final int N = 5;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product < N) {
                product = product + store.get();
                System.out.println("Consumer has " + product + " of products");
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
