package by.training.xml.entity.enumeration;

public enum Consistence {
    TABLETS("tablets"),
    CAPSULES("capsules"),
    LIQUID("liquid"),
    POWDER("powder"),
    DROPS("drops"),
    SPRAY("spray");

    private String value;

    Consistence(final String v) {
        value = v;
    }

    public static Consistence getEnum(String v) {
        for (Consistence consistence : Consistence.values()) {
            if (consistence.value.equals(v)) {
                return consistence;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
