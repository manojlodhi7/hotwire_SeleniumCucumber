package com.selenium.pageObjects;

import org.openqa.selenium.By;

public class homePage {
//    static By vacationTab = By.xpath("//header[@id = 'header']//a[contains(text(),'Vacations')]");
    static By vacationTab = By.xpath("//a[contains(text(),'Vacations') and @data-bdd='packages']");
    static By Advertisements = By.xpath("//div[@class = 'meso-ad-uhp-container container']/div[@class = 'row']");



    public static By getVacationTab(){
        return vacationTab;
    }
    public static By getAdvertisements(){
        return Advertisements;
    }
}
