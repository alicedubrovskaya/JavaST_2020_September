package by.training.task01.controller;

import by.training.task01.entity.Number;
import by.training.task01.service.NumberService;

import java.util.ArrayList;
import java.util.List;

public class NumberController {
    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    public List<Number> getGeneratedNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numbers.add(new Number(numberService.generateNumber()));
        }
        return numbers;
    }

    public boolean hasAtLeastTwoEvenNumbers(List<Number> numbers) {
        return numberService.hasAtLeastTwoEvenNumbers(numbers);
    }

}
