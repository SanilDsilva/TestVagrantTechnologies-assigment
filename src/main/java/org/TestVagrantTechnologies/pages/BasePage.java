package org.TestVagrantTechnologies.pages;

import io.qameta.allure.Step;
import org.TestVagrantTechnologies.library.BaseLibs;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends BaseLibs {
    /**
     * Constructor
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }

    private static final Logger Log = LoggerFactory.getLogger(BasePage.class);


    /**
     * Page Methods
     */

    @Step("Going to IMDB Homepage")
    public final ImdbHomepage redirectToImdbPage(String baseURL) {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseURL);
        Log.info("Going to IMDB Page..");
        return new ImdbHomepage(driver);

    }

    @Step("Going to Wiki Homepage")
    public final WikiPage redirectToWikiPage(String baseURL) {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseURL);
        Log.info("Going to Wiki Page..");
        return new WikiPage(driver);

    }

}