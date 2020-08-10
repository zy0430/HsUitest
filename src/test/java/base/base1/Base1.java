package base.base1;

import org.testng.annotations.Test;

public class Base1 {
    int a = 0;

    @Test(groups = "1")
    public void test1() throws InterruptedException {
        System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test1");
        a += 1;
    }

    @Test(groups = "2", dependsOnMethods = "test1")
    public void test2() {
        if (1 == a) {
            System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test2");
            a += 1;
        }
    }

    @Test(groups = "3")
    public void test3() {
        System.out.println("当前的a为：" + a);
        if (2 == a) {
            System.out.println("当前线程：" + Thread.currentThread().getId() + "：this is test3");
        }
    }
}
