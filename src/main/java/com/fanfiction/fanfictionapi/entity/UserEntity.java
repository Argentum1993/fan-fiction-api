  package com.fanfiction.fanfictionapi.entity;

  import com.fasterxml.jackson.annotation.JsonFormat;
  import java.util.Date;
  import java.util.Set;
  import javax.persistence.Column;
  import javax.persistence.Entity;
  import javax.persistence.EnumType;
  import javax.persistence.Enumerated;
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
  @Table(name = "user_table")
  @Data
  @EqualsAndHashCode
  public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "reg_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<FanficEntity> fanficEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_fandom_table",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "fandom_id"))
    private Set<FandomEntity> fandomEntities;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<FanficRating> ratings;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String password, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.password = password;
      this.email = email;
    }
  }
