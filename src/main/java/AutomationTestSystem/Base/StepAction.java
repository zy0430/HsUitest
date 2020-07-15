package AutomationTestSystem.Base;

import AutomationTestSystem.Handler.ClickActionHandler;

public enum StepAction {

    ADDITION("addition", "加法测试", ClickActionHandler.class);

    private String key;

    private String desc;

    private Class<?> handler;

    private StepAction(String key, String desc, Class<?> handler) {
        this(key, desc);
        this.handler = handler;
    }

    private StepAction(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class<?> getHandler() {
        return handler;
    }

    public void setHandler(Class<?> handler) {
        this.handler = handler;
    }
}
