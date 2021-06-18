  package com.fanfiction.fanfictionapi.entity;

  import java.util.Date;
  import javax.persistence.Column;
  import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
  import javax.persistence.JoinColumn;
  import javax.persistence.ManyToMany;
  import javax.persistence.ManyToOne;
  import javax.persistence.Table;
  import lombok.Data;

  @Data
  @Entity
  @Table(name = "user_table")
  public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "reg_date")
    private Date regDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
  }
