package by.dubrovskaya.thread.service.implementation.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkThread extends RecursiveTask<Integer> {
    private final List<Integer> elementsList;

    private final Logger logger = LogManager.getLogger(getClass().getName());

    public ForkThread(List<Integer> elementsList) {
        this.elementsList = elementsList;
    }

    @Override
    protected Integer compute() {
        if (elementsList.isEmpty()) {
            logger.info("Found empty list, sum is 0");
            return 0;
        }

        int middleIndex = elementsList.size() / 2;
        logger.info("List {}, middle index: {}", elementsList, middleIndex);

        List<Integer> leftSublist = elementsList.subList(0, middleIndex);
        List<Integer> rightSublist = elementsList.subList(middleIndex + 1, elementsList.size());

        ForkThread leftThread = new ForkThread(leftSublist);
        ForkThread rightThread = new ForkThread(rightSublist);


        leftThread.fork();
        rightThread.fork();

        Integer leftSum = leftThread.join();
        Integer rightSum = rightThread.join();

        int sum = leftSum + rightSum + elementsList.get(middleIndex);
        logger.info("Left sum is {}, right sum is {}, total is {}", leftSum, rightSum, sum);
        return sum;
    }
}
