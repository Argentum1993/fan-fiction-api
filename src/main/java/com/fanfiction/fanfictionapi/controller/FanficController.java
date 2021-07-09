package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.service.ChapterService;
import com.fanfiction.fanfictionapi.service.FanficService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.FANFIC)
public class FanficController {
  public static final String FANFIC_ENDPOINT = "/{id}";
  public static final String LATEST_FANFICS_ENDPOINT = "/last";
  public static final String RATING_FANFICS_ENDPOINT = "/rating";
  public static final String FANFIC_CHAPTERS_ENDPOINT = "/{id}/chapters";
  public static final String FANFIC_CHAPTER_ENDPOINT = "/{id}/chapters/{num}";
  public static final String FANFIC_CHAPTER_NAMES_ENDPOINT = "/{id}/chapters/name";

  private final ChapterService  chapterService;
  private final FanficService   fanficService;

  @Autowired
  public FanficController(
      ChapterService chapterService,
      FanficService fanficService
  ) {
    this.chapterService = chapterService;
    this.fanficService = fanficService;
  }

  //TODO: Delete before deploy
  
  @PostMapping
  public String test(){
    return "ok";
  }

  @GetMapping(FANFIC_ENDPOINT) // Contain variable: {id}
  public FanficDTO getFanfic(@PathVariable Long id){
    return fanficService.getFanfic(id);
  }

  @GetMapping(LATEST_FANFICS_ENDPOINT)
  public  List<FanficDTO> getLatestFanfics(@RequestParam(required = false) Integer size){
    return fanficService.getLatestFanfics(size);
  }
  @GetMapping(RATING_FANFICS_ENDPOINT)
  public List<FanficDTO> getRatingFanfics(@RequestParam(required = false) Integer size){
    return fanficService.getRatingFanfics(size);
  }

  // Endpoints for chapters
  @GetMapping(FANFIC_CHAPTERS_ENDPOINT) // Contain variable: {id}
  public List<ChapterDTO> getAllChapters(@PathVariable Long id){
    return chapterService.getAllChaptersById(id);
  }

  @GetMapping(FANFIC_CHAPTER_ENDPOINT) // Contain variable: {id}, {num}
  public ChapterDTO getAllChapters(@PathVariable Long id, @PathVariable int num){
    return chapterService.getChapter(id, num);
  }

  @GetMapping(FANFIC_CHAPTER_NAMES_ENDPOINT) // Contain variable: {id}
  public List<String> getChapterNames(@PathVariable Long id){
    return chapterService.getChapterNames(id);
  }
}
