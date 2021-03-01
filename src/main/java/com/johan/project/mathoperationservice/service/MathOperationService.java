package com.johan.project.mathoperationservice.service;

import com.google.common.math.Quantiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MathOperationService {

  @Value("${com.johan.project.file.content}")
  private String fileContent;

  public List<Integer> findMinValues(final Integer quantifier) {
    final List<Integer> sortedList = Stream.of(fileContent.split(",")).map(Integer::valueOf).sorted()
      .collect(Collectors.toList());
    return sortedList.subList(0, quantifier > sortedList.size() ? sortedList.size() : quantifier);
  }

  public List<Integer> findMaxValues(final Integer quantifier) {
    final List<Integer> sortedList = Stream.of(fileContent.split(",")).map(Integer::valueOf)
      .sorted((i1, i2) -> Integer.compare(i2, i1))
      .collect(Collectors.toList());
    return sortedList.subList(0, quantifier > sortedList.size() ? sortedList.size() : quantifier);
  }

  public Double findAverage() {
    return Stream.of(fileContent.split(",")).mapToDouble(Double::valueOf).average().getAsDouble();
  }

  public Double findMedian() {
    return Quantiles.median()
      .compute(Stream.of(fileContent.split(",")).map(Double::valueOf).collect(Collectors.toList()));
  }

  public Double findPercentile(final Integer quantifier) {
    return Quantiles.percentiles().index(quantifier)
      .compute(Stream.of(fileContent.split(",")).map(Double::valueOf).collect(Collectors.toList()));
  }
}
