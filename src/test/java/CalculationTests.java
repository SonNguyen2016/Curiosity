import org.apache.log4j.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by sonnguyen on 6/24/17.
 */
public class CalculationTests {

    private Logger logger = Logger.getLogger(this.getClass());

    @DataProvider(name = "RandomNumbersGenerator")
    public Object[][] randomNumbersGenerator() {
        PropertyConfigurator.configure("src/log4j.properties");

        Object[][] objects = new Object[1000][2];

        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                objects[i][j] = new Random().nextInt(1000000);
            }
        }

        return objects;
    }

    @Test(description = "Test calculation", dataProvider = "RandomNumbersGenerator")
    public void testCalculation(int a, int b) {
        logger.info(a + "     " + b);
        int expectedResult = a + b;
        Assert.assertTrue(expectedResult == Calculation.addition(a, b));

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
