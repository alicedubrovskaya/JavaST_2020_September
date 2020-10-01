package by.training.service;

import by.training.entity.Ball;
import by.training.entity.Basket;
import by.training.entity.list.BasketList;
import by.training.exception.BasketNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Class does work with baskets
 *
 * @author Alisa Dubrovskaya
 */
public class BasketService {
    private BasketList basketList;

    public BasketService(BasketList basketList) {
        this.basketList = basketList;
    }

    /**
     * Creates new basket
     *
     * @param id
     * @return new exemplar of Basket class
     */
    public Basket createNewBasket(int id) {
        return new Basket(id);
    }

    /**
     * Adds basket to list of baskets
     *
     * @param basket
     */
    public void addToBasketList(Basket basket) {
        basketList.add(basket);
    }

    /**
     * Finds needed basket by id of the basket
     *
     * @param basketId
     * @return found basket
     * @throws BasketNotFoundException
     */
    public Basket findByIdBasket(int basketId) throws BasketNotFoundException {
        for (Basket basket : basketList.getBaskets()) {
            if (basketId == basket.getId()) {
                return basket;
            }
        }
        throw new BasketNotFoundException(basketId);
    }

    /**
     * Finds total weight of balls in specified basket
     *
     * @param basket
     * @return total weight
     */
    public Double findWeightOfBalls(Basket basket) {
        Double weightSum = (double) 0;
        for (Ball ball : basket.getBalls()) {
            weightSum += ball.getWeight();
        }
        return weightSum;
    }

    /**
     * Finds count of balls with specified colour in certain basket
     *
     * @param basket
     * @param colour
     * @return count of balls with specified colour
     */
    public int findCountOfBallsByColour(Basket basket, String colour) {
        int count = 0;
        for (Ball ball : basket.getBalls()) {
            count += (colour.equals(ball.getColour().getColourInformation()) ? 1 : 0);
        }
        return count;
    }

    /**
     * Finds the same balls by colors in certain basket
     *
     * @param basket
     * @return Map<K, V> where K-colour, V-count of balls with this colour
     */
    public Map<String, Integer> findTheSameBallsInBasket(Basket basket) {
        Map<String, Integer> theSameBalls = new HashMap<>();
        for (Ball ball : basket.getBalls()) {
            String colour = ball.getColour().getColourInformation();
            if (theSameBalls.containsKey(colour)) {
                theSameBalls.put(colour, theSameBalls.get(colour) + 1);
            } else {
                theSameBalls.put(colour, 1);
            }
        }
        return theSameBalls;
    }

    /**
     * Finds the same balls by colors in all baskets
     *
     * @return Map<K,V> where K- id of the basket, V- map with the same balls in certain basket
     * @see #findTheSameBallsInBasket(Basket)
     */
    public Map<Integer, Map<String, Integer>> findCountOfTheSameBallsInBaskets() {
        Map<Integer, Map<String, Integer>> sameColoursInBaskets = new HashMap<>();
        for (Basket basket : basketList.getBaskets()) {
            sameColoursInBaskets.put(basket.getId(), findTheSameBallsInBasket(basket));
        }
        return sameColoursInBaskets;
    }

    /**
     * Finds hashcode of the balls set
     * @param coloursSet
     * @return hashcode
     */
    public int findHashCodeOfColoursInBasket(Object coloursSet) {
        return coloursSet.hashCode();
    }

    /**
     * Finds the same sets of balls
     * @return Map<K,V> where K- hashcode of set, V- count of such sets
     */
    public Map<Integer, Integer> theSameSetsOfBalls() {
        Map<Integer, Map<String, Integer>> sameColoursInBaskets = findCountOfTheSameBallsInBaskets();
        Map<Integer, Integer> theSameSets = new HashMap<>();
        for (Map.Entry<Integer, Map<String, Integer>> entry : sameColoursInBaskets.entrySet()) {
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
