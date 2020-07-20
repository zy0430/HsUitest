package AutomationTestSystem.Base;

import java.util.Map;

public class TestStep extends TestBase{
    private StepAction action;

    private String locator;

    private String desc;

    private Map<String, String> details;

    private String key;

    private String keys;

    private String expect;

    private String caseid;

    private String url;

    private String body;

    public StepAction getAction() {
        return action;
    }

    public void setAction(StepAction action) {
        this.action = action;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "TestStep{" +
                "action='" + action + '\'' +
                ", locatoe='" + locator + '\'' +
                ", desc='" + desc + '\'' +
                ", details=" + details +
                ", key='" + key + '\'' +
                ", keys='" + keys + '\'' +
                ", expect='" + expect + '\'' +
                ", caseid='" + caseid + '\'' +
                ", url='" + url + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
