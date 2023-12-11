Feature: Core Product features
  
Background:
	Given User is on Core Products Home page
	
	Scenario: Get All Jacket details
    Given User hovers on Shop section
    And User navigates to Mens section
    When User filters by Jackets
    Then User will fetch all jacket details
    And User writes those details to text file  
  
    
  Scenario: Get All Video Feeds counts and Video Feeds counts more than days
  	Given User hovers on Additional Menu section
    When User navigates to News & Features section
    Then User fetches total Video feeds count
    And User will count Total Video Feeds more than 2 days 
    