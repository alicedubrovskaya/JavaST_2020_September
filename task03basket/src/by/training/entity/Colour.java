package by.training.entity;

public enum Colour {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private final String colourInformation;

    Colour(String colourInformation) {
        this.colourInformation = colourInformation;
    }

    public String getColourInformation() {
        return colourInformation;
    }

    public static Colour getEnumByColour(String colour) {
        for (Colour col : values()) {
            if (col.getColourInformation().equals(colour)) {
                return col;
            }
        }
        throw new IllegalArgumentException("No enum found with colour: [" + colour + "]");
    }
}
