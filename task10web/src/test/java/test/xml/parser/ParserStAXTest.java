package test.xml.parser;

import by.training.xml.entity.Medicine;
import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.xml.MedicinesProvider;

import java.io.File;
import java.util.List;

public class ParserStAXTest {
    private MedicinesProvider medicinesProvider = new MedicinesProvider();
    private MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();

    @Test(description = "StAX parsing", dataProvider = "input_data")
    public void readTest(String filePath, List<Medicine> expected) {
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("stax");
        builder.buildSetMedicines(filePath);
        List<Medicine> actual = builder.getMedicines();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {new File("src/test/resources/test/data1.xml").getAbsolutePath(),
                                medicinesProvider.createDataOne()
                        },
                        {new File("src/test/resources/test/data2.xml").getAbsolutePath(),
                                medicinesProvider.createDataTwo()
                        },
                        {new File("src/test/resources/test/data3.xml").getAbsolutePath(),
                                medicinesProvider.createDataThree()
                        }
                };
    }
}
