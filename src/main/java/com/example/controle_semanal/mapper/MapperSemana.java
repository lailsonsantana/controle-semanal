package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.SemanaRequest;
import com.example.controle_semanal.dto.response.SemanaResponse;
import com.example.controle_semanal.entity.Semana;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperSemana {

    Semana toSemana(SemanaRequest semanaRequest);

    SemanaResponse toSemanaResponse(Semana semana);

    List<SemanaResponse> toSemanasResponse(List<Semana> semanas);
}
