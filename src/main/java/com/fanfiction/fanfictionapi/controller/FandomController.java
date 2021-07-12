package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.service.FandomService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.FANDOMS)
public class FandomController {
  private final String FANDOM_FANFICS = "/{id}/fanfic";
  private final String FANDOM_FANFICS_COUNT = FANDOM_FANFICS + "/count";

  private final FandomService fandomService;

  public FandomController(FandomService fandomService) {
    this.fandomService = fandomService;
  }

  @GetMapping
  public List<FandomDTO> getAllFandoms(){
    return fandomService.getAll();
  }

  @GetMapping(FANDOM_FANFICS)
  public List<FanficDTO> getFanfics(
      @PathVariable Long id,
      PaginationRequestDTO pagination
  ){
    return fandomService.getFanfics(id, pagination);
  }

  @GetMapping(FANDOM_FANFICS_COUNT)
  public Integer getFanficCount(@PathVariable Long id) {
    return fandomService.countFanfics(id);
  }
}
