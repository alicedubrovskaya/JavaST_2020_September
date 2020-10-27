package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.service.service.NumberService;

public class NumberServiceImpl implements NumberService {
    @Override
    public boolean includedToInterval(int leftBound, int rightBound, int number) {
        return (number >= leftBound && number <= rightBound);
    }
}
