import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AngularCalculatorPage;

public class BaseTest {

    protected WebDriver driver;
    AngularCalculatorPage angularCalculatorPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        //ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testResult() {
        angularCalculatorPage = new AngularCalculatorPage(driver);
        angularCalculatorPage.typeFirstNumberField("10").
                typeSecondNumberField("20").
                selectOperator("+").
                clickGoButton();
        System.out.println(angularCalculatorPage.getTextResult());
    }

}
