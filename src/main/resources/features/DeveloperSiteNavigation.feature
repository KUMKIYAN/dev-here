Feature: Developer here navigation feature

  @all_scenarios @ui_navigation
  Scenario: Developer here site UI Navigation
    Given I visit developer here website
    And I Navigate to all the links via UI and check UI elements are rendered properly

  @all_scenarios @service_navigation
  Scenario: Developer here site service Navigation
    Given I visit developer here website
    And I Navigate to all the links via Service and check response code is 200