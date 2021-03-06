package com.johan.project.mathoperationservice.web.exceptionhandler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class CustomExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<String> handle(final IllegalArgumentException e) {
    log.error(e.getMessage(), e);
    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @ExceptionHandler
  public ResponseEntity<HttpStatus> handle(final Exception e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
