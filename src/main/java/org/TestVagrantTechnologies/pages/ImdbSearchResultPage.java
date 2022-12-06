package org.TestVagrantTechnologies.pages;

import io.qameta.allure.Step;
import org.TestVagrantTechnologies.library.BaseLibs;
import org.TestVagrantTechnologies.locators.ImdbPageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ImdbSearchResultPage extends BaseLibs {
    /**
     * The Imdb locators.
     */
    ImdbPageLocators imdbLocators = new ImdbPageLocators();

    /**
     * The constant imdbMovieRegion.
     * The Imdb movie date.
     */
    public static String imdbMovieRegion, imdbMovieDate;

    /**
     * Instantiates a new Imdb search result page.
     *
     * @param driver the driver
     */
    public ImdbSearchResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets movie from list.
     *
     * @param movieName the movie name
     * @return the movie from list
     */
    @Step("Search movie from list")
    public ImdbSearchResultPage getMovieFromList(String movieName) {
        clickOnElement(imdbLocators.getMovieFromList(movieName));
        return this;
    }

    /**
     * Gets movie region.
     *
     * @return the movie region
     */
    @Step("Extract movie region")
    public ImdbSearchResultPage getMovieRegion() {
        Assert.assertTrue(isElementPresent(imdbLocators.getRegionCountry()));
        imdbMovieRegion = getText(imdbLocators.getRegionCountry());
        return this;
    }

    /**
     * Gets movie release date.
     *
     * @return the movie release date
     */
    @Step("Extract movie release date")
    public ImdbSearchResultPage getMovieReleaseDate() {
        Assert.assertTrue(isElementPresent(imdbLocators.getReleaseDate()));
        imdbMovieDate = getText(imdbLocators.getReleaseDate());
        return this;
    }
}
