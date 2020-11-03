package by.training.thread07file;

import java.io.File;
import java.io.IOException;

public class FileRunner {
    public static void main(String[] args) {
        CommonResource commonResource = null;
        try {
            String filePath = new File("task8athread\\data\\result.txt").getAbsolutePath();
            commonResource = new CommonResource(filePath);
            FileThread t1 = new FileThread("First", commonResource);
            FileThread t2 = new FileThread("Second", commonResource);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            commonResource.close();
        }
    }
}
