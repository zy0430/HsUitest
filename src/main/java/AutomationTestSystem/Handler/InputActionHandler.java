package AutomationTestSystem.Handler;

import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.PageAndValue.sendvalues.SportsRecoveryPageValue;
import AutomationTestSystem.Util.AppiumUtil;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InputActionHandler {
    public void androidInput(TestStep step) throws Exception {
        System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
        step.getAdriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement e = AppiumUtil.getElement(step);
        e.clear();
        // 需要判断值所在的文件夹。
        if (step.getValue().startsWith("recover_")) {
            String value = SportsRecoveryPageValue.getValue(step.getValue());
            e.sendKeys(AppiumUtil.parseStringHasEls(value));
        }
    }
}
