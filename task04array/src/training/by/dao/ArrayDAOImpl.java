package training.by.dao;

import training.by.exception.IncorrectTypeOfElementsException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Alisa Dubrovskaya
 */
public class ArrayDAOImpl implements ArrayDAO {
    @Override
    public int[] getElementsFromFile(String fileName) throws IOException {
        int[] arrayInt = new int[5];

        int i = 0;
        try (FileReader fr = new FileReader(fileName);
             Scanner scan = new Scanner(fr);
        ) {

            while (scan.hasNext()) {
                try {
                    arrayInt[i] = scan.nextInt();
                    i++;
                } catch (IncorrectTypeOfElementsException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return arrayInt;
    }
}
