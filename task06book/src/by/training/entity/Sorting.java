package by.training.entity;

public enum Sorting {
    ASCENDING("asc"),
    DESCENDING("desc");

    private final String sort;

    Sorting(String sort) {
        this.sort = sort;
    }

    public static Sorting getEnum(String string) {
        for (Sorting info : values()) {
            if (info.getSort().equals(string)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with string: [" + string + "]");
    }

    public String getSort() {
        return sort;
    }
}
