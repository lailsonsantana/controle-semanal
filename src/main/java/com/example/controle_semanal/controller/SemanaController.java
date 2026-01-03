package com.example.controle_semanal.controller;

import com.example.controle_semanal.dto.request.SemanaRequest;
import com.example.controle_semanal.dto.response.SemanaResponse;
import com.example.controle_semanal.service.SemanaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/semanas")
@AllArgsConstructor
public class SemanaController {

    private final SemanaService semanaService;

    @PostMapping
    ResponseEntity<?> save(@RequestBody SemanaRequest semanaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(semanaService.saveSemana(semanaRequest));
    }

    @GetMapping
    ResponseEntity<List<SemanaResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(semanaService.getAllSemanas());
    }

}
