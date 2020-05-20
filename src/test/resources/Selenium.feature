Feature: Lets go to google
  Scenario: User goes to Google Main Page
    Given user navigates "https://www.google.com"
    When user enters "Selenium" to "Search_Button" area
    Then user views "number_of_results"

  Scenario: User logins Facebook
    Given user navigates "https://www.facebook.com"
    When user enters "a@a.com" to "Facebook_Email" area
    And user enters "pass" to "Facebook_Password" area
    And user clicks "Facebook_Login"
    Then user should see "Login_Facebook" page


  Scenario: user logins Twitter
    Given user navigates "https://twitter.com/login"
    When user enters "deneme" to "Username" area
    And user enters "deneme" to "password" area
    And user move "picture" to "attachment" area
    And user move " " to "" area


  Scenario Outline: user try to logins Outlook email
    Given user navigates "https://outlook.live.com/owa/"
    When user clicks "create_account_button"
    And user enters "turkie_elif" to "account_name" area
    And user clicks "next_button"
    And user clicks "<linkName>"
    Then user should see "<pageName>"
    Examples:
      | linkName            | pageName                          |
      | Microsoft_agreement | Microsoft_Services_Agreement_Page |
      | privacy_statement   | privacy_statement_page            |

    
    Scenario: go to kadaza
      Given user navigates "https://www.kadaza.co.uk/shopping"
      When user clicks "tesco_button"
      And user clicks "accept_cookie"
      And user enters "apple" to "search_button" area
