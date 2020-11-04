package by.dubrovskaya.service.implementation;

import by.dubrovskaya.service.ThreadServiceFactory;
import by.dubrovskaya.service.ThreadStringService;
import by.dubrovskaya.service.ThreadValidatorService;

public class ThreadThreadStringServiceImpl implements ThreadStringService {
    private int count = 0;
    private ThreadValidatorService threadValidatorService;

    public ThreadThreadStringServiceImpl() {
        ThreadServiceFactory factory = ThreadServiceFactory.getINSTANCE();
        this.threadValidatorService = factory.getValidatorService();
    }

    @Override
    public int[] parse(String line) {
        int[] elements = new int[count];

        if (line.matches("n=\\d+")) {
            count = Integer.parseInt(line.substring(line.indexOf("=") + 1));
            elements = new int[count];
        } else {
            String[] stringElements = line.split("\\s");
            for (int i = 0; i < count; i++) {
                if (threadValidatorService.validInteger(stringElements[i])) {
                    elements[i] = Integer.parseInt(stringElements[i]);
                }
            }
        }
        return elements;
    }
}
