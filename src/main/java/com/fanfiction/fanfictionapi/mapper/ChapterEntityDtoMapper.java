package com.fanfiction.fanfictionapi.mapper;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.entity.ChapterEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChapterEntityDtoMapper {
  ChapterDTO        chapterEntityToDto(ChapterEntity chapterEntity);
  List<ChapterDTO>  map(List<ChapterEntity> chapterEntities);
}
