package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import testCases.Baseclass;

public class ExtentListenerClass extends Baseclass implements ITestListener  {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {
        String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String ReportName="AutomationpractiesReport-" + timestamp +".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//reports//" + ReportName );

        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // System Information
        reports.setSystemInfo("Machine", "testpc1");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser", "Chrome");
        reports.setSystemInfo("User Name", "Prachi");

        // Report Configuration
        htmlReporter.config().setDocumentTitle("Automation parctice Report Demo");
        htmlReporter.config().setReportName("This is my First Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    
  //Listenerchya unimplimented method sathi right click--> source-->generate override/unimpliment method
    
    
	@Override
	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		configureReport();
		System.out.println("on start method invoked...!");
	}

	@Override
	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		
		reports.flush();
		System.out.println("on finished method invoked...!");
		
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("Name of failed method" + Result.getName());
		test=reports.createTest(Result.getName()); // Create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:-->" + Result.getName(), ExtentColor.RED));
		
		try {
			captureScreenShot(driver, Result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Screenshotpath= ".\\screenshots\\" + Result.getName() + ".png";
		File screenShotFile= new File(Screenshotpath);
		
		if(screenShotFile.exists()) {
			
			test.fail("Captured Screenshot is below:" , MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		}
		}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of Skipped method" + Result.getName());
		test=reports.createTest(Result.getName()); // Create entry in html report
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is:-->" + Result.getName(), ExtentColor.YELLOW));
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of Success method  " + Result.getName());
		test=reports.createTest(Result.getName()); // Create entry in html report
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is:-->" + Result.getName(), ExtentColor.GREEN));
	}


	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println("Name of start method" + Result.getName());
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}


	@Override
	public void onTestFailedWithTimeout(ITestResult Result) {
		
	}
		
	}