package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.SugestaoRequest;
import com.example.controle_semanal.dto.SugestaoResponse;
import com.example.controle_semanal.entity.SugestaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperSugestao {

    SugestaoEntity toSugestaoEntity(SugestaoRequest sugestaoRequest);

    SugestaoResponse toSugestaoResponse(SugestaoEntity sugestaoEntity);

    List<SugestaoEntity> toSugestoesEntity(List<SugestaoRequest> sugestoesRequest);

    List<SugestaoResponse> toSugestoesResponse(List<SugestaoEntity> sugestoesEntity);
}
