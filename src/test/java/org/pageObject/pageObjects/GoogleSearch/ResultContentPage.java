package org.pageObject.pageObjects.GoogleSearch;

import org.openqa.selenium.By;
import org.pageObject.Helper.SearchData;
import org.testng.Assert;
import primitives.TextField;

public class ResultContentPage extends AbstractPage {

    private static final TextField PAGE_TITLE = new TextField(By.cssSelector("h1"), "Result Content Page -> Title of the content");

    public ResultContentPage checkPageTitleContainsSearchWord(SearchData searchInput) {
        String pageTitle = PAGE_TITLE.getText().toLowerCase();
        String searchWord = searchInput.getSearchInput().toLowerCase();

        Assert.assertTrue(pageTitle.contains(searchWord),
                String.format("The result's title %s doesn't contain searched word %s", pageTitle, searchWord));
        return this;
    }
}
