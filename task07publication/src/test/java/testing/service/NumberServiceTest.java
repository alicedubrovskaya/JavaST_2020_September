package testing.service;

import by.dubrovskaya.service.service.NumberService;
import by.dubrovskaya.service.service.implementation.NumberServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberServiceTest {
    private NumberService numberService = new NumberServiceImpl();

    @DataProvider(name = "input_interval")
    public Object[][] createData() {
        return
                new Object[][]{
                        {new int[]{1, 4, 3}, true},
                        {new int[]{1, 4, 5}, false},
                        {new int[]{1, 4, 0}, false},
                };
    }

    @Test(dataProvider = "input_interval")
    public void includedToIntervalTest(int[] parameters, boolean expected) {
        boolean actual = numberService.includedToInterval(parameters[0], parameters[1], parameters[2]);
        Assert.assertEquals(actual, expected);
    }
}
