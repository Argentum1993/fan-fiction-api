package com.fanfiction.fanfictionapi.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "fanfic_rating_table")
@Data
public class FanficRating {

  @EmbeddedId
  FanficRatingKey id;

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;

  @ManyToOne
  @MapsId("fanficId")
  @JoinColumn(name = "fanfic_id")
  private FanficEntity fanficEntity;

  @Column(name = "rating")
  int rating;
}
