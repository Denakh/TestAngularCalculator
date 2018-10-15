import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AngularCalculatorPage;

public class BaseTest {

    protected WebDriver driver;
    protected AngularCalculatorPage angularCalculatorPage;

    //@BeforeMethod(alwaysRun = true)
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        //ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
        angularCalculatorPage = new AngularCalculatorPage(driver);
    }

    //@AfterMethod(alwaysRun = true)
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.close();
    }


}
