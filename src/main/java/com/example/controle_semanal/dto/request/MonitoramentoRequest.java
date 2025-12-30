package com.example.controle_semanal.dto.request;

public record MonitoramentoRequest (
        Long areaControleId,
        Long semanaId,
        int pontuacao
){
}
