package TestCases;

import AutomationTestSystem.Base.TestUnit;
import AutomationTestSystem.Service.AndroidXmlParseService;
import AutomationTestSystem.Service.RunUnitService;
import org.junit.Test;

public class WeChatLogin {
    private RunUnitService runService;

    public void stup() throws Exception {
        TestUnit testUnit = AndroidXmlParseService.parse("WeChat.apk", "com.tencent.mm", "Android", "8.1.0", "1f0fc481", "TestCaseXml/WeChatLogin.xml");
        runService = new RunUnitService(testUnit);
        System.out.println("-----------------------------------【微信登录流程的测试场景点】-----------------------------------");
    }

    @Test
    public void case1() {
        runService
    }
}
