package base;

import org.openqa.selenium.Capabilities;

public class BrowserCapability {
    public Capabilities capabilities;
    public Capabilities getCapabilities (String browser) {
        if (browser.equals("firefox"))
            capabilities = BrowserOptionManager.getFirefoxOptions();
        else
            capabilities = BrowserOptionManager.getChromeOptions();
        return capabilities;
    }

}
