package base;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic4 {

    @Test
    @Parameters({"name1", "color"})
    public void test1(String color, String name1) {
        System.out.println("this color is:" + color);
    }
}
