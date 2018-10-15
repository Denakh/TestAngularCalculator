package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

public class AngularCalculatorPage {

    private WebDriver driver;

    @FindBy(css = "input[ng-model='first']")
    private WebElement firstNumberField;

    @FindBy(css = "input[ng-model='second']")
    private WebElement secondNumberField;

    @FindBy(css = "select[ng-model='operator']")
    private WebElement operatorSelector;

    @FindBy(id = "gobutton")
    private WebElement goButton;

    @FindBy(css = "h2[class='ng-binding']")
    private WebElement calculationResult;

    @FindBy(css = "tr[ng-repeat='result in memory']")
    private WebElement calculationResultList;

    public AngularCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Type first number field by value: {0}")
    public AngularCalculatorPage typeFirstNumberField(String firstNumber) {
        Log.LOG.debug("typing first number field by value: " + firstNumber);
        firstNumberField.sendKeys(firstNumber);
        return this;
    }

    @Step("Type second number field by value: {0}")
    public AngularCalculatorPage typeSecondNumberField(String secondNumber) {
        Log.LOG.debug("typing second number field by value: " + secondNumber);
        secondNumberField.sendKeys(secondNumber);
        return this;
    }

    @Step("Select operator: {0}")
    public AngularCalculatorPage selectOperator(String operator) {
        Log.LOG.debug("selecting operator: " + operator);
        (new Select(operatorSelector)).selectByVisibleText(operator);
        return this;
    }

    @Step("Click on Go button")
    public AngularCalculatorPage clickGoButton() {
        Log.LOG.debug("clicking on Go button");
        goButton.click();
        return this;
    }

    @Step("Refresh page")
    public AngularCalculatorPage refreshPage() {
        Log.LOG.debug("refreshing page");
        driver.navigate().refresh();
        return this;
    }

    @Step("Wait for result and get result text")
    public String getTextResult() {
        Log.LOG.debug("waiting for result");
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOf(calculationResultList));
        Log.LOG.debug("getting result text");
        return calculationResult.getText();
    }

    public static String getCalculationResult(AngularCalculatorPage angularCalculatorPage,
                                              String firstNumber, String secondNumber, String operator) {
        angularCalculatorPage.refreshPage().
                typeFirstNumberField(firstNumber).
                typeSecondNumberField(secondNumber).
                selectOperator(operator).
                clickGoButton();
        return angularCalculatorPage.getTextResult();
    }

}
