package org.TestVagrantTechnologies.locators;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ImdbPageLocators {
    private final By search = By.id("suggestion-search");
    private final By searchButton = By.id("suggestion-search-button");
    public By getMovieFromList(String name) {
        return By.xpath("//a[text()='" + name + "']");
    }
    private final By regionCountry = By.xpath("//button[text()='Country of origin']/following-sibling::div");
    private final By releaseDate = By.xpath("//a[text()='Release date']/following-sibling::div");
}

