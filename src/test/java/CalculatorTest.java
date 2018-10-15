import data.CalculatorDataProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AngularCalculatorPage;
import utils.Log;

public class CalculatorTest extends BaseTest {

    @Test(dataProvider = "calculatorPositiveTestData", dataProviderClass = CalculatorDataProvider.class,
            groups = "positive tests", priority = 1, description = "Calculator positive test")
    @Description("Test uses data provider")
    public void testCalculatorPositive(String firstNumber, String secondNumber, String operator, String expectedResult,
                                       String errorMessage) {
        String actualResult = AngularCalculatorPage.getCalculationResult(angularCalculatorPage, firstNumber, secondNumber, operator);
        Log.LOG.debug("comparison of actual result ('" + actualResult + "') and expected ('" + expectedResult + "')");
        Assert.assertTrue(actualResult.equals(expectedResult), errorMessage);
    }

    @Test(dataProvider = "calculatorNegativeTestData", dataProviderClass = CalculatorDataProvider.class,
            groups = "negative tests", priority = 2, description = "calculator negative test")
    @Description("Test uses data provider")
    public void testCalculatorNegative(String firstNumber, String secondNumber, String operator, String expectedResult,
                                       String errorMessage) {
        String actualResult = AngularCalculatorPage.getCalculationResult(angularCalculatorPage, firstNumber, secondNumber, operator);
        Log.LOG.debug("comparison of actual result ('" + actualResult + "') and expected ('" + expectedResult + "')");
        Assert.assertTrue(actualResult.equals(expectedResult), errorMessage);
    }

}
