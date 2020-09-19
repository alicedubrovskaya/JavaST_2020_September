package by.training.task01;

import java.util.List;

public class NumberService {
    public boolean hasAtLeastTwoEvenNumbers(List<Number> numbers) {
        int countOfEvenNumbers = 0;

        for (Number number : numbers) {
            if (number.isEvenNumbered()) {
                countOfEvenNumbers++;
            }
        }
        if (countOfEvenNumbers >= 2) return true;
        else return false;
    }
}
