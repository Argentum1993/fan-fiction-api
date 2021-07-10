package com.fanfiction.fanfictionapi.mapper;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.entity.FandomEntity;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FandomEntityDTOMapper {

  @Mappings({
      @Mapping(target="id", source="fandomEntity.id"),
      @Mapping(target="name", source="fandomEntity.name")
  })
  FandomDTO       entityToDTO(FandomEntity fandomEntity);
  List<FandomDTO> map(Set<FandomEntity> fandomEntities);
  List<FandomDTO> map(List<FandomEntity> fandomEntities);
}
