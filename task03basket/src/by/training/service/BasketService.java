package by.training.service;

import by.training.entity.Basket;
import by.training.entity.list.BasketList;
import by.training.exception.BasketNotFoundException;

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
}
