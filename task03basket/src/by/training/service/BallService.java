package by.training.service;

import by.training.entity.Ball;
import by.training.entity.Colour;
import by.training.exception.BasketNotFoundException;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * This class does work with balls
 *
 * @author Alisa Dubrovskaya
 */
public class BallService {
    private BasketService basketService;

    public BallService(BasketService basketService) {
        this.basketService = basketService;
    }

    /**
     * Creates new exemplar of class Ball
     * @param weight
     * @param cost
     * @param colour
     * @return new exemplar fo class Ball
     */
    public Ball createNewBall(Double weight, BigDecimal cost, String colour) {
        return new Ball(weight, cost, Colour.getEnumByColour(colour));
    }

    /**
     * Adds ball to certain basket by id of the basket
     * @param basketId
     * @param ball
     * @throws BasketNotFoundException
     */
    public void addToBasket(int basketId, Ball ball) throws BasketNotFoundException {
        (basketService.findByIdBasket(basketId)).add(ball);
    }

    /**
     * Sorts list of balls ascending
     * @param balls
     * @return sorted list of balls
     */
    public List<Ball> sortBalls(List<Ball> balls) {
        balls.sort(Comparator.comparing(Ball::getCost));
        return balls;
    }
}
