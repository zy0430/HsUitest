package AutomationTestSystem.Util;

import AutomationTestSystem.PageAndValue.Login;

public class LocatorType {
    public static String selectLocator(String loc_eum) {
        if (loc_eum.startsWith("login_")) {
            return Login.getValue(loc_eum);
        }
        return null;
    }
}
