package org.pageObject.pageObjects.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.pageObject.Helper.SearchData;
import org.testng.Assert;
import primitives.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static WDM.Driver.getDriver;

public class SearchResultsPage extends MainPage {
    private static final By SEARCH_RESULT_TITLES = By.cssSelector(".g .r h3");
    private static final By SEARCH_RESULT_DOMAINS = By.cssSelector("a cite");
    private static final Button NEXT = new Button(By.xpath("//a[@id='pnnext']"), "Search Results Page -> Next results page button");

    public SearchResultsPage checkFirstResultTitleContainsSearchWord(SearchData searchInput) {
        String searchWord = searchInput.getSearchInput().toLowerCase();
        String title = getDriver().findElement(SEARCH_RESULT_TITLES).getText().toLowerCase();

        Assert.assertTrue(title != null && title.contains(searchWord),
                String.format("The result's title %s doesn't contain searched word %s", title, searchWord));
        return this;
    }

    public ResultContentPage openFirstSearchResult() {
        getDriver().findElement(SEARCH_RESULT_TITLES).click();
        return new ResultContentPage();
    }

    public SearchResultsPage checkResultsContainDomainTillPage(SearchData searchData, int tillPage) {
        List<String> allPageResults = new ArrayList<>();
        String domainExpected = searchData.getResultDomain();

        for (int i = 0; i < tillPage; i++) {
            List<WebElement> searchResults = getDriver().findElements(SEARCH_RESULT_DOMAINS);
            for (WebElement element : searchResults) {
                allPageResults.add(element.getText());
            }
            if (i < tillPage - 1) {
                WebElement nextBtn = NEXT.get();
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
                NEXT.click();
            }
        }

        List<String> domain = allPageResults.stream()
                .filter(s -> s.contains(domainExpected))
                .collect(Collectors.toList());

        Assert.assertTrue(domain.size() > 0,
                String.format("No found domain %s on pages till %s", domainExpected, tillPage));
        for (String item : domain) {
            Assert.assertTrue(item != null && item.contains(domainExpected),
                    String.format("Found domain %s not equals to expected %s", item, domainExpected));
        }
        return this;
    }
}