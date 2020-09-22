package by.training.view;

import by.training.entity.Number;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileView {
    public List<Number> getNumbersFromFile(String fileName) throws IOException {
        List<Number> numbers = new ArrayList<>();

        try (FileReader fr = new FileReader(fileName);
             Scanner scan = new Scanner(fr);
        ) {
            while (scan.hasNext()) {
                numbers.add(new Number(scan.nextInt()));
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return numbers;
    }

}
