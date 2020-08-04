package base;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Basic2 {

    @Test(dataProvider = "css")
    public void method4(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue()));
        }
    }

    @DataProvider(name = "css")
    public Object[][] method3() {
        Map<String, String> map = new HashMap<>();
        map.put("jdbc.driver", "com.mysql.jdbc.Driver");
        map.put("jdbc.url", "jdbc:mysql://localhost:3306/test");
        map.put("jdbc.username", "root");
        map.put("jdbc.password", "123456");
        return new Object[][]{{map}};
    }

    public static void main(String[] args) {
        Object[][] a = new Object[][]{{"2", "3"}, {"4", "5"}};
        System.out.println(a[1][0]);


    }
}
