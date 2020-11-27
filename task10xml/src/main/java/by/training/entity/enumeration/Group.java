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

    public static Group getEnum(String v) {
        for (Group group : Group.values()) {
            if (group.value.equals(v)) {
                return group;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
