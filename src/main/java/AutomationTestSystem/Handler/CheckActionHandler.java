package AutomationTestSystem.Handler;

import org.testng.Assert;
import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Util.AppiumUtil;

public class CheckActionHandler {
    public void androidCheck(TestStep testStep) throws Exception {
        String Actual = AppiumUtil.getElement(testStep).getAttribute("name");
        String Expected = AppiumUtil.parseStringHasEls(testStep.getExpect());
        String FailHint = testStep.getMessage();
        String CaseID = testStep.getCaseid();
        System.out.println("『正常测试』开始执行: " + "<" + testStep.getDesc() + ">");
        checkEqualsAndroid(Actual, Expected, FailHint);
    }

    public void checkEqualsAndroid(String Actual, String Expected, String FailHint) throws InterruptedException {
        try {
            Assert.assertEquals(Actual, Expected, FailHint);
            Thread.sleep(500);
        } catch (Error | InterruptedException e) {
            // TODO 这里缺个截图功能
            Assert.fail(FailHint + "  " + "Actual 【" + Actual + "】" + "  " + "but found 【" + Expected + "】");
        }
    }
}
