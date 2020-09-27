package by.training.view;

import by.training.controller.BallController;
import by.training.controller.BasketController;
import by.training.entity.Ball;
import by.training.exception.BasketNotFoundException;

import java.util.Scanner;

public class BasketView {
    private Scanner in;
    private BasketController basketController;
    private BallController ballController;

    public BasketView(BasketController basketController, BallController ballController) {
        this.basketController = basketController;
        this.ballController = ballController;

        in = new Scanner(System.in);

        int doOptions = 1;
        while (doOptions == 1) {
            System.out.print("\n1 - create basket \n2 - create ball \n3 - fill the basket with balls\n" +
                    "4 - find weight and count of balls by colour");
            int option = in.nextInt();
            switch (option) {
                case 0:
                    doOptions = 0;
                    break;
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
                default:
                    System.out.print("Please, enter one of the options");
            }
        }

    }

    public void optionCreateNewBasket() {
        System.out.print("Enter id of new basket: ");
        int id = in.nextInt();
        basketController.createBasket(id);
    }

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

    public void optionFillBasket() {
        System.out.print("How much balls do you want to add? Enter id of basket, count of balls: ");
        try {
            basketController.fillBasket(in.nextInt(), in.nextInt());
        } catch (BasketNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

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
}
