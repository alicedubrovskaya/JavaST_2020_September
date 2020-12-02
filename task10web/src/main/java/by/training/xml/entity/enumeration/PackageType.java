package by.training.xml.entity.enumeration;

public enum PackageType {
    VIAL("value"),
    BLISTER_PACKAGING("blister_packaging"),
    CONTOURE_CELLESS("contoure_celless");

    private final String value;

    PackageType(final String v) {
        value = v;
    }

    public static PackageType getEnum(String v) {
        for (PackageType packageType : PackageType.values()) {
            if (packageType.value.equals(v)) {
                return packageType;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
