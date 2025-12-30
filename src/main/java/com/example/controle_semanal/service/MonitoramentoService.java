package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.MonitoramentoRequest;
import com.example.controle_semanal.dto.response.MonitoramentoResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.entity.Monitoramento;
import com.example.controle_semanal.entity.Semana;
import com.example.controle_semanal.exception.AreaControleNotFoundException;
import com.example.controle_semanal.mapper.MapperMonitoramento;
import com.example.controle_semanal.repository.AreaControleRepository;
import com.example.controle_semanal.repository.MonitoramentoRepository;
import com.example.controle_semanal.repository.SemanaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MonitoramentoService {

    private final MonitoramentoRepository monitoramentoRepository;
    private final SemanaRepository semanaRepository;
    private final AreaControleRepository areaControleRepository;
    private final MapperMonitoramento mapperMonitoramento;

    public MonitoramentoResponse saveMonitoramento(MonitoramentoRequest monitoramentoRequest){
        Optional<Semana> optionalSemana = semanaRepository.findById(monitoramentoRequest.semanaId());
        Optional<AreaControle> optionalAreaControle = areaControleRepository.findById(monitoramentoRequest.areaControleId());

        if(optionalSemana.isPresent() && optionalAreaControle.isPresent()){
            Monitoramento monitoramento = monitoramentoRepository.save(mapperMonitoramento.toMonitoramento(monitoramentoRequest));
            return mapperMonitoramento.toMonitoramentoResponse(monitoramento);
        }

        throw new AreaControleNotFoundException("Área controle não encontrada");
    }

    public List<MonitoramentoResponse> getAllMonitoramentos(){
        return mapperMonitoramento.toMonitoramentosResponse(monitoramentoRepository.findAll());
    }
}
