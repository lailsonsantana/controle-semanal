package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.SugestaoRequest;
import com.example.controle_semanal.dto.response.SugestaoResponse;
import com.example.controle_semanal.entity.Sugestao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperSugestao {

    @Mapping(source = "areaControleId", target = "areaControle.id")
    Sugestao toSugestao(SugestaoRequest sugestaoRequest);

    @Mapping(source = "areaControle.id", target = "areaControleId")
    SugestaoResponse toSugestaoResponse(Sugestao sugestao);

    List<Sugestao> toSugestoesEntity(List<SugestaoRequest> sugestoesRequest);

    List<SugestaoResponse> toSugestoesResponse(List<Sugestao> sugestoesEntity);
}
