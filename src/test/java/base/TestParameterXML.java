package base;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestParameterXML {

    @DataProvider(name = "hand")
    public Object[][] test1(ITestContext iTestContext) {

        Object[][] result = null;

        for (String group : iTestContext.getIncludedGroups()) {
            if ("x1".equals(group)) {
                result = new Object[][]{{1}};
                break;
            }
        }
        if (result == null) {
            result = new Object[][]{{2}};
        }

        return result;

    }

    @Test(dataProvider = "hand", groups = "x1")
    public static void test2(int number) {
        System.out.println("1111111111111");
        Assert.assertEquals(number, 1);
    }

    @Test(dataProvider = "hand", groups = "x2")
    public static void test3(int number) {
        System.out.println("22222222222");
        Assert.assertEquals(number, 2);
    }
}
