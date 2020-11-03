package by.training.thread01hello;

public class ThreadHello extends Thread {

    @Override
    public void run() {
        System.out.println("Hello " + getName());
    }

    public static void main(String[] args) {
        ThreadHello thread = new ThreadHello();
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
