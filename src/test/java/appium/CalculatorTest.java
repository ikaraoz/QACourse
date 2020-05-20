<<<<<<< HEAD


package appium;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
=======
package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
>>>>>>> upstream/master

public class CalculatorTest {

    static AppiumDriver driver;
<<<<<<< HEAD
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
=======
    static WebDriverWait wait;

    public static MobileElement waitForVisible(By by){
        wait=new WebDriverWait(driver,10);
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public static void main(String... args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel API 28");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset",true);

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

        waitForVisible(By.id("com.android.calculator2:id/digit_7")).click();
        waitForVisible(By.id("com.android.calculator2:id/op_add")).click();
        waitForVisible(By.id("com.android.calculator2:id/digit_9")).click();
        waitForVisible(By.id("com.android.calculator2:id/eq")).click();
        String result = waitForVisible(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals("16",result);

>>>>>>> upstream/master
    }
}
