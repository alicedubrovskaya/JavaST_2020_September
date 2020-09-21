package by.training.task01.service;

import by.training.task01.entity.Number;

import java.util.List;
import java.util.Random;

public class NumberService {
    private Random random;
    static final int BOUND_OF_RANDOM = 100;

    public NumberService() {
        random = new Random();
    }

    public int generateNumber() {
        return this.random.nextInt(BOUND_OF_RANDOM);
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
