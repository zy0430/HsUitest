package TestCases;

import AutomationTestSystem.Base.TestUnit;
import AutomationTestSystem.Service.AndroidXmlParseService;
import AutomationTestSystem.Service.RunUnitService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FeerLogin {
    private static RunUnitService runService;

    @BeforeTest
    private void stup() throws Exception {
        String MIPad4 = "c57caa58";
        String MI8 = "4768db32";
        TestUnit testUnit = AndroidXmlParseService.parse("xx.apk", "xx", "Android", "10.0", MI8, "TestCaseXml/FreeLogin.xml");
        runService = new RunUnitService(testUnit);
        System.out.println("-----------------------------------【微信登录流程的测试场景点】-----------------------------------");
    }

    @Test
    public void case1() throws Exception {
        runService.runCase("case1");
    }

    @Test
    public void case2() throws Exception {
        runService.runCase("case2");
    }
}
