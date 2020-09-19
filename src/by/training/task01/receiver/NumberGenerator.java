package by.training.task01.receiver;

import by.training.task01.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Number> getGeneratedNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numbers.add(new Number((int) (Math.random() * 100)));
        }
        return numbers;
    }
}
