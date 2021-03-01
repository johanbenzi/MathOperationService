@KEYWORD_MATCHING
Feature: Math operations such as min, max, median, average, percentile can be performed on existing numbers

  Scenario Outline: A list of minimum values is returned based on the context
    Given Quantifier <Quantifier>
    When The minimum values are fetched
    Then A response code <ResponseCode> is obtained
    And The numbers <Values> were obtained
    Examples:
      | Quantifier | ResponseCode | Values |
      | 2          | 200          | 1,2    |

