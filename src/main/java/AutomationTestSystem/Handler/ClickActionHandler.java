package AutomationTestSystem.Handler;

import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Util.AppiumUtil;

import java.util.concurrent.TimeUnit;

public class ClickActionHandler {
    public void androidClick(TestStep step) throws Exception {
        try {
            System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
            step.getAdriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
            AppiumUtil.getElement(step).click();
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
