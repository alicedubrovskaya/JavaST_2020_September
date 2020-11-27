package by.training.entity.enumeration;

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
}
