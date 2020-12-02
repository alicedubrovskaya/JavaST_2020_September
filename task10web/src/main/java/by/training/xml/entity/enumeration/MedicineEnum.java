package by.training.xml.entity.enumeration;

public enum MedicineEnum {
    MEDICINES("medicines"),
    MEDICINE("medicine"),
    NAME("name"),
    PHARM("pharm"),
    ANALOG("analog"),
    GROUP("group"),

    VERSIONS("versions"),
    VERSION("version"),
    CONSISTENCE("consistence"),

    PRODUCER("producer"),

    CERTIFICATE("certificate"),
    LIMITED_CERTIFICATE("limited_certificate"),
    NUMBER("number"),
    ISSUE_DATE("issue_date"),
    ORGANIZATION("organization"),
    EXPIRATION_DATE("expiration_date"),

    PACKAGE("package"),
    PRICE("price"),
    QUANTITY("quantity"),

    DOSAGE("dosage"),
    COUNT("count"),
    PERIOD("period");

    private String value;

    private MedicineEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
