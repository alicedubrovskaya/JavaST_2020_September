package by.training.service;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.list.BasketList;
import by.training.exception.BasketNotFoundException;

import java.util.stream.Collectors;

public class BasketService {
    private BasketList basketList;

    public BasketService(BasketList basketList) {
        this.basketList = basketList;
    }

    public Basket createNewBasket(int id) {
        return new Basket(id);
    }

    public void addToBasketList(Basket basket) {
        basketList.add(basket);
    }

    public Basket findByIdBasket(int basketId) throws BasketNotFoundException {
        for (Basket basket : basketList.getBaskets()) {
            if (basketId == basket.getId()) {
                return basket;
            }
        }
        throw new BasketNotFoundException(basketId);
    }

    public int findWeightOfBalls(Basket basket) {
        int weightSum = 0;
        for (Ball ball : basket.getBalls()) {
            weightSum += ball.getWeight();
        }
        return weightSum;
    }

    public int findCountOfBallsByColour(Basket basket, String colour) {
        int count = 0;
        for (Ball ball : basket.getBalls()) {
            count += (colour.equals(ball.getColour().getColour()) ? 1 : 0);
        }
        return count;
    }
}
