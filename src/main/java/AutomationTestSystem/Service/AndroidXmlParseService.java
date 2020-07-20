package AutomationTestSystem.Service;

import java.io.File;

import AutomationTestSystem.Base.StepAction;
import AutomationTestSystem.Base.TestCase;
import AutomationTestSystem.Base.TestStep;
import org.openqa.selenium.WebElement;
import AutomationTestSystem.Base.TestUnit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AndroidXmlParseService {

    static public AndroidDriver<WebElement> driver;

    public static void AppiumConfigure(String ApkName,String ApkPackageName, String PlatformName, String platformVersion, String deviceName, String udid) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "uiautomator2");
        capabilities.setCapability("platformName", PlatformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("sessionOverride", false);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("newCommandTimeout", 6000);
        capabilities.setCapability("noSign", true);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    public static TestUnit parse(String ApkName,String ApkPackageName,String PlatformName,String PlatformVersion,String DeviceID,String XmlPath) throws IOException, SAXException, ParserConfigurationException {
        try {
            System.out.println("当前为重新安装APK，初始化Android设备,耐心等待App启动ing...");
            AppiumConfigure(ApkName, ApkPackageName, PlatformName, PlatformVersion, DeviceID, XmlPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parse(new File("src/test/java/"+XmlPath));
    }

    public static TestUnit parse(File xmlFile) throws ParserConfigurationException, IOException, SAXException {
        TestUnit testUnit = null;

        if ( xmlFile == null || !xmlFile.exists()  )
            return testUnit;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);
            Element root = doc.getDocumentElement();
            NodeList cases = root.getElementsByTagName("case");
            //存放case的map
            LinkedHashMap<String, TestCase> caseMap = new LinkedHashMap<String, TestCase>();
            Element child;
            TestCase testCase;

            //逐个解析xml中的case元素
            for (int i = 0; i < cases.getLength(); i++) {
                child = (Element) cases.item(i);
                testCase = parseTestCase(child);

                if (testCase == null)
                    continue;

                if (caseMap.containsKey(testCase.getId()))
                    throw new RuntimeException("存在多个" + testCase.getId() + "，请检查id配置");
                else
                    caseMap.put(testCase.getId(), testCase);
            }

            testUnit = new TestUnit();
            testUnit.setCaseMap(caseMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testUnit;
    }

    private static TestCase parseTestCase(Element element) {
        if (element == null)
            return null;

        NamedNodeMap attrs = element.getAttributes();
        //根据case的属性实例化TestCase，并注入相应字段值
        TestCase testCase = initByAttributes(attrs, new TestCase());

        NodeList stepNodes = element.getElementsByTagName("step");
        int len = stepNodes.getLength();
        List<TestStep> stepList = new ArrayList<TestStep>(len);

        Element stepNode;
        //逐个解析case元素的step子元素
        for (int i = 0; i < len; i++) {
            stepNode = (Element) stepNodes.item(i);
            stepList.add(parseTestStep(stepNode));
        }
        testCase.setSteps(stepList);

        return testCase;
    }

    private static <T> T initByAttributes(NamedNodeMap attrs, T t) {
        if (attrs == null || attrs.getLength() == 0)
            return t;

        int len = attrs.getLength();
        Node attr;
        String name, value;

        //通过反射逐个注入字段值
        for (int i = 0; i < len; i++) {
            attr = attrs.item(i);
            if (attr == null) continue;

            name = attr.getNodeName();
            value = attr.getNodeValue();
            //通过反射为对象的对应字段注入值
            initByReflect(name, value, t);
        }
        return t;
    }

    private static TestStep parseTestStep(Element element) {
        if (element == null)
            return null;

        TestStep testStep = initByAttributes(element.getAttributes(), new TestStep());
        testStep.setAdriver(driver);

        return testStep;
    }

    private static <T> T initByReflect(String name, String value, T t) {
        if (t == null)
            throw new RuntimeException("null object");
        if (name == null || "".equals(name))
            throw new RuntimeException("empty name");

        Class<?> clazz = t.getClass();
        Method setter, getter;

        try {
            String methodStr = name.substring(0, 1).toUpperCase() + name.substring(1);

            //如果名称是cancel，则调用isCancel()方法，主要是为了语义上的直观
            getter = clazz.getMethod(("cancel".equals(name) ? "is" : "get") + methodStr, new Class<?>[] {});
            setter = clazz.getMethod("set" + methodStr, getter.getReturnType());

            if ("action".equals(name))
                //根据StepAction类中的map来获取名称对应的StepAction（枚举）实例
                setter.invoke(t, StepAction.action(value));
            else if ("cancel".equals(name))
                setter.invoke(t, "true".equals(value) ? true : false);
            else if("details".equals(name))
                setter.invoke(t,parseDetail(value));
            else
                setter.invoke(t, value);
        } catch (Exception e) {
//			System.out.println("对象反射初始化失败");
//			e.printStackTrace();
        }
        return t;
    }

    public static Map<String,String> parseDetail(String detail){
        HashMap<String,String> map = new HashMap<>();
        String[] strarr = detail.split(";");

        for(String str : strarr){
            map.put(str.split(":")[0], str.split(":")[1]);
        }
        return map;
    }
}
