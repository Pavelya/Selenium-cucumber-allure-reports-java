package methods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;

public class ScreenShotMethods implements BaseTest {
	/** Method to take screen shot and save in ./Screenshots folder */
	public void takeScreenShot() throws IOException {

		Log.INFO("Taking snapshot");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		// System.out.println(dateFormat.format(cal.getTime()));

		// String scrFilepath = scrFile.getAbsolutePath();
		// System.out.println("scrFilepath: " +scrFilepath);

		File currentDirFile = new File("Screenshots");
		String path = currentDirFile.getAbsolutePath();
		// System.out.println("path: " +path+"+++");

		// System.out.println("****\n"+path+"//screenshot"+dateFormat.format(cal.getTime())+".png");

		FileUtils.copyFile(scrFile, new File(path + "//screenshot" + dateFormat.format(cal.getTime()) + ".png"));

	}
}
