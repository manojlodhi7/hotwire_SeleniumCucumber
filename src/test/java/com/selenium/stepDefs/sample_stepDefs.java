package com.selenium.stepDefs;

import com.selenium.hooks.Hooks;
import com.selenium.pageObjects.homePage;
import com.selenium.pageObjects.vacationTab;
import com.selenium.pageObjects.searchResults;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class sample_stepDefs {

    WebDriver driver;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    {
        driver = Hooks.driver;
    }

    WebDriverWait wait  = new WebDriverWait(driver, 30);

    @Given("Open given website")
    public void launch_url(DataTable dataTable) {
        String URL = dataTable.row(0).get(0);
        System.out.println("URL : " + URL);
        driver.get(URL);
    }

    @And("Go to Vacations tab")
    public void clickOnVacationTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getVacationTab())).click();
    }

    @And("Select flight, hotel and car search options")
    public void selectAllSearchOptions() {
        WebElement flight = wait.until(ExpectedConditions.visibilityOfElementLocated(vacationTab.getFlight()));
        WebElement hotel = driver.findElement(vacationTab.getHotel());
        WebElement car = driver.findElement(vacationTab.getCar());
        if(!flight.getAttribute("class").contains("hw-btn-check-active")){
            wait.until(ExpectedConditions.elementToBeClickable(vacationTab.getFlight())).click();
        }
        if(!hotel.getAttribute("class").contains("hw-btn-check-active")){
            wait.until(ExpectedConditions.elementToBeClickable(vacationTab.getHotel())).click();
        }
        if(!car.getAttribute("class").contains("hw-btn-check-active")){
            wait.until(ExpectedConditions.elementToBeClickable(vacationTab.getCar())).click();
        }
    }

    @And("Enter flight from (.*) to (.*)")
    public void enterFromAndToDetails(String From, String To) throws InterruptedException {
        WebElement flyFrom = driver.findElement(vacationTab.getFlyFrom());
        WebElement flyTo = driver.findElement(vacationTab.getFlyTo());
        flyFrom.clear();
        flyFrom.sendKeys(From);
        Thread.sleep(400);
        List<WebElement> droDownList = driver.findElements(vacationTab.getFlyFromTOList());
        Assert.assertTrue("No location found for entered From city : Drop down Size : " + droDownList.size(), droDownList.size()>0);
        for(WebElement we: droDownList){
            if(we.getText().contains(From)){
                we.click();
                break;
            }
        }
        Assert.assertNotEquals("No Matching location found for entered From city", flyFrom.getText(), From);

        droDownList.clear();
        flyTo.clear();
        flyTo.sendKeys(To);
        Thread.sleep(400);
        droDownList = driver.findElements(vacationTab.getFlyFromTOList());
        Assert.assertTrue("No location found for entered To city : Drop down Size : " + droDownList.size(), droDownList.size()>0);
        for(WebElement we: droDownList){
            System.out.println("Test : " + we.getText());
            if(we.getText().contains(To)){
                we.click();
                break;
            }
        }
        Assert.assertNotEquals("No Matching location found for entered To city", flyTo.getText(), To);
    }

    @And("Enter Departing next day details")
    public void departingNextDayDetails() {
        WebElement DepartingDate = driver.findElement(vacationTab.getDepartingDate());
        Assert.assertTrue("DepartingDate not displayed", DepartingDate.isDisplayed());
        String nextDayDate = LocalDate.now().plusDays(1).format(dateTimeFormatter);
        System.out.println("nextDayDate : " + nextDayDate);
        DepartingDate.clear();
        DepartingDate.sendKeys(nextDayDate);
    }

    @And("Select (.*) time (.*)")
    public void departingReturningTime(String method, String time) {
        Select select = null;
        WebElement departingReturningTime;
        if(method.equalsIgnoreCase("Departing")){
            departingReturningTime = driver.findElement(vacationTab.getDepartingTime());
            Assert.assertTrue("Departing time not displayed", departingReturningTime.isDisplayed());
            select = new Select(departingReturningTime);
        }
        else if(method.equalsIgnoreCase("Returning")){
            departingReturningTime = driver.findElement(vacationTab.getReturningTime());
            Assert.assertTrue("Returning time not displayed", departingReturningTime.isDisplayed());
            select = new Select(departingReturningTime);
        } else {
            Assert.fail("Departure or Returning method is incorrect");
        }
        select.selectByVisibleText(time);
    }

    @And("Enter Returning three weeks after details")
    public void returningThreeWeeksAfterDetails() {
        WebElement ReturningDate = driver.findElement(vacationTab.getReturningDate());
        Assert.assertTrue("ReturningDate not displayed", ReturningDate.isDisplayed());
        String threeWeeksAfterDepartureDate = LocalDate.now().plusDays(15).format(dateTimeFormatter);
        System.out.println("threeWeeksAfterDepartureDate : " + threeWeeksAfterDepartureDate);
        ReturningDate.clear();
        ReturningDate.sendKeys(threeWeeksAfterDepartureDate);
    }

    @Then("click on Find a deal button")
    public void clickFindADealBtn() {
        WebElement FindADealBtn = driver.findElement(vacationTab.getFindADeal());
        Assert.assertTrue("FindADeal Button not displayed", FindADealBtn.isDisplayed());
        FindADealBtn.click();
    }

    @And("Verify that at least one result displayed")
    public void verifySearchResults() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResults.getResultCount()));
        List<WebElement> searchResult = driver.findElements(searchResults.getResultCount());
        Assert.assertTrue("Search result not found", searchResult.size()>0);
    }
}
