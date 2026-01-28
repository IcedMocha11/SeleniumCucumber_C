Feature: Greenkart

  @Test2
  Scenario: Search and add to cart in GreenKart page

    Given The user is already on the GreenKart page
    When  User inputs "Tom" data in "search" field
    And   Verify if "Tomato" is in the results


  Scenario: Search and add to cart in GreenKart page using list

    Given The user is already on the GreenKart page
    When  User inputs data in the following fields
      | Field Name | Expected Value |
      | search     | om             |
      | search     | tom            |

