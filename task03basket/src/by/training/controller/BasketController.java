package by.training.controller;

import by.training.entity.Basket;
import by.training.service.BasketService;

public class BasketController {
    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService=basketService;
    }

    public void createBasket(int id){
        basketService.addToBasketList(basketService.createNewBasket(id));
    }
}
