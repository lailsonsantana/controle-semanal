package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.AreaControleRequest;
import com.example.controle_semanal.dto.response.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperAreaControle {

    AreaControle toAreaControleEntity(AreaControleRequest areaControleRequest);

    AreaControleResponse toAreaControleResponse(AreaControle areaControle);

    List<AreaControleResponse> toAreasControleResponse(List<AreaControle> areasControleEntity);
}
