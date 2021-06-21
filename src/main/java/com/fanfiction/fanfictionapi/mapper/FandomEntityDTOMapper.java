package com.fanfiction.fanfictionapi.mapper;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.entity.FandomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FandomEntityDTOMapper {
  FandomDTO entityToDTO(FandomEntity fandomEntity);
}
