package com.example.controle_semanal.dto.request;

import java.util.List;

public record AreaControleRequest(
        String nome,
        String status,
        List<SugestaoRequest> sugestoes
) {
}
