package by.training.thread10consumer.wait;

public class Producer extends Thread {
    Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i=0;i<6;i++){
            store.put();
        }
    }
}
