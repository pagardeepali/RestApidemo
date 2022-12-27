Feature: Validating Place APIs
@AddPlace
  Scenario Outline: Verify if Place is being Successfully added Using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls with "AddPlaceAPI" with "POST" http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples:
      |name          | language | address           |
      |Bhurj khalifa | English  | World Trade center|
      |iffel Tower   | English  | france            |

@DeletePlace
    Scenario: Verify if Delete Place functionality is working
      Given DeletePlace Payload
      When user calls with "deletePlaceAPI" with "POST" http request
      Then The API call is success with status code 200
      And "status" in response body is "OK"