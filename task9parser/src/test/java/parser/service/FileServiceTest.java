package parser.service;

import by.training.parser.service.FileService;
import by.training.parser.service.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileServiceTest {
    private FileService fileService = ServiceFactory.getINSTANCE().getFileService();

    @Test(description = "Reading from file", dataProvider = "input_data")
    public void readTest(String filePath, String expected){
        String actual = fileService.read(filePath);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"task9parser/src/main/resources/text.txt", "My naame is Frank... I am from London.\n" +
                                "How are you? Hello...\n" +
                                "    New paragraph\n"}
                };
    }
}
