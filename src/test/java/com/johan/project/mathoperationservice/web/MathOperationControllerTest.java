package com.johan.project.mathoperationservice.web;

import com.johan.project.mathoperationservice.service.MathOperationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathOperationControllerTest {

  private static final Integer QUANTIFIER = 1;

  private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3);

  @InjectMocks
  private MathOperationController cut;

  @Mock
  private MathOperationService mathOperationService;

  @Test
  void getMinimumValues() {
    when(mathOperationService.findMinValues(QUANTIFIER)).thenReturn(NUMBERS);

    final List<Integer> response = cut.getMinimumValues(QUANTIFIER);

    Assertions.assertEquals(NUMBERS, response);
    verify(mathOperationService, times(1)).findMinValues(QUANTIFIER);
    verifyNoMoreInteractions(mathOperationService);
  }

  @Test
  void getMinimumValues_nullQuantifier() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> cut.getMinimumValues(null));
    verifyNoInteractions(mathOperationService);
  }

  @Test
  void getMaximumValues() {
    when(mathOperationService.findMaxValues(QUANTIFIER)).thenReturn(NUMBERS);

    final List<Integer> response = cut.getMaximumValues(QUANTIFIER);

    Assertions.assertEquals(NUMBERS, response);
    verify(mathOperationService, times(1)).findMaxValues(QUANTIFIER);
    verifyNoMoreInteractions(mathOperationService);
  }

  @Test
  void getMaximumValues_nullQuantifier() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> cut.getMaximumValues(null));
    verifyNoInteractions(mathOperationService);
  }

}