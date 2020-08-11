package base.base1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Base1 {

//    @BeforeClass
//    public void beforeTest() {
//        int a = 100/0;
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("调用方法前");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("调用方法后");
//    }

    @Test(dataProvider = "str")
    public void test1(String num) {
        System.out.println("test1：" + num + "★线程id：" + Thread.currentThread().getId());
    }

    @Test(dataProvider = "str")
    public void test2(String num) {
        System.out.println("test2：" + num + "★线程id：" + Thread.currentThread().getId());
    }

    @Test(dataProvider = "str")
    public void test3(String num) {
        System.out.println("test3：" + num + "★线程id：" + Thread.currentThread().getId());
    }

    @DataProvider(name = "str", parallel = true)
    public Object[][] dataprovider() {
        return new Object[][]{{"1"}, {"2"}, {"3"}, {"4"}, {"5"}, {"6"}};
    }
}
