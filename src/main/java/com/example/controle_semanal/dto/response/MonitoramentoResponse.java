package com.example.controle_semanal.dto.response;

public record MonitoramentoResponse(
    Long areaControleId,
    Long semanaId,
    int pontuacao
) {
}
