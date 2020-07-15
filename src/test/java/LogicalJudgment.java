import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LogicalJudgment {
    public static boolean byElementIsExist(AndroidDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
