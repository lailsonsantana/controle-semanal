package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.SugestaoRequest;
import com.example.controle_semanal.dto.SugestaoResponse;
import com.example.controle_semanal.entity.SugestaoEntity;
import com.example.controle_semanal.mapper.MapperSugestao;
import com.example.controle_semanal.repository.SugestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SugestaoService {

    private final SugestaoRepository sugestaoRepository;
    private final MapperSugestao mapperSugestao;

    public SugestaoResponse saveSugestao(SugestaoRequest sugestaoRequest){
        SugestaoEntity sugestaoEntity = mapperSugestao.toSugestaoEntity(sugestaoRequest);
        return mapperSugestao.toSugestaoResponse(sugestaoRepository.save(sugestaoEntity));
    }

}
