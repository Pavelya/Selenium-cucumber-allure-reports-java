package methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.tlv.environment.BaseTest;
import com.qa.tlv.logger.Log;

public class ConfigurationMethods implements BaseTest
{	  
	/** Method to print desktop configuration	 */
	public void printDesktopConfiguration()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		Log.INFO("Following are machine configurations : \n");
		Log.INFO("Date (MM/DD/YYYY) and Time (HH:MM:SS) : "+dateFormat.format(cal.getTime()));
		
		Capabilities cap = (Capabilities)((RemoteWebDriver) driver).getCapabilities();
		Log.INFO("Browser : "+cap.getBrowserName());
		Log.INFO("Platform : "+cap.getPlatform());
	}
}
