package by.training.entity;

public class Ball {
    private int id;
    private int weight;
    private int cost;
    private Colour colour;

    public Ball(int id, int weight, int cost, Colour colour) {
        this.id = id;
        this.weight = weight;
        this.cost = cost;
        this.colour = colour;
    }

    @Override
    public int hashCode() {
        return id * 31 + weight * 12 + cost * 3 + colour.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id " + id + " weight: " + weight + " cost: " + cost + " colour:" + colour;
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
        Ball comparedObject = (Ball) obj;
        if (colour != comparedObject.colour) {
            return false;
        }
        if (id != comparedObject.id) {
            return false;
        }
        if (cost != comparedObject.cost) {
            return false;
        }
        if (weight != comparedObject.weight) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }
}
