package by.training.task01.view;

import by.training.task01.entity.Number;

import java.io.*;
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
