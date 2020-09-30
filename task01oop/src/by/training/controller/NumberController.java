package by.training.controller;

import by.training.entity.Number;
import by.training.service.NumberService;

import java.util.ArrayList;
import java.util.List;

public class NumberController {
    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    public List<Number> getGeneratedNumbers(int countOfNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < countOfNumbers; i++) {
            numbers.add(new Number(numberService.generateNumber()));
        }
        return numbers;
    }

    public boolean hasAtLeastTwoEvenNumbers(List<Number> numbers) {
        return numberService.hasAtLeastTwoEvenNumbers(numbers);
    }

}
