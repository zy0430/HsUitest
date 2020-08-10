package base.base1;

import org.testng.annotations.Test;

public class Base1 {
    @Test(groups = "1")
    public void test1() {
        System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test1");
    }

    @Test(groups = "2")
    public void test2() {
        System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test2");
    }
}
