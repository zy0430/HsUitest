package AutomationTestSystem.Util;

import AutomationTestSystem.PageAndValue.Login;
import AutomationTestSystem.PageAndValue.SoftIcons;
import AutomationTestSystem.PageAndValue.SportsRecoveryPage;

public class LocatorType {
    public static String selectLocator(String loc_eum) {
        if(loc_eum.startsWith("cal_")) {
            return SoftIcons.getValue(loc_eum);
        }
        if (loc_eum.startsWith("recover_")) {
            return SportsRecoveryPage.getValue(loc_eum);
        }
        if (loc_eum.startsWith("free_")) {
            return SoftIcons.getValue(loc_eum);
        }
        if (loc_eum.startsWith("login_")) {
            return Login.getValue(loc_eum);
        }
        return null;
    }
}
