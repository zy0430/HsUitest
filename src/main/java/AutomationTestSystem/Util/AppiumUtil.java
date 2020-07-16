package AutomationTestSystem.Util;

import AutomationTestSystem.Base.TestStep;
import com.sun.xml.internal.bind.v2.TODO;
import org.jsoup.helper.StringUtil;
import org.openqa.selenium.WebElement;

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
        // TODO 1

    }
}
