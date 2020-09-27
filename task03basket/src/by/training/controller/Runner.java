package by.training.controller;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.Colour;
import by.training.entity.list.BasketList;
import by.training.service.BallService;
import by.training.service.BasketService;
import by.training.view.BasketView;

public class Runner {
    public static void main(String[] args) {
        BasketList basketList = new BasketList();

        BasketService basketService = new BasketService(basketList);
        BallService ballService = new BallService(basketService);

        BasketController basketController = new BasketController(basketService, ballService);
        BallController ballController = new BallController(ballService);

        new BasketView(basketController, ballController);
    }
}
