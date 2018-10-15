import model.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AngularCalculatorPage;

public class CalculatorTest extends BaseTest {

    @Test(dataProvider = "calculatorPositiveTestData", dataProviderClass = CalculatorDataProvider.class,
            groups = "positive tests")
    public void testCalculatorPositive(String firstNumber, String secondNumber, String operator, String expectedResult,
                                       String errorMessage) {
        String actualResult = AngularCalculatorPage.getCalculationResult(angularCalculatorPage, firstNumber, secondNumber, operator);
        Assert.assertTrue(actualResult.equals(expectedResult), errorMessage);
    }

    @Test(dataProvider = "calculatorNegativeTestData", dataProviderClass = CalculatorDataProvider.class,
            groups = "negative tests")
    public void testCalculatorNegative(String firstNumber, String secondNumber, String operator, String expectedResult,
                                       String errorMessage) {
        String actualResult = AngularCalculatorPage.getCalculationResult(angularCalculatorPage, firstNumber, secondNumber, operator);
        Assert.assertTrue(actualResult.equals(expectedResult), errorMessage);
    }

}
