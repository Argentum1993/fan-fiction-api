package com.fanfiction.fanfictionapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
  private String email;
  private String accessToken;
}
