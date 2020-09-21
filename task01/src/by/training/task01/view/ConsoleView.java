package by.training.task01.view;

import by.training.task01.controller.NumberController;
import by.training.task01.entity.Number;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final NumberController numberController;
    private final FileView fileView;
    static final String OPTION_GENERATE = "1 - generate numbers\n";
    static final String OPTION_FILE = "2 - from file\n";
    static final String OPTION_CONSOLE = "3 - from console\n";

    public ConsoleView(NumberController numberController, FileView fileView) {
        this.numberController = numberController;
        this.fileView = fileView;

        List<Number> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print(OPTION_GENERATE + OPTION_FILE + OPTION_CONSOLE);
        int option = in.nextInt();

        switch (option) {
            case 1:
                numbers = optionGeneratedNumbers();
                break;
            case 2:
                numbers = optionNumbersFromFile();
                break;
            case 3:
                numbers = optionNumbersFromConsole();
                break;
            default:
                System.out.print("Choose option");
                break;

        }

        if (numberController.hasAtLeastTwoEvenNumbers(numbers)) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }

        in.close();
    }

    public List<Number> optionGeneratedNumbers() {
        List<Number> numbers = numberController.getGeneratedNumbers();
        for (Number number : numbers) {
            System.out.print(number.getValue() + " ");
        }
        return numbers;
    }

    public List<Number> optionNumbersFromFile() {
        List<Number> numbers;
        try {
            numbers = fileView.getNumbersFromFile("C:\\Users\\alice\\OneDrive\\Рабочий стол\\Epam\\" +
                    "JavaST_2020_September\\task01\\numbers.txt");
            for (Number number : numbers) {
                System.out.print(number.getValue() + " ");
            }
        } catch (IOException e) {
            numbers = null;
        }
        return numbers;

    }

    public List<Number> optionNumbersFromConsole() {
        Scanner in = new Scanner(System.in);
        List<Number> numbers = new ArrayList<>();

        System.out.print("\nEnter 4 numbers:\n");
        for (int i = 0; i < 4; i++) {
            numbers.add(new Number(in.nextInt()));
        }
        return numbers;
    }

}
