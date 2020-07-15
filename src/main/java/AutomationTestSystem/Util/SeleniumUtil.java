package AutomationTestSystem.Util;

import AutomationTestSystem.Base.TestStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.jsoup.helper.StringUtil;


public class SeleniumUtil {
    public static WebElement getElement(TestStep step) throws Exception {
        String loc = step.getLocator();
        if (StringUtil.isBlank(loc)) {
            throw new Exception("当前步骤未定位到任何控件元素！");
        }

        int idx1 = loc.indexOf("=");
        String locatorname = loc.substring(0, idx1);
        String locatorvalue = loc.substring(idx1+1);
        WebElement e = null;
        switch(locatorname){
            case "id":
                e = step.getWdriver().findElement(By.id(locatorvalue));
                break;
            case "name":
                e = step.getWdriver().findElement(By.name(locatorvalue));
                break;
            case "xpath":
                e = step.getWdriver().findElement(By.xpath(locatorvalue));
                break;
            case "tagName":
                e = step.getWdriver().findElement(By.tagName(locatorvalue));
                break;
            case "className":
                e = step.getWdriver().findElement(By.className(locatorvalue));
                break;
            case "linkText":
                e = step.getWdriver().findElement(By.linkText(locatorvalue));
                break;
            case "partialLinkText":
                e = step.getWdriver().findElement(By.partialLinkText(locatorvalue));
                break;
            case "cssSelector":
                e = step.getWdriver().findElement(By.cssSelector(locatorvalue));
                break;
            default:
                throw new Exception("step元素locator属性配置有误，'='之前必须为id、name和xpath之一！");

        }
        return e;
    }


}
