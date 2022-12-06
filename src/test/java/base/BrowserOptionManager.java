package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class BrowserOptionManager {

    /**
     * Gets chrome options.
     *
     * @return the chrome options
     */
    public static ChromeOptions getChromeOptions() {
        HashMap<String, Integer> contentSettings = new HashMap<>();
        HashMap<String, Object> profile = new HashMap<>();
        HashMap<String, Object> prefs = new HashMap<>();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("start-maximized");
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        contentSettings.put("media_stream", 1);
        profile.put("managed_default_content_settings", contentSettings);
        profile.put("default_content_settings.popups", 0);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    /**
     * Gets firefox options.
     *
     * @return the firefox options
     */
    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions feOption = new FirefoxOptions();
        feOption.addPreference("permissions.default.microphone", 1);
        feOption.addPreference("permissions.default.camera", 1);
        feOption.addPreference("permissions.default.camera", 1);
        feOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return feOption;
    }
}
