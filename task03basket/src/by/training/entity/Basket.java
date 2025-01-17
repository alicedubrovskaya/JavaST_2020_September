package by.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Class describes basket entity
 *
 * @author Alisa Dubrovskaya
 */
public class Basket {
    private int id;
    private List<Ball> balls = new ArrayList<>();

    public Basket(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balls.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Basket compareddObject = (Basket) obj;
        if (id != compareddObject.id) {
            return false;
        }
        if (!balls.equals(compareddObject.balls)) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        String ballsString = balls.stream()
                .map(ball -> String.valueOf(ball.getId()))
                .collect(Collectors.joining(","));
        return getClass().getName() + "[id=" + id + ",balls' in basket ids=" + ballsString;
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    public int getId() {
        return id;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
