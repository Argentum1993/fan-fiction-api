package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.entity.FanficEntity;
import com.fanfiction.fanfictionapi.repository.FanficEntityRepository;
import com.fanfiction.fanfictionapi.service.ChapterService;
import com.fanfiction.fanfictionapi.service.FanficService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.FANFIC)
public class FanficController {
  private final ChapterService chapterService;

  @Autowired
  public FanficController(ChapterService chapterService,
      FanficService fanficService) {
    this.chapterService = chapterService;
  }

  //TODO: Delete before deploy
  
  @PostMapping
  public String test(){
    return "ok";
  }

  @GetMapping("/{id}/chapters")
  public List<ChapterDTO> getAllChapters(@PathVariable Long id){
    return chapterService.getAllChaptersById(id);
  }
}
