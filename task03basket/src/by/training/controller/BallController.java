package by.training.controller;

import by.training.entity.Ball;
import by.training.exception.BasketNotFoundException;
import by.training.service.BallService;

public class BallController {
    private BallService ballService;

    public BallController(BallService ballService) {
        this.ballService = ballService;
    }

    public Ball createBall(int weight, int cost, String colour){
        return ballService.createNewBall(weight, cost, colour);
    }

    public void addBallToBasket(int id, Ball ball) throws BasketNotFoundException {
        ballService.addToBasket(id, ball);
    }
}
