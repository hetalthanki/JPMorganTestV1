#Author: HETAL THANKI



Feature: Logo
  Background:
    Given user opens google url "https://www.google.com/"

  Scenario Outline: Logo presence on J.P. Morgan site Home Page using enter key for search
    When user enters search item "<searchItem>"
    And User clicks enter key
    And click on first link of google result page
    Then The logo should be present on Home page

    Examples:
    |searchItem|
    |J. P. Morgan|


  Scenario Outline: Logo presence on J.P. Morgan site Home Page using google search button
    When user enters search item "<searchItem>"
    And user clicks on google search button
    And click on first link of google result page
    Then The logo should be present on Home page

    Examples:
      |searchItem|
      |J. P. Morgan|





