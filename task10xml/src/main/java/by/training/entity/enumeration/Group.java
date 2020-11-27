package by.training.entity.enumeration;

public enum Group {
    ANTIBIOTICS("antibiotics"),
    ANTISEPTICS("antiseptics"),
    ANTIVIRAL("antiviral"),
    ANTIDEPRESSANTS("antidepressants"),
    ANALGETICS("analgetics"),
    VITAMINS("vitamins");

    private String value;

    Group(String v) {
        this.value = v;
    }
}
