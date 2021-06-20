package com.fanfiction.fanfictionapi.DTO;

import com.fanfiction.fanfictionapi.entity.FandomEntity;
import com.fanfiction.fanfictionapi.entity.TagEntity;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FanficDTO {
  private String title;
  private String description;
  private String img;
  private Date publicationDate;
  private Set<TagEntity> tags;
  private FandomEntity fandom;
  private Integer rating;
}
