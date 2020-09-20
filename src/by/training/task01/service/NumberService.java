package by.training.task01.service;

import by.training.task01.entity.Number;
import by.training.task01.view.FileView;

import java.util.List;
import java.util.Random;

public class NumberService {

    public int generateNumber() {
        Random r = new Random();
        return r.nextInt(100);
    }

    public boolean isEvenNumbered(int value) {
        boolean isEven;
        if (value % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
        return isEven;
    }

    public boolean hasAtLeastTwoEvenNumbers(List<Number> numbers) {
        int countOfEvenNumbers = 0;

        for (Number number : numbers) {
            if (isEvenNumbered(number.getValue())) {
                countOfEvenNumbers++;
            }
        }

        return (countOfEvenNumbers >= 2);
    }


}
