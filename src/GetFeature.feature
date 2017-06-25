Feature: getJson
  #--------------------------------------
  # next block is got the GET entry point
  #--------------------------------------


  Scenario: User cannot access URL other than {server address}/hello
    When I perform a GET request to other URL
    Then I receive a http response code 404


  Scenario: User cannot access URL with parameters other than 'username'
    When I perform a GET request to {server address}/hello with other parameter than 'username
    Then I receive a http response code 400

  Scenario: User input valid GET request
    When I perform a GET request to {server address}/hello with 'username' parameter
    Then I receive a http response code of 200
    Then I receive the Json file with value of my request parameter.


