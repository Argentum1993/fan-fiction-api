package com.fanfiction.fanfictionapi.mapper;

import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.entity.FanficEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FandomEntityDTOMapper.class, TagEntityDTOMapper.class})
public interface FanficEntityDtoMapper {
  FanficEntityDtoMapper INSTANCE = Mappers.getMapper(FanficEntityDtoMapper.class);

  @Mappings({
      @Mapping(target="rating", source="fanficEntity.averageRating"),
      @Mapping(target="fandom", source="fanficEntity.fandomEntity"),
      @Mapping(target="tags", source="fanficEntity.tagEntities")
  })
  FanficDTO       fanficEntityToDto(FanficEntity fanficEntity);
  List<FanficDTO> map(List<FanficEntity> fanficEntities);
}
