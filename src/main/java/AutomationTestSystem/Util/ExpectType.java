package AutomationTestSystem.Util;

import AutomationTestSystem.PageAndValue.sendvalues.LoginValue;
import org.openqa.selenium.WebElement;

public class ExpectType {
    public static void expectValue(String value, WebElement e) throws Exception {
        if (value.startsWith("login_")) {
            String value1 = LoginValue.getValue(value);
            e.sendKeys(AppiumUtil.parseStringHasEls(value1));
        }
    }
}
