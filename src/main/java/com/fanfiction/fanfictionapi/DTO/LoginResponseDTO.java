package com.fanfiction.fanfictionapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
  private Long    id;
  private String  firstName;
  private String  lastName;
  private String  email;
  private String  accessToken;
}
