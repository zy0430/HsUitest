package AutomationTestSystem.PageAndValue;

public enum SportsRecoveryPage {
    NAMEINPUT("recover_nameInput", "resource-id=com.hsrg.ihealth:id/et_condition");

    private String type;

    private String desc;

    private SportsRecoveryPage(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static String getValue(String type) {
        SportsRecoveryPage[] carTypeEnums = values();
        for (SportsRecoveryPage carTypeEnum : carTypeEnums) {
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
