package org.TestVagrantTechnologies.locators;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class WikiPageLocator {
    private final By wikiSearch = By.id("searchInput");
    private final By searchButton = By.id("searchButton");
    private final By wikiMovieCountry = By.xpath("//th[normalize-space()='Country']/following-sibling::td");
    private final By wikiMovieReleaseDate = By.xpath("//th[normalize-space()='Release date']/following-sibling::td");
}
