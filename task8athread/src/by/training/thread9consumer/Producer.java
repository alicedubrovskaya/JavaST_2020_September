package by.training.thread9consumer;

public class Producer extends Thread {
    Store store;
    int product = 5;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product > 0) {
                product = product - store.put();
                System.out.println("Producer has " + product + " of products");
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
