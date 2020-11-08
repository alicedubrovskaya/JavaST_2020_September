package by.training.thread20exchanger;

public class Producer extends Subject implements Runnable {
    public Producer(String name, Item item) {
        super(name, item);
    }

    public void run() {
        try {
            synchronized (item) {
                int propouseNumber = this.getItem().getNumber();
                item = exchanger.exchange(item);
                if (propouseNumber <= item.getNumber()) {
                    System.out.println("Producer " + getName()
                            + " повышает план производства товара");
                } else {
                    System.out.println("Producer " + getName()
                            + " снижает план производства товара");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
