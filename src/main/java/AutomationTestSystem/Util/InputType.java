package AutomationTestSystem.Util;

import AutomationTestSystem.PageAndValue.Login;
import AutomationTestSystem.PageAndValue.SoftIcons;
import AutomationTestSystem.PageAndValue.SportsRecoveryPage;
import AutomationTestSystem.PageAndValue.sendvalues.LoginValue;
import org.openqa.selenium.WebElement;

public class InputType {
    public static void inputValue(String value, WebElement e) throws Exception {
        if (value.startsWith("login_")) {
            String value1 = LoginValue.getValue(value);
            e.sendKeys(AppiumUtil.parseStringHasEls(value1));
        }
    }
}
