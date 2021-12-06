package com.fanfiction.fanfictionapi.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestChapterService {
  @Test
  public void testJenkins() {
    Integer x = calculator(Integer.MAX_VALUE / 3);
    assertTrue(Integer.MAX_VALUE / 3 == x);
  }

  private Integer calculator(Integer toNumber) {
    Integer counter = 0;
    while (counter <= toNumber) {
      ++counter;
    }
    return counter;
  }
}
