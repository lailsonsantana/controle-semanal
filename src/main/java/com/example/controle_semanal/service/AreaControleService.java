package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.AreaControleRequest;
import com.example.controle_semanal.dto.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControleEntity;
import com.example.controle_semanal.mapper.AreaControleMapper;
import com.example.controle_semanal.repository.AreaControleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AreaControleService {

    private final AreaControleRepository areaControleRepository;
    private final AreaControleMapper areaControleMapper;

    public AreaControleResponse saveAreaControle(AreaControleRequest areaControleRequest){
        AreaControleEntity areaControleEntity = areaControleMapper.toAreaControleEntity(areaControleRequest);
        return areaControleMapper.toAreaControleResponse(areaControleRepository.save(areaControleEntity));
    }
}
