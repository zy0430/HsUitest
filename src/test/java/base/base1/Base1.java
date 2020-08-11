package base.base1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

    @Test()
    public String test1() {
        return "aa";
    }

    @Test
    public void test2() {
        System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test2");
    }

    @Test
    public void test3() {
        System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test3");
    }

    @Test
    public void test4() {
        System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test4");
    }
}
