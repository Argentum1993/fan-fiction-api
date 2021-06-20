package com.fanfiction.fanfictionapi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FanficRatingKey implements Serializable {

  @Column(name ="user_id")
  private Long userId;

  @Column(name ="fanfic_id")
  private Long fanficId;
}
