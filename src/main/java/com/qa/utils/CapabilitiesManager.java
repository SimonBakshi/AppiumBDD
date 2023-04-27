package com.qa.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class CapabilitiesManager {

    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("Getting Device Capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName",params.getPlatformName());
            caps.setCapability("udid", params.getUDID());
            caps.setCapability("deviceName", params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android":
                    caps.setCapability("automationName", props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    String AndroidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "app" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
                    caps.setCapability("app", AndroidAppUrl);
                    break;
                case "iOS":
                    caps.setCapability("automationName", props.getProperty("iOSAutomationName"));
                    caps.setCapability("bundleId",props.getProperty("iOSBundleId"));
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort",params.getWebkitDebugProxyPort());
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "app" + File.separator + "SwagLabsMobileApp.app";
//                    URL iOSAppUrl = getClass().getClassLoader().getResource(props.getProperty("iOSAppLocation"));
                    caps.setCapability("app", iOSAppUrl);
                    break;
            }
            return caps;

        }catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load Capabilities.  ABORT!!!");
            throw e;

        }
    }
}
