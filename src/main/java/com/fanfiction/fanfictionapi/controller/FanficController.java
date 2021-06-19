package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.Maps;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.FANFIC)
public class FanficController {

  @PostMapping
  public String test(){
    return "ok";
  }
}
