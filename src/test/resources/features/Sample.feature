Feature: Cucumber Selenium integration

  @Sample
  Scenario: Cucumber Selenium integration test 01
    Given Open given website
      | http://www.hotwire.com/ |
    When Go to Vacations tab
    And Select flight, hotel and car search options
    And Enter flight from SFO to LAX
    And Enter Departing next day details
    And Select Departing time Evening
    And Enter Returning three weeks after details
    And Select Returning time Morning
    Then click on Find a deal button
    And Verify that at least one result displayed






