package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public AngularCalculatorPage typeFirstNumberField(String firstNumber) {
        firstNumberField.sendKeys(firstNumber);
        return this;
    }

    public AngularCalculatorPage typeSecondNumberField(String secondNumber) {
        secondNumberField.sendKeys(secondNumber);
        return this;
    }

    public AngularCalculatorPage selectOperator(String operator) {
        (new Select(operatorSelector)).selectByVisibleText(operator);
        return this;
    }

    public AngularCalculatorPage clickGoButton() {
        goButton.click();
        return this;
    }

    public String getTextResult() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOf(calculationResultList));
        return calculationResult.getText();
    }

    public static String getCalculationResult(WebDriver driver,
                                              String firstNumber, String secondNumber, String operator) {
        AngularCalculatorPage angularCalculatorPage = new AngularCalculatorPage(driver);
        angularCalculatorPage.typeFirstNumberField(firstNumber).
                typeSecondNumberField(secondNumber).
                selectOperator(operator).
                clickGoButton();
        return angularCalculatorPage.getTextResult();
    }

}
