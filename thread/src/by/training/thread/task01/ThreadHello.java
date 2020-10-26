package by.training.thread.task01;

public class ThreadHello extends Thread {

    @Override
    public void run() {
        System.out.println("Hello " + getName());
    }

    public static void main(String[] args) {
        ThreadHello thread = new ThreadHello();
        //thread hello
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
