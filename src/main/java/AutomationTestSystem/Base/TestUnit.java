package AutomationTestSystem.Base;

import java.util.LinkedHashMap;

public class TestUnit extends TestBase{
    private LinkedHashMap<String, TestCase> caseMap;

    public LinkedHashMap<String, TestCase> getCaseMap() {
        return caseMap;
    }

    public void setCaseMap(LinkedHashMap<String, TestCase> caseMap) {
        this.caseMap = caseMap;
    }

    @Override
    public String toString() {
        return "TestUnit{" +
                "caseMap=" + caseMap +
                '}';
    }
}
