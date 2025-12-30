package com.example.controle_semanal.controller;

import com.example.controle_semanal.dto.request.MonitoramentoRequest;
import com.example.controle_semanal.dto.response.MonitoramentoResponse;
import com.example.controle_semanal.service.MonitoramentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/monitoramentos")
@AllArgsConstructor
public class MonitoramentoController {

    private final MonitoramentoService monitoramentoService;

    @PostMapping
    ResponseEntity<?> save(@RequestBody MonitoramentoRequest monitoramentoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(monitoramentoService.saveMonitoramento(monitoramentoRequest));
    }

    @GetMapping
    ResponseEntity<List<MonitoramentoResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(monitoramentoService.getAllMonitoramentos());
    }
}
