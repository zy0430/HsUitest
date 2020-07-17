package AutomationTestSystem.Service;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidXmlParseService {

    static public AndroidDriver<WebElement> driver;

    public static void AppiumConfigure(String PlatformName, String platformVersion, String deviceName, String udid) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "uiautomator2");
        capabilities.setCapability("platformName", PlatformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("sessionOverride", false);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("newCommandTimeout", 6000);
        capabilities.setCapability("noSign", true);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

    }
}
