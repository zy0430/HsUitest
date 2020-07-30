package AutomationTestSystem.PageAndValue.sendvalues;


public enum SportsRecoveryPageValue {
    NAMEINPUT("recover_nameInput", "简单测试");

    private String type;

    private String value;

    private SportsRecoveryPageValue(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public static String getValue(String type) {
        SportsRecoveryPageValue[] carTypeEnums = values();
        for (SportsRecoveryPageValue carTypeEnum : carTypeEnums) {
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
        return this.value;
    }
}
