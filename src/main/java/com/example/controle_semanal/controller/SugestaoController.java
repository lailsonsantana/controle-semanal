package com.example.controle_semanal.controller;

import com.example.controle_semanal.dto.SugestaoRequest;
import com.example.controle_semanal.service.SugestaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sugestoes")
@AllArgsConstructor
public class SugestaoController {

    private final SugestaoService sugestaoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SugestaoRequest sugestaoResquest){
        return ResponseEntity.status(HttpStatus.CREATED).body(sugestaoService.saveSugestao(sugestaoResquest));
    }
}
