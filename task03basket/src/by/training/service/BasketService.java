package by.training.service;

import by.training.entity.Basket;
import by.training.entity.list.BasketList;

public class BasketService {
    private BasketList basketList;

    public BasketService(BasketList basketList) {
        this.basketList=basketList;
    }

    public Basket createNewBasket(int id){
        return new Basket(id);
    }
    public void addToBasketList(Basket basket){
        basketList.add(basket);
    }
}
