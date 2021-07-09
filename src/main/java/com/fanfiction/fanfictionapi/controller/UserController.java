package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.service.impl.UserServiceImpl;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.USERS)
public class UserController {
  private final UserServiceImpl userService;

  @Autowired
  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}/fanfic")
  public List<FanficDTO> getAllFanfics(
      @PathVariable Long id,
      PaginationRequestDTO pagination){
    return userService.getUserFanfics(id, pagination);
  }
}
