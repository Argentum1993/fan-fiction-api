package com.fanfiction.fanfictionapi.mapper;

import com.fanfiction.fanfictionapi.DTO.TagDTO;
import com.fanfiction.fanfictionapi.entity.TagEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagEntityDTOMapper {

  TagDTO        entityToDTO(TagEntity tagEntity);
  List<TagDTO>  entityToDTOList(List<TagEntity> tagEntities);
}
