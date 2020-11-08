package by.training.thread19executor;

import java.util.Random;
import java.util.concurrent.Callable;

public class CalcCallable implements Callable<Number> {
    @Override
    public Number call() throws Exception {
        Number result = new Random().nextGaussian();
        return result;

    }
}
