Feature: Open Blog Page

#Backgroud will be executed before all other scenarios  
Background:
Given user has logged in to application
|username|password|
|divyanklf@gmail.com|Test@1234|
And user clicks on the Blog Section

 
  Scenario: Verify that the Marketing page opens
    Given page with title "Ecommerce advice and success stories – Blog | PrestaShop" opens
    When user clicks on the Marketing button
    Then the marketing results show





