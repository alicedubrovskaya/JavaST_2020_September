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
            System.out.print("\n1 - create basket \n2 - create ball \n");
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
        System.out.print("Enter of id, weight, cost, colour of new ball: ");
        Ball ball = ballController.createBall(in.nextInt(), in.nextInt(), in.nextInt(), in.next());
        System.out.print("To what basket do you want to put this ball? Enter it's id: ");

        try {
            ballController.addBallToBasket(in.nextInt(), ball);
        } catch (BasketNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }
}
