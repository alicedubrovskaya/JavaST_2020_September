package by.training.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * Class describes ball entity
 *
 * @author Alisa Dubrovskaya
 */
public class Ball {
    private UUID id;
    private Double weight;
    private BigDecimal cost;
    private Colour colour;

    public Ball(Double weight, BigDecimal cost, Colour colour) {
        this.id = UUID.randomUUID();
        this.weight = weight;
        this.cost = cost;
        this.colour = colour;
    }

    @Override
    public int hashCode() {
        //id.hashCode()
        return Objects.hash(weight, cost, colour);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id.toString() + ",weight=" + weight
                + ",cost=" + cost + ",colour=" + colour + "]";
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
    /*    if (!id.equals(comparedObject.getId())) {
            return false;
        }

     */
        if (cost.compareTo(comparedObject.cost) != 0) {
            return false;
        }
        return Double.compare(weight, comparedObject.weight) == 0;
    }

    public UUID getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public Colour getColour() {
        return colour;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
