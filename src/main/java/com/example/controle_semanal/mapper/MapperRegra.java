package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.RegraRequest;
import com.example.controle_semanal.dto.response.RegraResponse;
import com.example.controle_semanal.entity.Regra;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperRegra {

    Regra toRegra(RegraRequest regraRequest);

    RegraResponse toRegraResponse(Regra regra);

    List<RegraResponse> toRegrasResponse(List<Regra> regras);
}
