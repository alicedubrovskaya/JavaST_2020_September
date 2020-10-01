package by.training.command;

import by.training.controller.BallController;
import by.training.controller.BasketController;
import by.training.entity.Ball;
import by.training.exception.BasketNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class is responsible for executing requests sent with the command
 *
 * @author Alisa Dubrovskaya
 * @since 01.10.20
 */
public class Receiver {
    private Scanner in;
    private BasketController basketController;
    private BallController ballController;

    public Receiver(BasketController basketController, BallController ballController) {
        this.basketController = basketController;
        this.ballController = ballController;
        in = new Scanner(System.in);
    }


    /**
     * Executes the request sent with the command
     *
     * @param option
     */
    public void action(int option) {

        switch (option) {
            case 1:
                optionCreateNewBasket();
                break;
            case 2:
                optionCreateNewBall();
                break;
            case 3:
                optionFillBasket();
                break;
            case 4:
                optionFindWeightAndCountInBasket();
                break;
            case 5:
                optionCountOfTheSameBallsInBaskets();
                break;
            case 6:
                optionCountOfBasketsWithTheSameSets();
                break;
            case 7:
                optionSortedByCostInformationAboutBalls();
                break;
            case 8:
                optionPrintInformation();
                break;
        }
    }


    /**
     * Creates new basket with specified id
     */
    public void optionCreateNewBasket() {
        System.out.print("Enter id of new basket: ");
        int id = in.nextInt();
        basketController.createBasket(id);
    }

    /**
     * Creates new ball
     */
    public void optionCreateNewBall() {
        System.out.print("Enter weight, cost, colour of new ball: ");
        Ball ball = ballController.createBall(in.nextDouble(), in.nextBigDecimal(), in.next());
        System.out.print("To what basket do you want to put this ball? Enter it's id: ");

        try {
            ballController.addBallToBasket(in.nextInt(), ball);
        } catch (BasketNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Fills in basket
     */
    public void optionFillBasket() {
        System.out.print("How much balls do you want to add? Enter id of basket, count of balls: ");
        try {
            basketController.fillBasket(in.nextInt(), in.nextInt());
        } catch (BasketNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Calculates total weight of balls with needed colour in basket
     */
    public void optionFindWeightAndCountInBasket() {
        System.out.print("Enter id of the basket, needed colour: ");
        try {
            int basketId = in.nextInt();
            Double weight = basketController.findWeightOfBallsInBasket(basketId);
            int count = basketController.findCountOfBallsByColourInBasket(basketId, in.next());
            System.out.print("Total weight: " + weight + ", count with this colour: " + count);
        } catch (BasketNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Calculates count of the same balls (identical colour) in all baskets
     */
    public void optionCountOfTheSameBallsInBaskets() {
        Map<Integer, Map<String, Integer>> sameColoursInBaskets = basketController.findCountOfTheSameBallsInBaskets();
        for (Map.Entry<Integer, Map<String, Integer>> entry : sameColoursInBaskets.entrySet()) {
            System.out.println("Basket id: " + entry.getKey());
            System.out.println("Count of balls with the same colour: " + entry.getValue());
        }
    }

    /**
     * Calculates count of baskets with the same sets of balls
     */
    public void optionCountOfBasketsWithTheSameSets() {
        int numberOfSet = 0;
        Map<Integer, Integer> theSameSets = basketController.theSameSets();
        for (Map.Entry<Integer, Integer> entry : theSameSets.entrySet()) {
            numberOfSet++;
            System.out.println("Set " + numberOfSet + ", count of baskets: " + entry.getValue());
        }
    }

    /**
     * Prints sorted by colour information about balls from certain basket
     */
    public void optionSortedByCostInformationAboutBalls() {
        System.out.print("Enter basket id: ");
        try {
            List<Ball> balls = basketController.sortByCostInformationAboutBalls(in.nextInt());
            for (Ball ball : balls) {
                System.out.println("cost: " + ball.getCost() + "; colour: " + ball.getColour().getColourInformation()
                        + "; weight: " + ball.getWeight());
            }
        } catch (BasketNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Prints information about available operations
     */
    public void optionPrintInformation() {
        System.out.print("\n1 - create basket \n2 - create ball \n3 - fill the basket with balls\n" +
                "4 - find weight and count of balls by colour \n5 - number of balls with the same colour in each basket" +
                "\n6 - count of baskets with the same sets of balls\n" +
                "7- get sorted by cost information about balls from certain basket\n");
    }
}
