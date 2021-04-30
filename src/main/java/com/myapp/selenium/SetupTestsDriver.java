package com.myapp.selenium;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SetupTestsDriver {
private WebDriver driver = null;
private String browser = null;
private String baseUrl = null;
private String os = null;
private String node = null;


public SetupTestsDriver(String os, String browser, String baseUrl, String node) throws MalformedURLException {
this.browser = browser;
this.os = os;
this.baseUrl = baseUrl;
this.node = node;


Platform platform = Platform.fromString(os.toUpperCase());


if (browser.equalsIgnoreCase("chrome")) {


	ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability("platform", platform);
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");
 
    caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//System.setProperty("webdriver.chrome.driver", "/Users/pradeep/Documents/softwares/chromedriver");
    this.driver = new RemoteWebDriver(new URL(node), caps);
} else if (browser.equalsIgnoreCase("firefox")) {
//System.setProperty("webdriver.gecko.driver", "/Users/pradeep/Documents/softwares/geckodriver");
FirefoxOptions firefoxOptions = new FirefoxOptions();
firefoxOptions.setCapability("platform", platform);
this.driver = new RemoteWebDriver(new URL(node), firefoxOptions);
}
else {
            InternetExplorerOptions ieOption = new InternetExplorerOptions();
            ieOption.setCapability("platform", platform);
            this.driver = new RemoteWebDriver(new URL(node), ieOption);
}


this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
this.driver.manage().window().maximize();
this.driver.get(baseUrl);


}


public String getOs() {
return this.os;
}


public String getBrowser() {
return this.browser;
}


public String getBaseUrl() {
return this.baseUrl;
}


public String getNode() {
return this.node;
}


public WebDriver getDriver() {
return this.driver;
}
}