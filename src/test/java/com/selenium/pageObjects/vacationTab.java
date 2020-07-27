package com.selenium.pageObjects;

import org.openqa.selenium.By;

public class vacationTab {
    static By Flight = By.xpath("//button[contains(@ng-click,'flight')]");
    static By Hotel = By.xpath("//button[contains(@ng-click,'hotel')]");
    static By Car = By.xpath("//button[contains(@ng-click,'car')]");
    static By FlyTo = By.id("farefinder-package-destination-location-input");
    static By FlyFrom = By.id("farefinder-package-origin-location-input");
    static By DepartingDate = By.id("farefinder-package-startdate-input");
    static By ReturningDate = By.id("farefinder-package-enddate-input");
    static By DepartingTime = By.id("farefinder-package-pickuptime-input");
    static By ReturningTime = By.id("farefinder-package-dropofftime-input");
    static By FindADeal = By.id("farefinder-package-search-button");
    static By FlyFromTOList = By.xpath("//ul[@role = 'listbox' and contains(@id, 'typeahead')]/li");



    public static By getFlight(){
        return Flight;
    }
    public static By getHotel(){
        return Hotel;
    }
    public static By getCar(){
        return Car;
    }
    public static By getFlyFrom(){
        return FlyFrom;
    }
    public static By getFlyTo(){
        return FlyTo;
    }
    public static By getDepartingDate(){
        return DepartingDate;
    }
    public static By getReturningDate(){
        return ReturningDate;
    }
    public static By getDepartingTime(){
        return DepartingTime;
    }
    public static By getReturningTime(){
        return ReturningTime;
    }
    public static By getFlyFromTOList(){
        return FlyFromTOList;
    }
    public static By getFindADeal(){
        return FindADeal;
    }

}
