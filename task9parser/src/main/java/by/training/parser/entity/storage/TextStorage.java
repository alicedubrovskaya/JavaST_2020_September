package by.training.parser.entity.storage;

import by.training.parser.entity.Composite;

public class TextStorage {
    private static final TextStorage INSTANCE = new TextStorage();
    private Composite text;
    private String stringText;

    private TextStorage() {
    }

    public static TextStorage getINSTANCE() {
        return INSTANCE;
    }

    public Composite getText() {
        return text;
    }

    public void setText(Composite text) {
        this.text = text;
    }

    public void setStringText(String stringText) {
        this.stringText = stringText;
    }

    public String getStringText() {
        return stringText;
    }
}
