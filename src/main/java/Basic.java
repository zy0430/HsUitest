import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Basic{
    private AndroidDriver driver;
    private MobileDriver mobileDriver;
    private AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "c57caa58");
        desiredCapabilities.setCapability("platformVersion", "8.1.0");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("--------------------start--------------------");

    }

//    @Test
//    public void plus() throws InterruptedException {
//       driver.findElementById("com.hsrg.ihealth:id/btnSixth").click();
//        System.out.println("-----------------start-----------------");
//        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.hsrg.ihealth:id/btnFourth")));
//    }


//    @AfterClass
//    public void tearDown() throws Exception {
//        Thread.sleep(3000);
//        driver.quit();
//        System.out.println("--------------------end--------------------");
//    }
}
