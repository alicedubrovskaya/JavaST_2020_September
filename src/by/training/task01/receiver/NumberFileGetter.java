package by.training.task01.receiver;

import by.training.task01.entity.Number;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberFileGetter {
    public List<Number> getNumbersFromFile() {
        List<Number> numbers = new ArrayList<>();
        Scanner scan=null;
        try {
            FileReader fr = new FileReader("numbers.txt");
            scan = new Scanner(fr);
            while (scan.hasNext()) {
                numbers.add(new Number(scan.nextInt()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return numbers;
    }

}
