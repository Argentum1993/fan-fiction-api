package com.fanfiction.fanfictionapi.DTO;

import lombok.Data;

@Data
public class ChapterDTO {
  private Long    id;
  private int     number;
  private String  name;
  private String  img;
  private String  text;
}
