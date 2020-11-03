package by.training.thread03priority.task1.controller;

import by.training.thread03priority.task1.PriorThread;

public class PriorityMinNormMaxRunner {
    public static void main(String[] args) {
        PriorThread threadMin = new PriorThread("Min");
        PriorThread threadNorm = new PriorThread("Norm");
        PriorThread threadMax = new PriorThread("Max");

        threadMin.setPriority(Thread.MIN_PRIORITY);
        threadNorm.setPriority(Thread.NORM_PRIORITY);
        threadMax.setPriority(Thread.MAX_PRIORITY);

        threadMin.start();
        threadNorm.start();
        threadMax.start();
    }
}
