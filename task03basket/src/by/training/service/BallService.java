package by.training.service;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.Colour;
import by.training.entity.list.BasketList;
import by.training.exception.BasketNotFoundException;

public class BallService {
    private BasketList basketList;

    public BallService(BasketList basketList) {
        this.basketList=basketList;
    }

    public Ball createNewBall(int id, int weight, int cost, String colour){
        return new Ball(id,weight,cost, Colour.getEnumByColour(colour));
    }

    public void addToBasketList(int basketId, Ball ball) throws BasketNotFoundException {
        (findByIdBasket(basketId)).add(ball);
    }

    public Basket findByIdBasket(int basketId) throws BasketNotFoundException {
        for (Basket basket: basketList.getBaskets()){
            if (basketId==basket.getId()){
                return basket;
            }
        }
        throw new BasketNotFoundException(basketId);
    }
}
