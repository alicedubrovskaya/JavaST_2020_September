package by.training.thread07file;

import java.io.FileWriter;
import java.io.IOException;

public class CommonResource {
    private FileWriter fileWriter;

    public CommonResource(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true);
    }

    public synchronized void writing(String str, int i) {
        try {
            fileWriter.append(str + i);
            System.out.print(str + i);
            Thread.sleep(100);
            fileWriter.append("->" + i + " ");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.print("ошибка закрытия файла: " + e);
        }
    }
}
