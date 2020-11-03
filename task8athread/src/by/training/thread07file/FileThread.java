package by.training.thread07file;

public class FileThread extends Thread {
    private CommonResource rs;
    public FileThread(String name, CommonResource rs) {
        super(name);
        this.rs = rs;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            rs.writing(getName(), i);
        }
    }
}
