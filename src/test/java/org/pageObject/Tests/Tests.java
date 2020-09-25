package org.pageObject.Tests;

import org.pageObject.Helper.SearchData;
import org.pageObject.pageObjects.GoogleSearch.SearchPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    SearchPage searchPage;
    ThreadLocal<SearchData> tSearch = new ThreadLocal<>();

    @BeforeMethod
    public void mainPage() {
        searchPage = new SearchPage();
        tSearch.set(SearchData.builder()
                .searchInput("automation")
                .resultDomain("testautomationday.com")
                .build());
    }

    @Test
    public void searchWord() {
        searchPage.setWordToSearch(tSearch.get())
                .clickSearchButton()
                .checkResultTitleOnPositionContainsSearchWord(1, tSearch.get())
                .openSearchResult(1)
                .checkPageTitleContainsSearchWord(tSearch.get());
    }

    @Test
    public void searchDomain() {
        searchPage.setWordToSearch(tSearch.get())
                .clickSearchButton()
                .checkResultsContainDomainTillPage(tSearch.get(), 5);
    }
}