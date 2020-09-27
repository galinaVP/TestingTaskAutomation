package org.pageObject.pageObjects.GoogleSearch;

import org.openqa.selenium.By;
import org.pageObject.Helper.SearchData;
import primitives.InputField;

public class MainPage {

    private static final InputField SEARCH_VALUE = new InputField(By.cssSelector("input[role='combobox']"), "Search page -> Search value input field");

    public SearchPage setWordToSearch(SearchData searchInput) {
        SEARCH_VALUE.setText(searchInput.getSearchInput());
        return new SearchPage();
    }
}
