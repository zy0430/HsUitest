package base;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Basic3 {

    @Test(dataProvider = "dataProvider", groups = {"AA"})
    public void test1(int number) {
        Assert.assertEquals(number, 1);
    }

    @Test(dataProvider = "dataProvider", groups = {"BB"})
    public void test2(int number) {
        Assert.assertEquals(number, 2);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] method1(ITestContext iTestContext) {
        Object[][] result = null;
        for (String group : iTestContext.getIncludedGroups()) {
            if ("groupsA".equals(group)) {
                result = new Object[][]{{1}};
                break;
            }
        }
        if (result == null) {
            result = new Object[][]{{2}};
        }
        return result;
    }
}
