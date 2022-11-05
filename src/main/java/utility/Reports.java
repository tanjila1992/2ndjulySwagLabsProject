package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports createReports() {
		ExtentSparkReporter html=new ExtentSparkReporter("SwaglabReports.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(html);
		reports.setSystemInfo("Created By","Tanjila");
		reports.setSystemInfo("Type","Regression");
		return reports;
	}

}
