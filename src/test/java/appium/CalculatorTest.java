

package appium;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class CalculatorTest {

    static AppiumDriver driver;
    //Both androiddriver and the iosdriver extends from AppiumDriver.
    //If the tests will be used for two different platforms,
    // then it might be good to use AppiumDriver. This is where the request is going


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        setup();
    }

    public static void setup() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities(); //This is setting up a new set of Desiredcapabilities.

        caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel API 29");
        caps.setCapability("appPackage", "com.google.android.calculator"); //these two information come from the info of the class
        caps.setCapability("appActivity", ".ApiDemos");
      //  caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        URL url = new URL("http://localhost:4723/wd/hub");
        /*
        This could be a remote server too.
         */
        URL url2 = new URL("http://127.0.0.1:4723/wd/hub");
        URL url3 = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(url, caps);

        driver.quit();
    }
}
