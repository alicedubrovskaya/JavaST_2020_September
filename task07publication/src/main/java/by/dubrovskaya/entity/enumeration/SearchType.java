package by.dubrovskaya.entity.enumeration;

public enum SearchType {
    TITLE("title"),
    PAGES("pages"),
    YEAR("year"),
    AUTHORS("author"),
    PUBLISHING_HOUSE("house"),
    ID("id"),
    ID_INTERVAL("interval"),
    PHRASE_AND_LETTER("phrase and letter");

    private final String searchInformation;

    SearchType(String searchInformation) {
        this.searchInformation = searchInformation;
    }

    public String getSearchInformation() {
        return searchInformation;
    }

    public static SearchType getEnumByTag(String tag) {
        for (SearchType info : values()) {
            if (info.getSearchInformation().equals(tag)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with tag: [" + tag + "]");
    }
}
