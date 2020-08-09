package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class    Basic4 {

    @BeforeTest
    public void test2() {
        System.out.println("before test");
    }

    @Test(groups = "g1")
    public void test1() {
        System.out.println("马上要执行方法啦");
    }

    @BeforeMethod
    public void test3() {
        System.out.println("before methods");
    }

    @AfterClass(groups = "g1")
    public void test5() {
        System.out.println("after class");
    }
}
