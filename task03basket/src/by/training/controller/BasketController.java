package by.training.controller;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.Colour;
import by.training.exception.BasketNotFoundException;
import by.training.service.BallService;
import by.training.service.BasketService;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class BasketController {
    private BasketService basketService;
    private BallService ballService;
    private Random random;

    public BasketController(BasketService basketService, BallService ballService) {
        this.basketService = basketService;
        this.ballService = ballService;
        this.random=new Random();
    }

    public void createBasket(int id) {
        basketService.addToBasketList(basketService.createNewBasket(id));
    }

    public void fillBasket(int basketId, int countOfBalls) throws BasketNotFoundException {
        for (int i = 0; i < countOfBalls; i++) {
            String randomColour = Colour.values()[random.nextInt(Colour.values().length)].getColourInformation();
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

    public Map<Integer, Map<String, Integer>> findCountOfTheSameBallsInBaskets() {
        return basketService.findCountOfTheSameBallsInBaskets();
    }

    public Map<Integer, Integer> theSameSets() {
        return basketService.theSameSetsOfBalls();
    }

    public List<Ball> sortByCostInformationAboutBalls(int basketId) throws BasketNotFoundException {
        Basket basket = basketService.findByIdBasket(basketId);
        return ballService.sortBalls(basket.getBalls());
    }
}
