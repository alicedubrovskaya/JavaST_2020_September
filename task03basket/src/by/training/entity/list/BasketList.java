package by.training.entity.list;

import by.training.entity.Basket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alisa Dubrovskaya
 */
public class BasketList {
    List<Basket> baskets = new ArrayList<>();

    public void add(Basket basket) {
        baskets.add(basket);
    }

    public List<Basket> getBaskets() {
        return baskets;
    }
}
