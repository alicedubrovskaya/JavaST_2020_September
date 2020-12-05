package by.training.xml.entity;


import by.training.xml.entity.enumeration.Period;
import by.training.xml.entity.list.VersionList;

import java.util.Objects;

public class Dosage {
    private int count;
    private Period period;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dosage dosage= (Dosage) o;
        return count == dosage.count
                && Objects.equals(period, dosage.period);
    }

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
