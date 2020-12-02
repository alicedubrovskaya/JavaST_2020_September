package by.training.xml.entity;


import by.training.xml.entity.enumeration.Period;

public class Dosage {
    private int count;
    private Period period;

    public void setCount(int count) {
        this.count = count;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public int getCount() {
        return count;
    }

    public Period getPeriod() {
        return period;
    }
}
