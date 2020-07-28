package TestCases;

import AutomationTestSystem.Base.TestUnit;
import AutomationTestSystem.Service.AndroidXmlParseService;
import AutomationTestSystem.Service.RunUnitService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WeChatLogin {
    private static RunUnitService runService;

    @BeforeTest
    private void stup() throws Exception {
        TestUnit testUnit = AndroidXmlParseService.parse("WeChat.apk", "com.tencent.mm", "Android", "10.0", "4768db32", "TestCaseXml/WeChatLogin.xml");
        runService = new RunUnitService(testUnit);
        System.out.println("-----------------------------------【微信登录流程的测试场景点】-----------------------------------");
    }

    @Test
    public void case1() throws Exception {
        runService.runCase("case1");
    }
}
