package com.sauce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class FirefoxTest {
	RemoteWebDriver driver;
  @Test
  public void Go_to_google() {
	  driver.get("https://google.com");
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  EdgeOptions browserOptions = new EdgeOptions();
	  browserOptions.setPlatformName("Windows 10");
	  browserOptions.setBrowserVersion("beta");
	  Map<String, Object> sauceOptions = new HashMap<>();
	  sauceOptions.put("build", "<your build id>");
	  sauceOptions.put("name", "<your test name>");
	  browserOptions.setCapability("sauce:options", sauceOptions);

	  URL url = new URL("https://{username}:{accesskey}@ondemand.us-west-1.saucelabs.com:443/wd/hub");
	  driver = new RemoteWebDriver(url, browserOptions);
  }

  @AfterClass
  public void afterClass() {
	  ((JavascriptExecutor) driver).executeScript("sauce: job-result=passed");
	  driver.quit();
  }

}
