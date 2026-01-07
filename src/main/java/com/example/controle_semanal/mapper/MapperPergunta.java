package com.example.controle_semanal.mapper;

import com.example.controle_semanal.dto.request.PerguntaRequest;
import com.example.controle_semanal.dto.response.PerguntaResponse;
import com.example.controle_semanal.entity.Pergunta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperPergunta {

    Pergunta toPergunta(PerguntaRequest perguntaRequest);

    @Mapping(source = "areaControle.id", target = "areaControleId")
    PerguntaResponse toPerguntaResponse(Pergunta pergunta);


    List<Pergunta> toPerguntas(List<PerguntaRequest> perguntasRequest);

    List<PerguntaResponse> toPerguntasResponse(List<Pergunta> perguntas);
}
