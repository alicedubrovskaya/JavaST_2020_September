package by.training.view;

import by.training.controller.BallController;
import by.training.controller.BasketController;
import by.training.entity.Ball;
import by.training.exception.BasketNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class lets user interact with operations from main menu
 *
 * @author Alisa Dubrovskaya
 */
public class OptionView {
    private Scanner in;
    private BasketController basketController;
    private BallController ballController;

    public OptionView(BasketController basketController, BallController ballController) {
        this.basketController = basketController;
        this.ballController = ballController;

        in = new Scanner(System.in);
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
        Ball ball = ballController.createBall(in.nextInt(), in.nextInt(), in.next());
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
            int weight = basketController.findWeightOfBallsInBasket(basketId);
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
}
