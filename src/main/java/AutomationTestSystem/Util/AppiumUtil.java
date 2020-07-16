package AutomationTestSystem.Util;

import AutomationTestSystem.Base.TestStep;
import com.sun.xml.internal.bind.v2.TODO;
import org.jsoup.helper.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppiumUtil {
    public static WebElement getElement(TestStep step) throws Exception{
        String loc = step.getLocator();
        if (StringUtil.isBlank(loc)) {
            throw new Exception("当前步骤未定位到任何控件元素！");
        }
        if (loc.lastIndexOf("[") < 0) {
            loc = loc + "[0]";
        }
        int idx1 = loc.indexOf("="), idx2 = loc.indexOf("[");
        if (idx1 == -1 || idx2 == -1 || idx2 < idx1) {
            throw new Exception("step元素locator属性格式有误！");
        }
        String locatorname = loc.substring(0, idx1);
        String locatorvalue = loc.substring(idx1 + 1, idx2);
        int locindex = Integer.valueOf(loc.substring(idx2+1,loc.length()-1));
        List<WebElement> e =null;
        switch (locatorname) {
            case "resource-id": {
                e = step.getAdriver().findElements(By.id(locatorvalue));
                break;
            }
            case "text":
                e = step.getAdriver().findElementsByAndroidUIAutomator("new UiSelector().text(\""+locatorvalue+"\")");

                String A = "213";
                String B = "" + A + "";

        }
    }
}
