package com.johan.project.mathoperationservice.web;

import com.johan.project.mathoperationservice.service.MathOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class MathOperationController {

  @Autowired
  private MathOperationService mathOperationService;

  @GetMapping(path = "/min")
  @ResponseStatus(value = HttpStatus.OK)
  @Operation(summary = "Find minimum value based on quantifier")
  @ApiResponse(responseCode = "200", description = "Minimum values", content = @Content(schema = @Schema(implementation = List.class), examples = @ExampleObject(value = "[1,2]")))
  @ApiResponse(responseCode = "400", description = "Bad data found", content = @Content)
  @ApiResponse(responseCode = "500", description = "Internal server error.", content = @Content)
  public List<Integer> getMinimumValues(
    @Parameter(description = "Number of requested values", example = "2") @RequestParam(value = "quantifier") final Integer quantifier) {
    Preconditions.checkArgument(Objects.nonNull(quantifier), "quantifier cannot be empty");
    return mathOperationService.findMinValues(quantifier);
  }

  @GetMapping(path = "/max")
  @ResponseStatus(value = HttpStatus.OK)
  @Operation(summary = "Find maximum value based on quantifier")
  @ApiResponse(responseCode = "200", description = "Maximum values", content = @Content(schema = @Schema(implementation = List.class), examples = @ExampleObject(value = "[1,2]")))
  @ApiResponse(responseCode = "400", description = "Bad data found", content = @Content)
  @ApiResponse(responseCode = "500", description = "Internal server error.", content = @Content)
  public List<Integer> getMaximumValues(
    @Parameter(description = "Number of requested values", example = "2") @RequestParam(value = "quantifier") final Integer quantifier) {
    Preconditions.checkArgument(Objects.nonNull(quantifier), "quantifier cannot be empty");
    return mathOperationService.findMaxValues(quantifier);
  }

  @GetMapping(path = "/median")
  @ResponseStatus(value = HttpStatus.OK)
  @Operation(summary = "Find median value")
  @ApiResponse(responseCode = "200", description = "Maximum values", content = @Content(schema = @Schema(implementation = List.class), examples = @ExampleObject(value = "[1,2]")))
  @ApiResponse(responseCode = "400", description = "Bad data found", content = @Content)
  @ApiResponse(responseCode = "500", description = "Internal server error.", content = @Content)
  public Double getMedian() {
    return mathOperationService.findMedian();
  }

  @GetMapping(path = "/average")
  @ResponseStatus(value = HttpStatus.OK)
  @Operation(summary = "Find maximum value based on quantifier")
  @ApiResponse(responseCode = "200", description = "Maximum values", content = @Content(schema = @Schema(implementation = List.class), examples = @ExampleObject(value = "[1,2]")))
  @ApiResponse(responseCode = "400", description = "Bad data found", content = @Content)
  @ApiResponse(responseCode = "500", description = "Internal server error.", content = @Content)
  public Double getAverage() {
    return mathOperationService.findAverage();
  }

  @GetMapping(path = "/percentile")
  @ResponseStatus(value = HttpStatus.OK)
  @Operation(summary = "Find maximum value based on quantifier")
  @ApiResponse(responseCode = "200", description = "Maximum values", content = @Content(schema = @Schema(implementation = List.class), examples = @ExampleObject(value = "[1,2]")))
  @ApiResponse(responseCode = "400", description = "Bad data found", content = @Content)
  @ApiResponse(responseCode = "500", description = "Internal server error.", content = @Content)
  public Double getPercentile(
    @Parameter(description = "Percentile value", example = "2") @RequestParam(value = "quantifier") final Integer quantifier) {
    Preconditions.checkArgument(Objects.nonNull(quantifier), "quantifier cannot be empty");
    return mathOperationService.findPercentile(quantifier);
  }
}
