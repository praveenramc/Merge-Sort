import java.text.DecimalFormat;
import java.text.NumberFormat;


public class TimerUtil {
	
	private long startTime;
	private long endTime;
	private String runTime;
	
	
	TimerUtil() {
		this.startTime = System.currentTimeMillis();
		this.endTime = 0;
		this.runTime = null;
	}
	
	public void startTimer() {
		startTime = System.currentTimeMillis();
	}
	
	public void endTimer() {
		endTime = System.currentTimeMillis();
		runningTime();
	}
	
	private void runningTime() {
		NumberFormat formatter = new DecimalFormat("#0.00000");
		runTime = formatter.format((endTime - startTime) / 1000d).toString();
	}
	
	public String getRunningTime() {
		return runTime;
	}
}
