package AutomationTestSystem.Handler;

import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Util.AppiumUtil;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ClearActionHandler {
    public void androidClear(TestStep step) throws Exception {
        System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
        step.getAdriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement e = AppiumUtil.getElement(step);
        e.clear();
    }
}
