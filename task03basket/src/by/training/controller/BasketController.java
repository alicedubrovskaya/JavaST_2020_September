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

/**
 * Class is controller of baskets
 *
 * @author Alisa Dubrovskaya
 */
public class BasketController {
    private BasketService basketService;
    private BallService ballService;
    private Random random;

    public BasketController(BasketService basketService, BallService ballService) {
        this.basketService = basketService;
        this.ballService = ballService;
        this.random = new Random();
    }

    /**
     * Creates new basket with specified id
     *
     * @param id
     */
    public void createBasket(int id) {
        basketService.addToBasketList(basketService.createNewBasket(id));
    }

    /**
     * Fills in basket with needed count of balls, values of fields are random
     *
     * @param basketId
     * @param countOfBalls
     * @throws BasketNotFoundException
     */
    public void fillBasket(int basketId, int countOfBalls) throws BasketNotFoundException {
        for (int i = 0; i < countOfBalls; i++) {
            String randomColour = Colour.values()[random.nextInt(Colour.values().length)].getColourInformation();
            Ball newBall = ballService.createNewBall(random.nextInt(100), random.nextInt(100),
                    randomColour);
            ballService.addToBasket(basketId, newBall);
        }
    }

    /**
     * Finds needed basket by id and then total weight of balls in this basket
     *
     * @param baskedId
     * @return total weight
     * @throws BasketNotFoundException
     */
    public int findWeightOfBallsInBasket(int baskedId) throws BasketNotFoundException {
        Basket basket = basketService.findByIdBasket(baskedId);
        return basketService.findWeightOfBalls(basket);
    }

    /**
     * Finds needed basket by id and then finds count of balls with specified colour in this basket
     *
     * @param baskedId
     * @param colour
     * @return count of the same balls
     * @throws BasketNotFoundException
     */
    public int findCountOfBallsByColourInBasket(int baskedId, String colour) throws BasketNotFoundException {
        Basket basket = basketService.findByIdBasket(baskedId);
        return basketService.findCountOfBallsByColour(basket, colour);
    }

    /**
     * Finds the same by colors balls in all baskets
     *
     * @return Map<K,V> where K- id of the basket, V- map with the same balls in certain basket
     */
    public Map<Integer, Map<String, Integer>> findCountOfTheSameBallsInBaskets() {
        return basketService.findCountOfTheSameBallsInBaskets();
    }

    /**
     * Finds the same sets of balls
     * @return Finds the same sets of balls
     */
    public Map<Integer, Integer> theSameSets() {
        return basketService.theSameSetsOfBalls();
    }

    /**
     * Finds needed basket by id and then sorts list of balls ascending
     * @param basketId
     * @return sorted list of balls
     * @throws BasketNotFoundException
     */
    public List<Ball> sortByCostInformationAboutBalls(int basketId) throws BasketNotFoundException {
        Basket basket = basketService.findByIdBasket(basketId);
        return ballService.sortBalls(basket.getBalls());
    }
}
