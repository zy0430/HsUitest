package base;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestParameterXML3 {
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("XML3Before test-class. Thread id is: " + id);
    }

    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("XML3Sample test-method One. Thread id is: " + id);
    }

    @Test
    public void testMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("XML3Sample test-method Two. Thread id is: " + id);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("XML3After test-class. Thread id is: " + id);
    }
}
