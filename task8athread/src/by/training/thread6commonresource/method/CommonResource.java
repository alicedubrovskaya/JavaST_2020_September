package by.training.thread6commonresource.method;

public class CommonResource {
    int x;

    synchronized void increment() {
        x = 1;
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + x);
            x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
