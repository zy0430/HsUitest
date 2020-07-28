package AutomationTestSystem.Util;

import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Coordinate.Button2;
import com.sun.xml.internal.bind.v2.TODO;
import org.jsoup.helper.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppiumUtil {
    public static WebElement getElement(TestStep step) throws Exception{
        String loc_eum = step.getLocator();
        if (StringUtil.isBlank(loc_eum)) {
            throw new Exception("当前步骤未定位到任何控件元素！");
        }
        String loc = Button2.getValue("seven");

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
            case "resource-id":
                e = step.getAdriver().findElements(By.id(locatorvalue));
                break;
            case "text":
                e = step.getAdriver().findElementsByAndroidUIAutomator("new UiSelector().text(\""+locatorvalue+"\")");
                break;
            case "class":
                e = step.getAdriver().findElements(By.className(locatorvalue));
                break;
            case "content-desc":
                e = step.getAdriver().findElementsByAccessibilityId(locatorvalue);
                break;
            case "xpath":
                e = step.getAdriver().findElements(By.xpath(locatorvalue));
                break;
            default:
                throw new Exception("step元素locator属性配置有误，'='之前必须为resource-id、text、calss、content-desc和xpath之一！");
        }
        return e==null?null:e.get(locindex);
    }
}
