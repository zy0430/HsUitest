package AutomationTestSystem.Handler;

import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Util.AppiumUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SlideActionHandler {

    public void androidSlide(TestStep step) throws Exception {
        System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
        AppiumUtil.getSlidePoint(step);
    }
}
