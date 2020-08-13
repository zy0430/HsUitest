package base.base1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Base1 {
    @DataProvider
    public static Object[][] NoNameMethod(){
        return new Object[][]{
                {"DataWithNoName1"},
                {"DataWithNoName2"},
                {"DataWithNoName3"}
        };
    }
    //指定名称1
    @DataProvider(name="dataprovider1")
    public static Object[][] dataProvider1(){
        return new Object[][]{
                {"dataprovider1-1"},
                {"dataprovider1-2"}
        };
    }
    //指定名称2
    @DataProvider(name="dataprovider2")
    public static Object[][] dataProvider2(){
        return new Object[][]{
                {"dataprovider2-1"},
                {"dataprovider2-2"}
        };
    }
}
