package by.training.thread9consumer;

public class ProductsRunner {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
    }
}
