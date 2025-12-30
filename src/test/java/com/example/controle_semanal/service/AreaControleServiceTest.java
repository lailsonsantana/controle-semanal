package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.AreaControleRequest;
import com.example.controle_semanal.dto.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControleEntity;
import com.example.controle_semanal.mapper.AreaControleMapper;
import com.example.controle_semanal.repository.AreaControleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AreaControleServiceTest {

    @InjectMocks
    private AreaControleService areaControleService;

    @Mock
    private AreaControleMapper areaControleMapper;

    @Mock
    private AreaControleRepository areaControleRepository;

    @Test
    void saveAreaControle() {
        // Arrange
        var areaControleEntity = new AreaControleEntity(3L , "Espiritualidade" , null);
        var areaControleRequest = new AreaControleRequest("Espiritualidade");
        var areaControleResponse = new AreaControleResponse(3L , "Espiritualidade");
        Mockito.when(areaControleMapper.toAreaControleEntity(areaControleRequest)).thenReturn(areaControleEntity);
        Mockito.when(areaControleMapper.toAreaControleResponse(areaControleEntity)).thenReturn(areaControleResponse);
        Mockito.when(areaControleRepository.save(areaControleEntity)).thenReturn(areaControleEntity);

        // Act
        var output = areaControleService.saveAreaControle(areaControleRequest);

        // Assert
        assertEquals(output.id(), areaControleResponse.id());
        assertEquals(output.nome(), areaControleResponse.nome());
    }
}