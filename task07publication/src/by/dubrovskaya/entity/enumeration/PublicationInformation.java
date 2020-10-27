package by.dubrovskaya.entity.enumeration;

public enum PublicationInformation {
    TITLE("title"),
    PAGES("pages"),
    YEAR("year"),
    PUBLISHING_HOUSE("house"),
    AUTHORS("author");

    private final String bookInformation;

    PublicationInformation(String bookInformation) {
        this.bookInformation = bookInformation;
    }

    public String getBookInformation() {
        return bookInformation;
    }

    public static PublicationInformation getEnumByTag(String tag) {
        for (PublicationInformation info : values()) {
            if (info.getBookInformation().equals(tag)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with tag: [" + tag + "]");
    }
}
