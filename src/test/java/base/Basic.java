package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Basic{
//    AndroidDriver<WebElement> driver;
    private AndroidDriver driver;
    private MobileDriver mobileDriver;
    private AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("noReset", true);
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "4768db32");
//        desiredCapabilities.setCapability("platformVersion", "10.0");
//        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
//        // 隐式等待
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        System.out.println("--------------------start--------------------");
    }

    @Test
    public void func1() {
        TouchAction tAction = new TouchAction(driver);
        PointOption pressOptions = new PointOption();
        PointOption pressOptions1 = new PointOption();
        WaitOptions waitOptions = new WaitOptions();
        pressOptions.withCoordinates(50, 1000);
        pressOptions1.withCoordinates(1000, 1000);
        waitOptions.withDuration(Duration.ofSeconds(5));
        tAction.press(pressOptions).waitAction(waitOptions).moveTo(pressOptions1).release().perform();
    }

    @Parameters({"color"})
    @Test(groups = {"zy"})
    public void case1(String color) {
        System.out.println(color);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{{"data1"}, {"data2"}, {"data3"}};
    }

    @Test(dataProvider = "data")
    public void case2(String data) {
        System.out.print("testDemo4, " + "data=" + data + "\n");
    }
}
