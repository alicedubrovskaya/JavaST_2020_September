package by.training.entity;

public enum Colour {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private final String colour;

    Colour(String colour) {
        this.colour=colour;
    }

    public String getColour() {
        return colour;
    }

    public static Colour getEnumByColour(String colour) {
        for (Colour col : values()) {
            if (col.getColour().equals(colour)) {
                return col;
            }
        }
        throw new IllegalArgumentException("No enum found with colour: [" + colour + "]");
    }
}
