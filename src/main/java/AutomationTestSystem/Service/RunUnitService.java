package AutomationTestSystem.Service;

import AutomationTestSystem.Base.StepAction;
import AutomationTestSystem.Base.TestCase;
import AutomationTestSystem.Base.TestStep;
import AutomationTestSystem.Base.TestUnit;
import org.springsource.loaded.C;
import org.testng.Reporter;

import java.lang.reflect.Method;
import java.util.List;

public class RunUnitService {
    private TestUnit testUnit;

    public RunUnitService(TestUnit testUnit) {
        this.testUnit = testUnit;
    }

    public void runCase(String id) throws Exception {
        TestCase testCase = getCase(id);
        List<TestStep> testSteps = testCase.getSteps();
        for (TestStep testStep : testSteps) {
            if (testCase.isCancel()) {
                continue;
            }
            StepAction stepAction = testStep.getAction();
            Class<?> clzss = stepAction.handler();
            if (clzss != null) {
                String key = testStep.getAction().getKey();
                Method m = clzss.getDeclaredMethod(getMethodName(key), new Class<?>[]{TestStep.class});
                m.invoke(clzss.newInstance(), testStep);
            } else {
                stepAction.run(testStep);
            }
        }
        TestReportRemarks(testCase.getName());
    }

    public TestCase getCase(String id) {
        return testUnit.getCaseMap() == null ? null : testUnit.getCaseMap().get(id);
    }

    private String getMethodName(String actionKey) throws Exception {
        if (actionKey == null || "".equals(actionKey)) {
            throw new Exception("empty action key");
        }
        char[] arr = actionKey.toCharArray();
        char prevChar = '\0';
        StringBuilder sb = new StringBuilder();
        char splitChar = '-';
        for (char c : arr) {
            if (c == splitChar) {
                prevChar = c;
                continue;
            }
            if (prevChar == splitChar) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
            prevChar = c;
        }
        return sb.toString();
    }

    public void TestReportRemarks(String RemarksName) {
        Reporter.log(RemarksName);
    }
}
