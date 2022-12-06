package org.TestVagrantTechnologies.pages;


import io.qameta.allure.Step;
import org.TestVagrantTechnologies.library.BaseLibs;
import org.TestVagrantTechnologies.locators.WikiPageLocator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.TestVagrantTechnologies.pages.ImdbSearchResultPage.imdbMovieDate;
import static org.TestVagrantTechnologies.pages.ImdbSearchResultPage.imdbMovieRegion;


public class WikiPage extends BaseLibs {

    /**
     * The Wiki page locator.
     */
    WikiPageLocator wikiPageLocator = new WikiPageLocator();

    /**
     * The constant wikiMovieRegion.
     * The Wiki movie date.
     */
    public static String wikiMovieRegion, wikiMovieDate;


    /**
     * Instantiates a new Wiki page.
     *
     * @param driver the driver
     */
    public WikiPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Search movie on wiki wiki page.
     *
     * @param movieName the movie name
     * @return the wiki page
     */
    @Step("Search movie from wiki")
    public WikiPage searchMovieOnWiki(String movieName) {
        Assert.assertTrue(isElementPresent(wikiPageLocator.getWikiSearch()));
        clear(wikiPageLocator.getWikiSearch());
        writeText(wikiPageLocator.getWikiSearch(), movieName);
        clickOnElement(wikiPageLocator.getSearchButton());
        return this;
    }

    /**
     * Gets movie region.
     *
     * @return the movie region
     */
    @Step("Search movie from list")
    public WikiPage getMovieRegion() {
        Assert.assertTrue(isElementPresent(wikiPageLocator.getWikiMovieCountry()));
        wikiMovieRegion = getText(wikiPageLocator.getWikiMovieCountry());
        return this;
    }

    /**
     * Gets movie release date.
     *
     * @return the movie release date
     */
    @Step("Search movie from list")
    public WikiPage getMovieReleaseDate() {
        Assert.assertTrue(isElementPresent(wikiPageLocator.getWikiMovieReleaseDate()));
        wikiMovieDate = getText(wikiPageLocator.getWikiMovieReleaseDate());
        return this;
    }


    /**
     * Date validate wiki page.
     *
     * @return the wiki page
     */
    @Step("Date validation")
    public WikiPage dateValidate() {
        String[] imdbDateExtract = imdbMovieDate.split("\\(");
        String validImdbDate = imdbDateExtract[0].trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        LocalDate imdbDateWithFormatter = LocalDate.parse(validImdbDate, formatter);
        formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        LocalDate wikiDateWithFormatter = LocalDate.parse(wikiMovieDate, formatter);
        Assert.assertTrue(imdbDateWithFormatter.isEqual(wikiDateWithFormatter), "Release date is mismatching");
        return this;
    }

    /**
     * Region validate wiki page.
     *
     * @return the wiki page
     */
    @Step("Region validation")
    public WikiPage regionValidate() {
        Assert.assertTrue(imdbMovieRegion.equalsIgnoreCase(wikiMovieRegion), "Region is mismatching!");
        return this;
    }


}
