package test.xml.parser;

import by.training.xml.entity.Medicine;
import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.xml.MedicinesProvider;

import java.util.List;

public class ParserSAXTest {
    private MedicinesProvider medicinesProvider = new MedicinesProvider();
    private MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();

    @Test(description = "SAX parsing", dataProvider = "input_data")
    public void readTest(String filePath, List<Medicine> expected) {
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("sax");
        builder.buildSetMedicines(filePath);
        List<Medicine> actual = builder.getMedicines();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"src/test/resources/test/data1.xml", medicinesProvider.createDataOne()},
                        {"src/test/resources/test/data2.xml", medicinesProvider.createDataTwo()},
                        {"src/test/resources/test/data3.xml",medicinesProvider.createDataThree()}
                };
    }
}
