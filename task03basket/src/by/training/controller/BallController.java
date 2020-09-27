package by.training.controller;

import by.training.entity.Ball;
import by.training.entity.Colour;
import by.training.exception.BasketNotFoundException;
import by.training.service.BallService;

public class BallController {
    private BallService ballService;

    public BallController(BallService ballService) {
        this.ballService = ballService;
    }

    public Ball createBall(int id, int weight, int cost, String colour){
        return ballService.createNewBall(id, weight, cost, colour);
    }

    public void addBallToBasket(int id, Ball ball) throws BasketNotFoundException {
        ballService.addToBasketList(id, ball);
    }
}
