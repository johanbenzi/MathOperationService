package com.johan.project.mathoperationservice.bdd.steps.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Ignore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Ignore
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration
@Log4j2
public class SearchKeywordApiSteps {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @LocalServerPort
  private int port;

  private String mathOperationServiceUrl;

  @Step(value = "Save a quantifier in serenity session")
  public void saveQuantifier(final Long keyword) {
    Serenity.getCurrentSession().put("QUANTIFIER", keyword);
  }

  @Step(value = "Attempt to get minimum values by hitting the endpoint")
  public void getMinimum() {
    setFileSearchServiceRunningUrl();
    SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
    SerenityRest.given()
      .contentType("application/json")
      .accept("application/json")
      .when()
      .get(format("%s/min?quantifier=%s", mathOperationServiceUrl, Serenity.getCurrentSession().get("QUANTIFIER")));
  }

  @Step(value = "Assert response code")
  public void assertResponseCode(final int statusCode) {
    assertThat(SerenityRest.then().extract().statusCode(), is(statusCode));
  }

  @Step(value = "Assert numbers")
  @SneakyThrows
  public void assertNumbers(final String responseMessage) {
    assertThat(objectMapper.readValue(SerenityRest.then().extract().response().getBody().prettyPrint(), String[].class),
      is(responseMessage.split(",")));
  }

  private void setFileSearchServiceRunningUrl() {
    SerenityRest.reset();
    try {
      mathOperationServiceUrl = format("http://%s:%s", InetAddress.getLocalHost().getHostAddress(), port);
    }
    catch(final UnknownHostException e) {
      log.error(e, e);
    }
  }
}