package com.johan.project.mathoperationservice.bdd.steps;

import com.johan.project.mathoperationservice.bdd.steps.api.SearchKeywordApiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MathOperationsSteps {

  @Steps
  private SearchKeywordApiSteps searchKeywordApiSteps;

  @Given("^Quantifier (.*)$")
  public void saveQuantifier(final Long quantifier) {
    searchKeywordApiSteps.saveQuantifier(quantifier);
  }

  @When("The minimum values are fetched")
  public void getMinimum() {
    searchKeywordApiSteps.getMinimum();
  }

  @Then("^A response code (.*) is obtained")
  public void assertResponseStatus(final int statusCode) {
    searchKeywordApiSteps.assertResponseCode(statusCode);
  }

  @Then("^The numbers (.*) were obtained")
  public void assertNumbers(final String searchContext) {
    searchKeywordApiSteps.assertNumbers(searchContext);
  }

}
