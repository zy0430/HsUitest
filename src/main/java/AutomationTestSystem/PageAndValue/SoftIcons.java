package AutomationTestSystem.PageAndValue;

public enum SoftIcons {
    FREE("free_icon", "content-desc=FREE呼吸");

    private String type;

    private String desc;

    private SoftIcons(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static String getValue(String type) {
        SoftIcons[] carTypeEnums = values();
        for (SoftIcons carTypeEnum : carTypeEnums) {
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
