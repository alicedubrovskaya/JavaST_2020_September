package by.dubrovskaya.entity.enumeration;

public enum SortType {
    TITLE("title"),
    PAGES("pages"),
    AUTHORS("author"),
    PUBLISHING_HOUSE("house"),
    TITLE_AND_PAGE("title and page"),
    PAGE_AND_PUBLISHING_HOUSE("page and publishing house");

    private final String sortInformation;

    SortType(String sortInformation) {
        this.sortInformation = sortInformation;
    }

    public String getSortInformation() {
        return sortInformation;
    }

    public static SortType getEnum(String string) {
        for (SortType info : values()) {
            if (info.getSortInformation().equals(string)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with : [" + string + "]");
    }
}
