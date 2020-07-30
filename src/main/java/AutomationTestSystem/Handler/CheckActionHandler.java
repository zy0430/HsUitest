package AutomationTestSystem.Handler;

import AutomationTestSystem.Service.AndroidXmlParseService;
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
        checkEqualsAndroid(Actual, Expected, FailHint, CaseID);
    }

    public void checkEqualsAndroid(String Actual, String Expected, String FailHint, String CaseID) throws InterruptedException {
        try {
            Assert.assertEquals(Actual, Expected, FailHint);
            Thread.sleep(500);
        } catch (Error | InterruptedException e) {
            AndroidXmlParseService.screenShot(CaseID);
            Assert.fail(FailHint + "  " + "Actual 【" + Actual + "】" + "  " + "but found 【" + Expected + "】");
        }
    }
}
