package by.training.entity.enumeration;

public enum Period {
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year");

    private final String value;

    Period(final String v) {
        value = v;
    }

}
