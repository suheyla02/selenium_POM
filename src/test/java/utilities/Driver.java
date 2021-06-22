package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){
        // bu class'tan obje olusturulmasini engellmek icin
        //default const. yazip acces modifier private yapariz
        //Bunun gibi kendisinden obje olusturmasi kontrol altina alinan classlara singleton class denir
    }
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":

                    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                    desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                    desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.merge(desiredCapabilities);

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }
    }

}
