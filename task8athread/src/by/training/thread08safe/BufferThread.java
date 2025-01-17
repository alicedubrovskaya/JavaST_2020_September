package by.training.thread08safe;

public class BufferThread {
    static int counter = 0;
    static StringBuffer s = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            public void run() {
                synchronized (s) {
                    while (counter++ < 3) {
                        s.append("A");
                        System.out.print("> " + counter + " ");
                        System.out.println(s);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();


        Thread.sleep(100);
        while (BufferThread.counter++ < 6) {
            System.out.print("< " + counter + " ");
            s.append("B");
            System.out.println(s);
        }
    }

}
