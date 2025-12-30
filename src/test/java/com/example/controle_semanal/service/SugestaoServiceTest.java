package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.SugestaoRequest;
import com.example.controle_semanal.dto.response.SugestaoResponse;
import com.example.controle_semanal.entity.Sugestao;
import com.example.controle_semanal.mapper.MapperSugestao;
import com.example.controle_semanal.repository.SugestaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SugestaoServiceTest {

    @InjectMocks
    private SugestaoService sugestaoService;

    @Mock
    private MapperSugestao mapperSugestao;

    @Mock
    private SugestaoRepository sugestaoRepository;

    @Test
    void saveSugestao() {
        // Arrange
        var sugestaoEntity = new Sugestao(2L , "Comprar bananas", null);
        var sugestaoRequest = new SugestaoRequest("Comprar bananas", 2L);
        var sugestaoResponse = new SugestaoResponse(2L, "Comprar bananas", null);
        // Act
        Mockito.when(sugestaoRepository.save(sugestaoEntity)).thenReturn(sugestaoEntity);
        Mockito.when(mapperSugestao.toSugestao(sugestaoRequest)).thenReturn(sugestaoEntity);
        Mockito.when(mapperSugestao.toSugestaoResponse(sugestaoEntity)).thenReturn(sugestaoResponse);

        var output = sugestaoService.saveSugestao(sugestaoRequest);

        // Assert
        assertEquals(output.id(), sugestaoResponse.id());
        assertEquals(output.sugestaoMelhoria(), sugestaoResponse.sugestaoMelhoria());

    }
}