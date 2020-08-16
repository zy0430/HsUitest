package base.base2;

import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

public class TestListen {

    @Parameters("color1")
    @Test
    public void test(@Optional String color) {
        System.out.println(color);
    }
}
