package by.training.thread6commonresource.method;


public class CountThread implements Runnable {
    CommonResource res;

    public CountThread(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.increment();
    }
}
