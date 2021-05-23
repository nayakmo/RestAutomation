Feature: Validating place apis 

@AddPlace
Scenario Outline: Verify if place is being added successfully using addPlace API
   Given add place payload with "<name>" "<language>" "<address>"
   When user calls "AddPlaceAPI" api with "POST" http request
   Then the API call got success with status code 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"
   And Verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples: 
   |name | language | address|
   |Srinivas | French | kalasiguda|
   #|Venkatesh | spanish | spain |
   #|Mahesh | Italian | Italy |
   

@DeletePlace
Scenario: Verify if delete place API is working
   Given delete place payload
   When user calls "deletePlaceAPI" api with "POST" http request
   Then the API call got success with status code 200
   And "status" in response body is "OK"
   
   