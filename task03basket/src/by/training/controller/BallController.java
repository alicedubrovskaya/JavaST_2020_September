package by.training.controller;

import by.training.entity.Ball;
import by.training.exception.BasketNotFoundException;
import by.training.service.BallService;

/**
 * Class is controller of balls
 *
 * @author Alisa Dubrovskaya
 */
public class BallController {
    private BallService ballService;

    public BallController(BallService ballService) {
        this.ballService = ballService;
    }

    /**
     * Creates new ball
     * @param weight
     * @param cost
     * @param colour
     * @return new exemplar of class Ball
     */
    public Ball createBall(int weight, int cost, String colour) {
        return ballService.createNewBall(weight, cost, colour);
    }

    /**
     * Adds ball to certain basket bby id of the basket
     * @param id
     * @param ball
     * @throws BasketNotFoundException
     */
    public void addBallToBasket(int id, Ball ball) throws BasketNotFoundException {
        ballService.addToBasket(id, ball);
    }
}
