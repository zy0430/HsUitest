package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic4 {

    @Test(groups = "g1")
    public void test1() {
        System.out.println("this is g1");
    }

    @Test(groups = "g2")
    public void test2() {
        System.out.println("this is g2");
    }
}
