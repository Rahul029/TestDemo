Feature: Search for flight in Delta application

  Background: 
    Given user is navigates to home page

  @SearchFlight
  Scenario: Search Flight Functionality
    When user search for the flight in the Delta application
    And clicked on search button
    Then user is able to see the book flight page
