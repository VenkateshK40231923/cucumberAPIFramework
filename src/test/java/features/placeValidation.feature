Feature: Validate place API's
@AddPlace @Regression
Scenario Outline: Verify if place is being succesfully added using AddPlaceAPI
		Given Add Place Payload with "<name>", "<language>", "<address>"
		When user calls "AddPlaceAPI" with Post http request
		Then the Api call got success with status code 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
		
Examples: 
    | name 	| language  | address 		|
    | vinny | telugu 		| oklahoma 		|
    | kheer | english 	| vijayawada	|
    
    
    @DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	 