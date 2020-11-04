package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.service.ServiceFactory;
import by.dubrovskaya.thread.service.StringService;
import by.dubrovskaya.thread.service.ValidatorService;

public class StringServiceImpl implements StringService {
    private int count = 0;
    private ValidatorService validatorService;

    public StringServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public int[] parse(String line) {
        int[] elements = new int[count];

        if (line.matches("n=\\d+") || line.matches("m=\\d+")) {
            count = Integer.parseInt(line.substring(line.indexOf("=") + 1));
            elements = new int[count];
        } else {
            String[] stringElements = line.split("\\s");
            for (int i = 0; i < count; i++) {
                if (validatorService.validInteger(stringElements[i])) {
                    elements[i] = Integer.parseInt(stringElements[i]);
                }
            }
        }
        return elements;
    }
}
