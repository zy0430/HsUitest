package AutomationTestSystem.PageAndValue;

public enum Button2 {
    SEVEN("cal_seven", "resource-id=com.miui.calculator:id/digit_7"),
    TWO("cal_two", "resource-id=com.miui.calculator:id/digit_2");

    private String type;

    private String desc;

    private Button2(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static String getValue(String type) {
        Button2[] carTypeEnums = values();
        for (Button2 carTypeEnum : carTypeEnums) {
            if (carTypeEnum.type().equals(type)) {
                return carTypeEnum.desc();
            }
        }
        return null;
    }

    private String type() {
        return this.type;
    }

    private String desc() {
        return this.desc;
    }
}
