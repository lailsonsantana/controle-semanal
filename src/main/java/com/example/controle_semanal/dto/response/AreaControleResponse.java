package com.example.controle_semanal.dto.response;

import com.example.controle_semanal.entity.Sugestao;


import java.util.List;

public record AreaControleResponse(
        Long id,
        String nome,
        List<Sugestao> sugestoes,
        String status,
        String dataCriacao,
        int pontuacao
) {
}
