package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.AreaControleRequest;
import com.example.controle_semanal.dto.request.SugestaoRequest;
import com.example.controle_semanal.dto.response.AreaControleResponse;
import com.example.controle_semanal.dto.response.SugestaoResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.entity.Sugestao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperAreaControle {

    @Mapping(source = "sugestoes", target = "sugestoes")
    AreaControle toAreaControle(AreaControleRequest areaControleRequest);

    AreaControleResponse toAreaControleResponse(AreaControle areaControle);

    List<AreaControleResponse> toAreasControleResponse(List<AreaControle> areasControleEntity);

}
