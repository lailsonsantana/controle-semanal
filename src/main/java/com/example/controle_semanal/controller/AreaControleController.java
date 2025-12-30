package com.example.controle_semanal.controller;

import com.example.controle_semanal.dto.AreaControleRequest;
import com.example.controle_semanal.service.AreaControleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/areas-controle")
@AllArgsConstructor
public class AreaControleController {

    private final AreaControleService areaControleService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AreaControleRequest areaControleRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(areaControleService.saveAreaControle(areaControleRequest));
    }
}
