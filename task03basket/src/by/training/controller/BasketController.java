package by.training.controller;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.Colour;
import by.training.exception.BasketNotFoundException;
import by.training.service.BallService;
import by.training.service.BasketService;

import java.util.Random;

public class BasketController {
    private BasketService basketService;
    private BallService ballService;

    public BasketController(BasketService basketService, BallService ballService) {
        this.basketService = basketService;
        this.ballService = ballService;
    }

    public void createBasket(int id) {
        basketService.addToBasketList(basketService.createNewBasket(id));
    }

    public void fillBasket(int basketId, int countOfBalls) throws BasketNotFoundException {
        Random random = new Random();
        for (int i = 0; i < countOfBalls; i++) {
            String randomColour = Colour.values()[random.nextInt(Colour.values().length)].getColour();
            Ball newBall = ballService.createNewBall(random.nextInt(100), random.nextInt(100),
                    randomColour);
            ballService.addToBasket(basketId, newBall);
        }
    }

    public int findWeightOfBallsInBasket(int baskedId) throws BasketNotFoundException {
        Basket basket = basketService.findByIdBasket(baskedId);
        return basketService.findWeightOfBalls(basket);
    }

    public int findCountOfBallsByColourInBasket(int baskedId, String colour) throws BasketNotFoundException {
        Basket basket = basketService.findByIdBasket(baskedId);
        return basketService.findCountOfBallsByColour(basket, colour);
    }
}
