package AutomationTestSystem.Handler;

import AutomationTestSystem.Base.TestStep;

import java.util.concurrent.TimeUnit;

public class ClickActionHandler {
    public void webclick(TestStep step) throws Exception {
        System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
        step.getWdriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

    }
}
