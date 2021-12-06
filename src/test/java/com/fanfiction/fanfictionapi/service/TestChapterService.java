package com.fanfiction.fanfictionapi.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestChapterService {
  @Test
  public void testJenkins() {
    Integer counter = Math.round(Integer.MAX_VALUE / 3);
    Integer x = calculator(counter);

    assertTrue(counter.equals(x));
  }

  private Integer calculator(Integer toNumber) {
    Integer counter = 0;
    while (counter < toNumber) {
      ++counter;
    }
    return counter;
  }
}
