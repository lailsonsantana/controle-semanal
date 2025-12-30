package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.SugestaoRequest;
import com.example.controle_semanal.dto.response.SugestaoResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.entity.Sugestao;
import com.example.controle_semanal.exception.AreaControleNotFoundException;
import com.example.controle_semanal.mapper.MapperSugestao;
import com.example.controle_semanal.repository.AreaControleRepository;
import com.example.controle_semanal.repository.SugestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SugestaoService {

    private final SugestaoRepository sugestaoRepository;
    private final AreaControleRepository areaControleRepository;
    private final MapperSugestao mapperSugestao;

    public SugestaoResponse saveSugestao(SugestaoRequest sugestaoRequest){

        Optional<AreaControle> areaControleOptional = areaControleRepository.findById(sugestaoRequest.areaControleId());
        if(areaControleOptional.isPresent()){
            Sugestao sugestao = mapperSugestao.toSugestao(sugestaoRequest);
            //sugestao.setAreaControle(areaControleOptional.get());
            return mapperSugestao.toSugestaoResponse(sugestaoRepository.save(sugestao));
        }

        throw new AreaControleNotFoundException("Área de controle não foi encontrada");
    }

    public List<SugestaoResponse> getAllSugestoes() {
        return mapperSugestao.toSugestoesResponse(sugestaoRepository.findAll());
    }
}
