package by.training.entity;

import java.util.UUID;

public class Ball {
    private UUID id;
    private int weight;
    private int cost;
    private Colour colour;

    public Ball(int weight, int cost, Colour colour) {
        this.id = UUID.randomUUID();
        this.weight = weight;
        this.cost = cost;
        this.colour = colour;
    }

    @Override
    public int hashCode() {
        return id.hashCode() + weight * 12 + cost * 3 + colour.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id " + id.toString() + " weight: " + weight
                + " cost: " + cost + " colour:" + colour;
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
      /*  if (!id.equals(comparedObject.getId())) {
            return false;
        }

       */
        if (cost != comparedObject.cost) {
            return false;
        }
        if (weight != comparedObject.weight) {
            return false;
        }
        return true;
    }

    public UUID getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public Colour getColour() {
        return colour;
    }
}
