package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.parser.TextParser;
import org.testng.annotations.Test;

public class TextParserTest {
    private TextParser textParser = TextParser.getINSTANCE();

    @Test(description = "Is testing parsing for parts")
    public void parseTest() {
        Component component = new TextComposite();
        textParser.parse("My naame is Frank... I am   from London.\n How   are you?\tHello...", component);
    }
}
