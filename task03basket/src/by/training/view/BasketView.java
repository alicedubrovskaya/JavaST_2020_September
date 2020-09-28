package by.training.view;

import java.util.Scanner;

/**
 * Class lets to display the main menu to the user
 *
 * @author Alisa Dubrovskaya
 */
public class BasketView {
    private Scanner in;
    private OptionView optionView;

    public BasketView(OptionView optionView) {
        this.optionView = optionView;
        in = new Scanner(System.in);

        int doOptions = 1;
        while (doOptions == 1) {
            System.out.print("\n1 - create basket \n2 - create ball \n3 - fill the basket with balls\n" +
                    "4 - find weight and count of balls by colour \n5 - number of balls with the same colour in each basket" +
                    "\n6 - count of baskets with the same sets of balls\n" +
                    "7- get sorted by cost information about balls from certain basket\n");
            int option = in.nextInt();
            switch (option) {
                case 0:
                    doOptions = 0;
                    break;
                case 1:
                    optionView.optionCreateNewBasket();
                    break;
                case 2:
                    optionView.optionCreateNewBall();
                    break;
                case 3:
                    optionView.optionFillBasket();
                    break;
                case 4:
                    optionView.optionFindWeightAndCountInBasket();
                    break;
                case 5:
                    optionView.optionCountOfTheSameBallsInBaskets();
                    break;
                case 6:
                    optionView.optionCountOfBasketsWithTheSameSets();
                    break;
                case 7:
                    optionView.optionSortedByCostInformationAboutBalls();
                    break;
                default:
                    System.out.print("Please, enter one of the options");
            }
        }

    }
}
