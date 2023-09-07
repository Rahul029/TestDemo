Feature: Login to the application

  Background: 
    Given user navigates to home page

  @Login
  Scenario Outline: Login Functionality
    When I clicked on Login tab
    Then I am able to see the login page
    When I enter "<username>", "<lastname>" and "<password>"
    And Clicked on login button
    Then I am able to see the home page of the Delta Application

    Examples: 
      | username    | lastname | password        |
      | RahulThakur | Thakur   | n6y,ceWeBAT2$m$ |
      | SunnyThakur | Thakur   | n7y,caXeCAT3$x$ |
