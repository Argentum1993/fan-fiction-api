package com.fanfiction.fanfictionapi.DTO;

import com.fanfiction.fanfictionapi.entity.FandomEntity;
import com.fanfiction.fanfictionapi.entity.TagEntity;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FanficDTO {
  private Long id;
  private String author;
  private String title;
  private String description;
  private String img;
  private Date publicationDate;
  private List<TagDTO> tags;
  private FandomDTO fandom;
  private Integer rating;
}
