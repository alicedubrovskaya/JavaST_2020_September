package by.training.task01;

public class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEvenNumbered() {
        boolean isEven;
        if (value % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
        return isEven;
    }

}
