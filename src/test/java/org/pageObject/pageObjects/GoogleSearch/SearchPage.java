package org.pageObject.pageObjects.GoogleSearch;

import org.openqa.selenium.By;
import primitives.Button;

public class SearchPage extends MainPage {

    private static final Button SEARCH = new Button(By.cssSelector("input[name='btnK']"), "Search page -> Search button");

    public SearchResultsPage clickSearchButton() {
        SEARCH.click();
        return new SearchResultsPage();
    }
}
