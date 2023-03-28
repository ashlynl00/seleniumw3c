package com.sauce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class ChromeTest {
	RemoteWebDriver driver;
  @Test
  public void Go_to_Sauce() {
	  driver.get("https://www.saucedemo.com");
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  ChromeOptions browserOptions = new ChromeOptions();
	  browserOptions.setCapability("platformName", "macOS 12");
	  browserOptions.setCapability("browserVersion", "latest-1");
	  Map<String, Object> sauceOptions = new HashMap<>();
	  sauceOptions.put("build", "<your build id>");
	  sauceOptions.put("name", "Chrome W3C Test");
	  browserOptions.setCapability("sauce:options", sauceOptions);

	  URL url = new URL("https://oauth-ashlyn.lanaville-f3b54:97383582-6151-4e51-abf5-45d016db4d77@ondemand.us-west-1.saucelabs.com:443/wd/hub");
	  driver = new RemoteWebDriver(url, browserOptions);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
