package org.TestVagrantTechnologies.pages;

import io.qameta.allure.Step;
import org.TestVagrantTechnologies.library.BaseLibs;
import org.TestVagrantTechnologies.locators.ImdbPageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ImdbHomepage extends BaseLibs {

    /**
     * The Imdb locators.
     */
    ImdbPageLocators imdbLocators = new ImdbPageLocators();

    /**
     * Instantiates a new Imdb homepage.
     *
     * @param driver the driver
     */
    public ImdbHomepage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify search screen imdb homepage.
     *
     * @return the imdb homepage
     */
    @Step("Verifying the search present on IMDB homepage")
    public ImdbHomepage verifySearchScreen() {
        Assert.assertTrue(isElementPresent(imdbLocators.getSearch()), "No Search shown");
        return this;
    }

    /**
     * Search movie imdb search result page.
     *
     * @param movieName the movie name
     * @return the imdb search result page
     */
    @Step("Searching the movie name : {0}")
    public ImdbSearchResultPage searchMovie(String movieName) {
        Assert.assertTrue(isElementPresent(imdbLocators.getSearch()), "No Search shown");
        clear(imdbLocators.getSearch());
        writeText(imdbLocators.getSearch(), movieName);
        clickOnElement(imdbLocators.getSearchButton());
        return new ImdbSearchResultPage(driver);
    }

}
