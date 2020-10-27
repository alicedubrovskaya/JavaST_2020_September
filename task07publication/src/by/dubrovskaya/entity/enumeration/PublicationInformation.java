package by.dubrovskaya.entity.enumeration;

public enum PublicationInformation {
    TITLE("title"),
    PAGES("pages"),
    YEAR("year"),
    AUTHORS("author"),
    PUBLISHING_HOUSE("house"),
    ID("id"),
    ID_INTERVAL("interval"),
    PHRASE_AND_LETTER("phrase and letter");

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
