package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser) throws MalformedURLException {


        /*************** parameter to use selenium Grid to across and parallel execution*******************/
        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", "Windows");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            driver.navigate().to("http://opencart.abstracta.us/");

      /*      String nodURL = "http://192.168.56.1:6666";
            System.out.println("chrome");
            DesiredCapabilities cap1 = new DesiredCapabilities();
            cap1.setBrowserName("chrome");
            //cap1.setPlatform(Platform.ANY);
            cap1.setPlatform(Platform.WIN10);

            driver = new RemoteWebDriver(new URL(nodURL), cap1);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            driver.navigate().to("http://opencart.abstracta.us/");*/
        } else
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setCapability("platformName", "Windows");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), ffOptions);

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.navigate().to("http://opencart.abstracta.us/");
        } else
            if (browser.equalsIgnoreCase("MicrosoftEdge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("platformName", "Windows");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.navigate().to("http://opencart.abstracta.us/");

        } /*else if (browser.equalsIgnoreCase("opera")) {

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("platformName", "Windows");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.navigate().to("http://opencart.abstracta.us/");


        }*/
        /*driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("http://opencart.abstracta.us/");*/

    }

        //http://192.168.56.1:4444

        /******** selenium webdriver  *********/
        /*if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("opera")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/operadriver.exe");
            driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("http://opencart.abstracta.us/");
    }*/

    @AfterSuite
    public void  stopDriver(){
        driver.quit();
    }
}

