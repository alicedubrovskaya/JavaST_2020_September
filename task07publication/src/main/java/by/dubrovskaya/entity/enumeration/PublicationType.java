package by.dubrovskaya.entity.enumeration;

public enum PublicationType {
    BOOK("book"), JOURNAL("journal");

    private final String publicationType;

    PublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public static PublicationType getEnum(String type) {
        for (PublicationType info : values()) {
            if (info.getPublicationType().equals(type)) {
                return info;
            }
        }
        throw new IllegalArgumentException("No enum found with type: [" + type + "]");
    }
}
