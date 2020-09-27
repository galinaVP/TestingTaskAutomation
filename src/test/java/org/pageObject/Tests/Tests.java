package org.pageObject.Tests;

import org.pageObject.Helper.SearchData;
import org.pageObject.pageObjects.GoogleSearch.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    MainPage mainPage;
    ThreadLocal<SearchData> tSearch = new ThreadLocal<>();

    @BeforeMethod
    public void mainPage() {
        mainPage = new MainPage();
        tSearch.set(SearchData.builder()
                .searchInput("automation")
                .resultDomain("testautomationday.com")
                .build());
    }

    @Test
    public void searchWord() {
        mainPage.setWordToSearch(tSearch.get())
                .clickSearchButton()
                .checkFirstResultTitleContainsSearchWord(tSearch.get())
                .openFirstSearchResult()
                .checkPageTitleContainsSearchWord(tSearch.get());
    }

    @Test
    public void searchDomain() {
        mainPage.setWordToSearch(tSearch.get())
                .clickSearchButton()
                .checkResultsContainDomainTillPage(tSearch.get(), 5);
    }
}