package AutomationTestSystem.Util;

import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.PageAndValue.Login;
import AutomationTestSystem.PageAndValue.SoftIcons;
import AutomationTestSystem.PageAndValue.SportsRecoveryPage;
import org.jsoup.helper.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppiumUtil {

    public static Map<String,Object> localmap = new HashMap<>();

    public static WebElement getElement(TestStep step) throws Exception{
        String loc_eum = step.getLocator();
        if (StringUtil.isBlank(loc_eum)) {
            throw new Exception("当前步骤未定位到任何控件元素！");
        }
        // 判断 locator 的类型
        String loc = LocatorType.selectLocator(loc_eum);

        if (StringUtil.isBlank(loc)) {
            throw new Exception("当前locator的前缀再系统中不存在");
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

    public static String parseStringHasEls(String str) throws Exception{
        int start = -1,end = -1;
        String res = str;
        do{
            start = str.indexOf("${", end);
            end = str.indexOf("}",start);
            if(end == -1 || start ==-1) break;

            String substr = str.substring(start,end+1);
            //解析EL表达式
            Object val =parseEL(substr);

            if(val instanceof List)
                throw new Exception("类型错误，字符串中的取值表达式的获取结果是一个 List 类型！");

            res = res.replace(substr, val.toString());
        }while(end < str.length());
        return res;
    }

    public static Object parseEL(String str) throws Exception{
//		System.out.println("EL表达式： "+str);
        //去除 ${ 和 }
        String temp = str.trim().substring(2,str.length()-1);
        String[] s = temp.split("\\.");

        Map<String,Object> map = localmap;
        String key;
        int index = -1,idp=-1;

        for(int i = 0;i < s.length;i++){
            String st = s[i];
            index = -1;
            idp = st.lastIndexOf("[");
            key = st;
            if(idp > 0) {
                index = Integer.valueOf(st.substring(idp+1,st.length()-1));
                key = st.substring(0,idp);
            }
            Object o = map.get(key.toUpperCase());

            //处理索引
            if(index > -1){
                if(o instanceof List){
                    o = ((List) o).get(index);
                }else{
                    throw new Exception(st+"对应的值不是列表，索引无效！");
                }
            }

            //判断最后一个元素
            if(i == s.length-1){
                return o;
            }else{
                try{
                    map = (Map)o;
                }catch(ClassCastException e){
                    System.err.println(e.getMessage());
                    throw new Exception(st+"对应的值不是键值对集合，无法继续获取值！");
                }
            }
        }
        return null;
    }

}
