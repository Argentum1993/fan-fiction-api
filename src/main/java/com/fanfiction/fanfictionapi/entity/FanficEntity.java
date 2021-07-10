package com.fanfiction.fanfictionapi.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "fanfic_table")
@Data
@EqualsAndHashCode
public class FanficEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "img")
  private String img;

  @Column(name = "publication_date", insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date publicationDate;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "fanfic_tags_table",
      joinColumns = @JoinColumn(name = "fanfic_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  @EqualsAndHashCode.Exclude
  private List<TagEntity> tagEntities;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "fandom_id")
  private FandomEntity fandomEntity;

  @OneToMany(mappedBy = "fanficEntity", fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<ChapterEntity> chapterEntities;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @EqualsAndHashCode.Exclude
  private UserEntity userEntity;

  @OneToMany(mappedBy = "fanficEntity", fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<FanficRating> ratings;

  @Column(name = "average_rating")
  private int averageRating;
}
