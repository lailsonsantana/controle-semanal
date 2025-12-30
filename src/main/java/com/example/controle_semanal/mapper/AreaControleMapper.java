package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.AreaControleRequest;
import com.example.controle_semanal.dto.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaControleMapper {

    AreaControleEntity toAreaControleEntity(AreaControleRequest areaControleRequest);

    AreaControleResponse toAreaControleResponse(AreaControleEntity areaControleEntity);
}
