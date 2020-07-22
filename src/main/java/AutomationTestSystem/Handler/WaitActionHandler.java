package AutomationTestSystem.Handler;

import AutomationTestSystem.Base.TestStep;

import java.util.concurrent.TimeUnit;

/**
 * 等待动作处理类
 */
public class WaitActionHandler {
	
	/**
	 * 强制等待
	 * @param
	 * @param step
	 */
	public void waitForced(TestStep step){
		try {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			String waitTime = step.getValue();
			Thread.sleep(Long.valueOf(waitTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
