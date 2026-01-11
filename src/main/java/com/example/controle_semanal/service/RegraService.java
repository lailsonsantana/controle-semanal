package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.RegraRequest;
import com.example.controle_semanal.dto.response.RegraResponse;
import com.example.controle_semanal.mapper.MapperRegra;
import com.example.controle_semanal.repository.RegraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegraService {

    private final MapperRegra mapperRegra;
    private final RegraRepository regraRepository;

    public RegraResponse saveRegra(RegraRequest regraRequest){
        return mapperRegra.toRegraResponse(regraRepository.save(mapperRegra.toRegra(regraRequest)));
    }

    public List<RegraResponse> getAllRegras(){
        return mapperRegra.toRegrasResponse(regraRepository.findAll());
    }
}
