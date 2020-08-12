package base.base1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class Base1 {
    @Factory(dataProvider = "zz")
    public Object[] test1(int num) {
        Object[] objects = new Object[num];
        for (int i=0; i<num; i++) {
            Base2 base2 = new Base2(i+"");
            objects[i] = base2;
        }
        return objects;
    }

    @DataProvider(name = "zz")
    public Object[][] num() {
        return new Object[][]{new Object[]{3}};
    }
}
