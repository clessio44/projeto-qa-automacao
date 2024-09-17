package br.com.qa.utils;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554"); // Verifique o UDID correto
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome"); // Exemplo com o Chrome
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);


        // URL do servidor Appium
        String appiumServerURL = "http://localhost:4723/wd/hub"; // Verifique o host e a porta corretos
        capabilities.setCapability("appium:serverUrl", appiumServerURL);

        return capabilities;
    }
}
