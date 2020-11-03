package by.training.thread04management;

public class JoinThread extends Thread {

    public JoinThread(String name) {
        super(name);
    }

    public void run() {
        String nameThread = getName();
        long timeout = 0;
        System.out.println("Start" + nameThread);
        try {
            switch (nameThread) {
                case "First":
                    timeout = 5_000;
                    break;
                case "Second":
                    timeout = 1_000;
                    break;
            }
            Thread.sleep(timeout);
            System.out.println("Ending " + nameThread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
