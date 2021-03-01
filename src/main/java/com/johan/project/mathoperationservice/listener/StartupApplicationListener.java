package com.johan.project.mathoperationservice.listener;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.setProperty;

@Component
public class StartupApplicationListener implements InitializingBean {

  @Override
  @SneakyThrows
  public void afterPropertiesSet() {
    setProperty("com.johan.project.file.content",
      Files.readString(Path.of(ClassLoader.getSystemResource("numbers.txt").toURI())).intern());
  }
}