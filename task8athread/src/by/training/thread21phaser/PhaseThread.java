package by.training.thread21phaser;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable {
    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n) {
        this.phaser = p;
        this.name = n;
        phaser.register();
    }

    public void run() {
        System.out.println(name + " executes phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " executes phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " executes phase " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
