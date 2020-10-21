package by.training.entity.enumeration;

public enum BookInformation {
    TITLE("title"),
    PAGES("pages"),
    YEAR("year"),
    PUBLISHING_HOUSE("house"),
    AUTHORS("author");

    private final String bookInformation;

    BookInformation(String bookInformation) {
        this.bookInformation = bookInformation;
    }

    public String getBookInformation() {
        return bookInformation;
    }

    public static BookInformation getEnumByTag(String tag) {
        for (BookInformation info : values()) {
            if (info.getBookInformation().equals(tag)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with tag: [" + tag + "]");
    }
}
