package AutomationTestSystem.Handler;

import AutomationTestSystem.Service.AndroidXmlParseService;
import AutomationTestSystem.Util.LocatorType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Util.AppiumUtil;

public class CheckActionHandler {
    public void androidCheck(TestStep testStep) throws Exception {
        String Actual = AppiumUtil.getElement(testStep).getAttribute("resourceId");
        // 判断期望值的前缀
        String expectName = testStep.getExpect();
        String loc = LocatorType.selectLocator(expectName);

        String Expected = AppiumUtil.parseStringHasEls(loc);
        String FailHint = testStep.getMessage();
        String CaseID = testStep.getCaseid();
        System.out.println("『正常测试』开始执行: " + "<" + testStep.getDesc() + ">");
        checkEqualsAndroid("resource-id=" + Actual, Expected, FailHint, CaseID);
    }

    public void checkEqualsAndroid(String Actual, String Expected, String FailHint, String CaseID) throws InterruptedException {
        try {
            Assert.assertEquals(Actual, Expected, FailHint);
            Thread.sleep(500);
        } catch (Error | InterruptedException e) {
            AndroidXmlParseService.screenShot(CaseID);
            Assert.fail(FailHint + "  " + "软件上为 【" + Actual + "】" + "  " + "但期望得到 【" + Expected + "】");
        }
    }
}
