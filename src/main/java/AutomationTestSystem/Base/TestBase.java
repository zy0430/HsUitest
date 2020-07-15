package AutomationTestSystem.Base;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public class TestBase {
    private String id;

    private String name;

    private boolean cancel;

    private WebDriver Wdriver;

    private AndroidDriver<WebElement> Adriver;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public WebDriver getWdriver() {
        return Wdriver;
    }

    public void setWdriver(WebDriver wdriver) {
        Wdriver = wdriver;
    }

    public AndroidDriver<WebElement> getAdriver() {
        return Adriver;
    }

    public void setAdriver(AndroidDriver<WebElement> adriver) {
        Adriver = adriver;
    }

    @Override
    public String toString() {
        return "TestBase{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cancel=" + cancel +
                ", Wdriver=" + Wdriver +
                ", Adriver=" + Adriver +
                '}';
    }
}
