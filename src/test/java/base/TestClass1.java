package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass1 {
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @BeforeClass
    public void beforeClass() {
        System.out.println("Start time：" + df.format(new Date()));
    }


    @Test(dataProvider = "testdp", threadPoolSize = 1, invocationCount = 1, successPercentage = 98)
    public void test(String number) throws InterruptedException{
        System.out.println("当前线程:" + Thread.currentThread().getId() + "当前id:" + number);
    }


    @DataProvider(name = "testdp", parallel = true)
    public static Object[][] testdp() {
        return new Object[][]
                {{"1 "}, {"2 "}};
    }

    @AfterClass
    public void afterClass() {
        System.out.println("End time：" + df.format(new Date()));
    }

}
