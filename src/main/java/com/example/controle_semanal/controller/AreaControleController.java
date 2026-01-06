package com.example.controle_semanal.controller;

import com.example.controle_semanal.dto.request.AreaControleRequest;
import com.example.controle_semanal.dto.request.StatusRequest;
import com.example.controle_semanal.dto.response.AreaControleResponse;
import com.example.controle_semanal.dto.response.StatusResponse;
import com.example.controle_semanal.service.AreaControleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/areas-controle")
@AllArgsConstructor
public class AreaControleController {

    private final AreaControleService areaControleService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AreaControleRequest areaControleRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(areaControleService.saveAreaControle(areaControleRequest));
    }

    @GetMapping
    public ResponseEntity<List<AreaControleResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(areaControleService.getAllAreasControle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaControleResponse> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(areaControleService.getAreaControleById(id));
    }

    @PutMapping
    public ResponseEntity<AreaControleResponse> updateById(@RequestBody AreaControleRequest areaControleRequest){
        return ResponseEntity.status(HttpStatus.OK).body(areaControleService.updateAreaControleById(areaControleRequest));
    }

    @PutMapping("mudar-status")
    public ResponseEntity<StatusResponse> updateStatus(@RequestBody StatusRequest statusRequest){
        return ResponseEntity.status(HttpStatus.OK).body(areaControleService.changeStatus(statusRequest));
    }
}
