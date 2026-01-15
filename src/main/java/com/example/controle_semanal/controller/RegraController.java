package com.example.controle_semanal.controller;

import com.example.controle_semanal.dto.request.RegraRequest;
import com.example.controle_semanal.dto.response.RegraResponse;
import com.example.controle_semanal.service.RegraService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("api/regras")
@AllArgsConstructor
public class RegraController {

    private final RegraService regraService;


    @GetMapping
    public ResponseEntity<?> save(@RequestBody RegraRequest regraRequest){
        return ResponseEntity.status(HttpStatus.OK).body(regraService.saveRegra(regraRequest));
    }

    public ResponseEntity<List<RegraResponse>> getAll(){
        return ResponseEntity.ok(regraService.getAllRegras());
    }
}
