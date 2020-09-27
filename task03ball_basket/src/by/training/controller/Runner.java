package by.training.controller;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.Colour;

public class Runner {
    public static void main(String[] args) {
        Ball ball = new Ball(1, 25, 5, Colour.GREEN);
        Ball ballNew = new Ball(2, 20, 3, Colour.RED);
        Basket basket = new Basket(1);
        basket.add(ball);
        basket.add(ballNew);
        System.out.println(basket.toString());

        Basket basketTwo = new Basket(1);
        basketTwo.add(ball);
        basketTwo.add(ballNew);
        System.out.println(basket.equals(basketTwo) ? 1 : 0);

    }
}
