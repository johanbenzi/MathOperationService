package com.johan.project.mathoperationservice.contract;

import com.johan.project.mathoperationservice.service.MathOperationService;
import io.restassured.config.EncoderConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@Disabled
@ExtendWith({ SpringExtension.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseContractTest {

  @Autowired
  private WebApplicationContext context;

  @MockBean
  private MathOperationService fileSearchService;

  @BeforeEach
  void setup() {
    final EncoderConfig encoderConfig = new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
    RestAssuredMockMvc.config = new RestAssuredMockMvcConfig().encoderConfig(encoderConfig);
    RestAssuredMockMvc.webAppContextSetup(this.context);

    when(fileSearchService.findMinValues(anyInt())).thenReturn(Arrays.asList(1, 2));
  }
}