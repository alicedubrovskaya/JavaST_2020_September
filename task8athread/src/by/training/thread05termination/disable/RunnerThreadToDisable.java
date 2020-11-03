package by.training.thread05termination.disable;

public class RunnerThreadToDisable {

    public static void main(String[] args) {
        System.out.println("Main thread started work");
        ThreadToDisable threadToDisable = new ThreadToDisable();
        Thread th = new Thread(threadToDisable);
        th.start();

        try {
            Thread.sleep(1100);
            threadToDisable.disable();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ended work");
    }
}
