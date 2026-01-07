package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.PerguntaRequest;
import com.example.controle_semanal.dto.request.SugestaoRequest;
import com.example.controle_semanal.dto.response.PerguntaResponse;
import com.example.controle_semanal.dto.response.SugestaoResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.entity.Pergunta;
import com.example.controle_semanal.entity.Sugestao;
import com.example.controle_semanal.exception.AreaControleNotFoundException;
import com.example.controle_semanal.mapper.MapperPergunta;
import com.example.controle_semanal.mapper.MapperSugestao;
import com.example.controle_semanal.repository.AreaControleRepository;
import com.example.controle_semanal.repository.PerguntaRepository;
import com.example.controle_semanal.repository.SugestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;
    private final AreaControleRepository areaControleRepository;
    private final MapperPergunta mapperPergunta;

    public PerguntaResponse savePergunta(PerguntaRequest perguntaRequest){

        Optional<AreaControle> areaControleOptional = areaControleRepository.findById(perguntaRequest.areaControleId());
        if(areaControleOptional.isPresent()){
            Pergunta pergunta = mapperPergunta.toPergunta(perguntaRequest);
            //sugestao.setAreaControle(areaControleOptional.get());
            return mapperPergunta.toPerguntaResponse(perguntaRepository.save(pergunta));
        }

        throw new AreaControleNotFoundException("Área de controle não foi encontrada");
    }


    public List<PerguntaResponse> getAllSugestoes() {
        return mapperPergunta.toPerguntasResponse(perguntaRepository.findAll());
    }
}

