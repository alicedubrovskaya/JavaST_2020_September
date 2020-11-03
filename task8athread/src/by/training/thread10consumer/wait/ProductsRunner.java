package by.training.thread10consumer.wait;

public class ProductsRunner {
    public static void main(String[] args) {
        Store store = new Store();
        for (int i=0;i<3;i++){
            new Producer(store).start();
            new Consumer(store).start();
        }
    }
}
