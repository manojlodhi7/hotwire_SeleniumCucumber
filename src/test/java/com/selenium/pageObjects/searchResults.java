package com.selenium.pageObjects;

import org.openqa.selenium.By;

public class searchResults {
    static By ResultCount = By.xpath("//*[contains(@id,'resultsContainer')]/section/article/div/div/a");


    public static By getResultCount(){
        return ResultCount;
    }
}
