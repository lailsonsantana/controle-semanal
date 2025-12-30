package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.SemanaRequest;
import com.example.controle_semanal.dto.response.SemanaResponse;
import com.example.controle_semanal.entity.Semana;
import com.example.controle_semanal.mapper.MapperSemana;
import com.example.controle_semanal.repository.SemanaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SemanaService {

    private final SemanaRepository semanaRepository;
    private final MapperSemana mapperSemana;

    public SemanaResponse saveSemana(SemanaRequest semanaRequest){
        Semana semana = semanaRepository.save(mapperSemana.toSemana(semanaRequest));
        return mapperSemana.toSemanaResponse(semana);
    }

    public List<SemanaResponse> getAllSemanas(){
        return mapperSemana.toSemanasResponse(semanaRepository.findAll());
    }
}
