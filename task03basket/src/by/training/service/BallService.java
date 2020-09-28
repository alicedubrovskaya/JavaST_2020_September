package by.training.service;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.Colour;
import by.training.entity.list.BasketList;
import by.training.exception.BasketNotFoundException;

import java.util.Comparator;
import java.util.List;

public class BallService {
    private BasketService basketService;

    public BallService(BasketService basketService) {
        this.basketService = basketService;
    }

    public Ball createNewBall(int weight, int cost, String colour) {
        return new Ball(weight, cost, Colour.getEnumByColour(colour));
    }

    public void addToBasket(int basketId, Ball ball) throws BasketNotFoundException {
        (basketService.findByIdBasket(basketId)).add(ball);
    }

    public List<Ball> sortBalls(List<Ball> balls) {
        balls.sort(new Comparator<Ball>() {
            @Override
            public int compare(Ball ball, Ball t1) {
                return Integer.compare(ball.getCost(), t1.getCost());
            }
        });
        return balls;
    }
}
