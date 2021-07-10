package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.service.FandomService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.FANDOMS)
public class FandomController {
  private final FandomService fandomService;

  public FandomController(FandomService fandomService) {
    this.fandomService = fandomService;
  }

  @GetMapping
  public List<FandomDTO> getAllFandoms(){
    return fandomService.getAll();
  }
}
