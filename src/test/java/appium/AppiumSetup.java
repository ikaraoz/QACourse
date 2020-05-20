package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
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
        caps.setCapability("appPackage", "io.appium.android.apis"); //these two information come from the info of the class
     //   caps.setCapability("appActivity", ".ApiDemos");
      caps.setCapability("appActivity", ".app.Animation");

/*
The package and page information can be found from the info details of the app
In mobile app, each page is an activity, and we find and set these as capacbilities
to perform actions on them.
 */
        URL url = new URL("http://localhost:4723/wd/hub");
        /*
        This is the servers' url.
         */
        URL url2 = new URL("http://127.0.0.1:4723/wd/hub");
        URL url3 = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(url, caps);
        /*
        This is initialising the driver.
         */

        driver.findElementByAccessibilityId("Fade in").click();
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("List dialog").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='Command one']").click();
        driver.quit();

        /*
        Pretty much similar to what we are doing with the selenium. Instead of initialising
        websdriver, we are running AppiumDriver.
        Finding the elements is the same. You find the element and then do operations on it.
        To find the id, or to inspect the element, we go and find it through the Appium session.
         */

    }
}
