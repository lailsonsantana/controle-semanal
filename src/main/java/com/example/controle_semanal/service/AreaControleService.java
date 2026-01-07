package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.AreaControleRequest;
import com.example.controle_semanal.dto.request.StatusRequest;
import com.example.controle_semanal.dto.response.AreaControleResponse;
import com.example.controle_semanal.dto.response.StatusResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.entity.enums.Status;
import com.example.controle_semanal.exception.AreaControleNotFoundException;
import com.example.controle_semanal.mapper.MapperAreaControle;
import com.example.controle_semanal.mapper.MapperPergunta;
import com.example.controle_semanal.mapper.MapperSugestao;
import com.example.controle_semanal.repository.AreaControleRepository;
import com.example.controle_semanal.repository.SugestaoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AreaControleService {

    private final AreaControleRepository areaControleRepository;
    private final MapperAreaControle mapperAreaControle;
    private final MapperSugestao mapperSugestao;
    private final MapperPergunta mapperPergunta;

    @Transactional
    public AreaControleResponse saveAreaControle(AreaControleRequest areaControleRequest){
        System.out.println(areaControleRequest);
        AreaControle areaControle = mapperAreaControle.toAreaControle(areaControleRequest);
        areaControle.getPerguntas().forEach(pergunta -> pergunta.setAreaControle(areaControle));
        areaControle.getSugestoes().forEach(sugestao -> sugestao.setAreaControle(areaControle));
        return mapperAreaControle.toAreaControleResponse(areaControleRepository.save(areaControle));
    }

    public List<AreaControleResponse> getAllAreasControle(){
        List<AreaControle> areas = areaControleRepository.findAllByOrderByIdAsc();
        return mapperAreaControle.toAreasControleResponse(areas);
    }

    public AreaControleResponse getAreaControleById(Long id){

        AreaControle area = areaControleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        return mapperAreaControle.toAreaControleResponse(area);
    }

    public AreaControleResponse updateAreaControleById(AreaControleRequest areaControleRequest){
        System.out.println(areaControleRequest);
        Optional<AreaControle> areaControleOp = areaControleRepository.findById(areaControleRequest.id());
        AreaControle area;
        if(areaControleOp.isPresent()){
            area = areaControleOp.get();
            area.setNome(areaControleRequest.nome());
            area.setPontuacao(areaControleRequest.pontuacao());
            area.setPerguntas(mapperPergunta.toPerguntas(areaControleRequest.perguntas()));
            area.setSugestoes(mapperSugestao.toSugestoes(areaControleRequest.sugestoes()));

            if(areaControleRequest.status() != null){
                area.setStatus(Status.valueOf(areaControleRequest.status()));
            }
            areaControleRepository.save(area);
            return mapperAreaControle.toAreaControleResponse(area);
        }
        throw new AreaControleNotFoundException("Área controle não encontrada");
    }

    @Transactional
    public StatusResponse changeStatus(StatusRequest statusRequest){
        AreaControle area = areaControleRepository.findById(statusRequest.id())
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));
        area.setStatus(Status.valueOf(statusRequest.status()));
        return new StatusResponse(area.getStatus().name());
    }
}
