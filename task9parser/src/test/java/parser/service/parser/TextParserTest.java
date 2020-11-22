package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.parser.TextParser;
import org.testng.annotations.Test;

public class TextParserTest {
    private TextParser textParser = new TextParser();

    @Test(description = "Is testing parsing for parts")
    public void parse() {
        Component component = new TextComposite();
        textParser.parse("My naame is Frank... I am   from London.\n How   are you?\tHello...", component);
    }
}
