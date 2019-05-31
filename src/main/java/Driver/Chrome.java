package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 22.05.2019.
 */
public class Chrome {
    public WebDriver driver;

    public void setDriver() {
        //this.driver = driver;
        System.setProperty("webdriver.chrome.driver", "c:\\Program Files (x86)\\webdriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("window-size=1440,900");


        driver = new ChromeDriver(chromeOptions); //для рабты в режиме "--headless" строка должна выглядеть так - driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        //return  driver;
        }
}
