package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.AreaControleRequest;
import com.example.controle_semanal.dto.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperAreaControle {

    AreaControleEntity toAreaControleEntity(AreaControleRequest areaControleRequest);

    AreaControleResponse toAreaControleResponse(AreaControleEntity areaControleEntity);

    List<AreaControleResponse> toAreasControleResponse(List<AreaControleEntity> areasControleEntity);
}
