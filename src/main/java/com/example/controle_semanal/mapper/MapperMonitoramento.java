package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.MonitoramentoRequest;
import com.example.controle_semanal.dto.response.MonitoramentoResponse;
import com.example.controle_semanal.entity.Monitoramento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperMonitoramento {

    Monitoramento toMonitoramento(MonitoramentoRequest monitoramentoRequest);

    MonitoramentoResponse toMonitoramentoResponse(Monitoramento monitoramento);

    List<MonitoramentoResponse> toMonitoramentosResponse(List<Monitoramento> monitoramentos);
}
