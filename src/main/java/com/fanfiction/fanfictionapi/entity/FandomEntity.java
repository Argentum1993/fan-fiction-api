package com.fanfiction.fanfictionapi.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "fandom_table")
@Data
@EqualsAndHashCode
public class FandomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "fandomEntity", fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<FanficEntity> fanfics;

  @ManyToMany(mappedBy = "fandomEntities", fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  private Set<UserEntity> userEntities;
}
