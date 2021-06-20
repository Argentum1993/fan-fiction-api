package com.fanfiction.fanfictionapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "chapter_table")
@Data
public class ChapterEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "number")
  private Integer number;

  @Column(name = "name")
  private String name;

  @Column(name = "text")
  private String text;

  @Column(name = "img")
  private String img;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fanfic_id")
  private FanficEntity fanficEntity;
}
