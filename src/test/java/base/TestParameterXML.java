package base;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestParameterXML {

   @Test(groups = "g2")
   public void test1() {
       System.out.println("this is XML test");
   }

   @BeforeGroups()
   public void test2() {
       System.out.println("before groups");
   }
}
