package by.training.service;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.list.BasketList;
import by.training.exception.BasketNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, Integer> findCountOfTheSameBalls(Basket basket) {
        Map<String, Integer> theSameBalls = new HashMap<>();
        for (Ball ball : basket.getBalls()) {
            String colour = ball.getColour().getColour();
            if (theSameBalls.containsKey(colour)) {
                theSameBalls.put(colour, theSameBalls.get(colour) + 1);
            } else {
                theSameBalls.put(colour, 1);
            }
        }
        return theSameBalls;
    }

    public Map<Integer, Map<String, Integer>> findCountOfTheSameBallsInBaskets() {
        Map<Integer, Map<String, Integer>> sameColoursInBaskets = new HashMap<>();
        for (Basket basket : basketList.getBaskets()) {
            sameColoursInBaskets.put(basket.getId(), findCountOfTheSameBalls(basket));
        }
        return sameColoursInBaskets;
    }

    public int findHashCodeOfColoursInBasket(Object coloursSet) {
        return coloursSet.hashCode();
    }

    public Map<Integer, Integer> theSameSetsOfBalls() {
        Map<Integer, Map<String, Integer>> sameColoursInBaskets = findCountOfTheSameBallsInBaskets();
        Map<Integer, Integer> theSameSets = new HashMap<>();
        for (Map.Entry entry : sameColoursInBaskets.entrySet()) {
            Integer hashCode = findHashCodeOfColoursInBasket(entry.getValue());
            if (theSameSets.containsKey(hashCode)) {
                theSameSets.put(hashCode, theSameSets.get(hashCode) + 1);
            } else {
                theSameSets.put(hashCode, 1);
            }
        }
        return theSameSets;
    }
}
