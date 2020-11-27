package by.training.entity;

import by.training.entity.enumeration.Period;

public class Dosage {
    private int quantity;
    private Period period;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
