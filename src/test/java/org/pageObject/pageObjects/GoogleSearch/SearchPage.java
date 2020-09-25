package org.pageObject.pageObjects.GoogleSearch;

import org.openqa.selenium.By;
import org.pageObject.Helper.SearchData;
import primitives.Button;
import primitives.InputField;

public class SearchPage extends AbstractPage {

    private static final InputField SEARCH_VALUE = new InputField(By.cssSelector("input[role='combobox']"), "Search page -> Search value input field");
    private static final Button SEARCH = new Button(By.cssSelector("input[name='btnK']"), "Search page -> Search button");

    public SearchPage setWordToSearch(SearchData searchInput) {
        SEARCH_VALUE.setText(searchInput.getSearchInput());
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        SEARCH.click();
        return new SearchResultsPage();
    }
}
