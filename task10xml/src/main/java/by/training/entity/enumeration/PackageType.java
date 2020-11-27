package by.training.entity.enumeration;

public enum PackageType {
    VIAL("value"),
    BLISTER_PACKAGING("blister_packaging"),
    CONTOURE_CELLESS("contoure_celless");

    private final String value;

    PackageType(final String v) {
        value = v;
    }
}
