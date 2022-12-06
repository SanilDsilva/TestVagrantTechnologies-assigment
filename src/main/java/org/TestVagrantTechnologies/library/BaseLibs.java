package org.TestVagrantTechnologies.library;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseLibs {

    public WebDriver driver;
    public WebDriverWait wait;
    private static final Logger Log = LoggerFactory.getLogger(BaseLibs.class);

    /**
     * Instantiates a new Base libs.
     *
     * @param driver the driver
     */
    public BaseLibs(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Clear.
     *
     * @param by the by
     */
    protected void clear(By by) {
        Log.info("Clearing element" + by);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        waitVisibility(by).clear();
    }

    /**
     * Write text.
     *
     * @param by   the by
     * @param text the text
     */
    protected void writeText(By by, String text) {
        Log.info("Entering the data [" + text + "] to locator" + by);
        waitVisibility(by).sendKeys((Keys.chord(text)));
    }

    /**
     * Wait visibility web element.
     *
     * @param by the by
     * @return the web element
     */
    protected WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    /**
     * Is element present boolean.
     *
     * @param by the by
     * @return the boolean
     */
    protected boolean isElementPresent(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            if (element != null) {
                Log.debug("Element is present: " + by.toString());
                return true;
            } else {
                Log.warn("Element is NOT present: " + by.toString());
                return false;
            }
        } catch (NoSuchElementException var3) {
            return false;
        } catch (Exception var4) {
            Log.warn(var4.getMessage());
            return false;
        }
    }

    /**
     * Click on element.
     *
     * @param by the by
     */
    protected void clickOnElement(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        if (element.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Log.info("Clicked on element: " + by);
        }
    }

    /**
     * Gets text.
     *
     * @param by the by
     * @return the text
     */
    protected String getText(By by) {
        Log.info("Getting the text of the element: " + by);
        return this.driver.findElement(by).getText();
    }


}