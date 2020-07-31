package AutomationTestSystem.PageAndValue.sendvalues;

public enum LoginValue {
    NAMEINPUT("login_phone", "13111111111"),
    PASSWORDPUT("login_password", "a1234567");

    private String type;

    private String value;

    private LoginValue(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public static String getValue(String type) {
        LoginValue[] carTypeEnums = values();
        for (LoginValue loginValue : carTypeEnums) {
            if (loginValue.type().equals(type)) {
                return loginValue.desc();
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
