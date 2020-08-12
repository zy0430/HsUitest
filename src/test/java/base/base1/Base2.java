package base.base1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class Base2 {
    private String str;

    public Base2(String str) {
        this.str = str;
    }
    @Test
    public void test1() {
        System.out.println("this is test1：" + str);
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        System.out.println("this is test2：" + str);
    }
}
