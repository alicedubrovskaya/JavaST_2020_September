package training.by.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArrayDao {
    public int[] getElementsFromFile(String fileName) throws IOException {
        int[] arrayInt = new int[5];

        int i=0;
        try (FileReader fr = new FileReader(fileName);
             Scanner scan = new Scanner(fr);
        ) {
            while (scan.hasNext()) {
                arrayInt[i]=scan.nextInt();
                i++;
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return arrayInt;
    }
}
