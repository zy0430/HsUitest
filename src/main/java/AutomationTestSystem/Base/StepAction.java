package AutomationTestSystem.Base;

import AutomationTestSystem.Handler.ClickActionHandler;

import java.util.HashMap;
import java.util.Map;

public enum StepAction {

    ADDITION("addition", "加法测试", ClickActionHandler.class);

    private String key;

    private String desc;

    private Class<?> handler;

    private static Map<String,StepAction> map;

    static{
        map = new HashMap<String,StepAction>();
        for(StepAction action : StepAction.values()){
            map.put(action.key(), action);
        }
    }

    private StepAction(String key, String desc, Class<?> handler) {
        this(key, desc);
        this.handler = handler;
    }

    private StepAction(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static StepAction action(String name) {
        return map.get(name);
    }
    public String key(){
        return this.key;
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

    public Class<?> handler() {
        return this.handler;
    }

    public void run(TestStep step) throws Exception{

    }
}
