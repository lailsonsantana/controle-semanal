package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.AreaControleRequest;
import com.example.controle_semanal.dto.response.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.mapper.MapperAreaControle;
import com.example.controle_semanal.repository.AreaControleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaControleService {

    private final AreaControleRepository areaControleRepository;
    private final MapperAreaControle mapperAreaControle;

    @Transactional
    public AreaControleResponse saveAreaControle(AreaControleRequest areaControleRequest){
        AreaControle areaControle = mapperAreaControle.toAreaControleEntity(areaControleRequest);
        return mapperAreaControle.toAreaControleResponse(areaControleRepository.save(areaControle));
    }

    public List<AreaControleResponse> getAllAreasControle(){
        return mapperAreaControle.toAreasControleResponse(areaControleRepository.findAll());
    }
}
