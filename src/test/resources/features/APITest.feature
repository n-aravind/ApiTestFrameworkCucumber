Feature: To test an API

  Scenario: Verify whether given API returns 200 return code
    When a api is invoked
    Then it returns 200 http code

