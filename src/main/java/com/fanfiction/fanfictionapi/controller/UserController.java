package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.DTO.UserDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Set;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.USERS)
public class UserController {
  private final String USER_FANFICS       = "/{id}/fanfic";
  private final String USER_FANFICS_COUNT = USER_FANFICS + "/count";
  private final String USER_FANDOMS       = "/{id}/fandoms";

  private final UserServiceImpl userService;

  @Autowired
  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @PatchMapping("/{id}")
  public ResponseEntity patchUser(
      @PathVariable Long id,
      @RequestBody UserDTO request
  ){
    return userService.updateUser(id, request) ?
        ResponseEntity.ok().build() :
        ResponseEntity.badRequest().build();
  }

  @GetMapping(USER_FANFICS) // Contain variable: {id}
  public List<FanficDTO> getAllFanfics(
      @PathVariable Long id,
      PaginationRequestDTO pagination){
    return userService.getUserFanfics(id, pagination);
  }

  @GetMapping(USER_FANFICS_COUNT) // Contain variable: {id}
  public Integer getCountAllFanfics(@PathVariable Long id){
    return userService.countFanfics(id);
  }

  @PutMapping(USER_FANDOMS) // Contain variable: {id}
  public ResponseEntity<List<FandomDTO>> updateUserFandoms(
      @PathVariable Long id,
      @RequestBody Set<Long> fandomsId
  ){
    return ResponseEntity.ok(userService.putFandoms(id, fandomsId));
  }
}
