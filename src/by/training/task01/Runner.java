package by.training.task01;

import by.training.task01.entity.Number;
import by.training.task01.receiver.NumberFileGetter;
import by.training.task01.receiver.NumberGenerator;
import by.training.task01.service.NumberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        NumberService numberService = new NumberService();
        NumberGenerator numberGenerator = new NumberGenerator();
        NumberFileGetter numberFileGetter = new NumberFileGetter();

        List<Number> numbers = new ArrayList<>();

        System.out.print("1 - generate numbers\n2 - from file\n3 - from console\n");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch (option) {
            case 1: {
                numbers = numberGenerator.getGeneratedNumbers();
                for (Number number : numbers) {
                    System.out.print(number.getValue() + " ");
                }
                break;
            }
            case 2: {
                numbers = numberFileGetter.getNumbersFromFile();
                for (Number number : numbers) {
                    System.out.print(number.getValue() + " ");
                }
                break;
            }
            case 3: {
                System.out.print("\nEnter 4 numbers:\n");
                for (int i = 0; i < 4; i++) {
                    numbers.add(new Number(in.nextInt()));
                }
            }

        }

        if (numberService.hasAtLeastTwoEvenNumbers(numbers))
            System.out.print("True");
        else System.out.print("False");

        in.close();
    }
}
