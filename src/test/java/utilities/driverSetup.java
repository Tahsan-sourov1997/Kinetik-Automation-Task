package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class driverSetup {
    private static String browser_name = System.getProperty("browser","chrome");
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        driverSetup.LOCAL_DRIVER.set(driver);

    }
    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();

    }
    @BeforeSuite
    public void openABrowser(){
        WebDriver driver = getDriver(browser_name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        setDriver(driver);

    }
    @AfterSuite
    public void closeBrowser(){
        getDriver().quit();

    }

    public WebDriver getDriver(String browser_name){
        if(browser_name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (browser_name.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (browser_name.equalsIgnoreCase("edge"))
            return new EdgeDriver();
        else{
            throw new RuntimeException("Browser not available");
        }

    }
}
