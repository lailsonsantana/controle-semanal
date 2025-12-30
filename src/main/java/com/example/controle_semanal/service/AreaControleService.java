package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.AreaControleRequest;
import com.example.controle_semanal.dto.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControleEntity;
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
        AreaControleEntity areaControleEntity = mapperAreaControle.toAreaControleEntity(areaControleRequest);
        return mapperAreaControle.toAreaControleResponse(areaControleRepository.save(areaControleEntity));
    }

    public List<AreaControleResponse> getAllAreasControle(){
        return mapperAreaControle.toAreasControleResponse(areaControleRepository.findAll());
    }
}
