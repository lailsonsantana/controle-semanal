package com.example.controle_semanal.service;

import com.example.controle_semanal.dto.request.AreaControleRequest;
import com.example.controle_semanal.dto.response.AreaControleResponse;
import com.example.controle_semanal.entity.AreaControle;
import com.example.controle_semanal.mapper.MapperAreaControle;
import com.example.controle_semanal.repository.AreaControleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AreaControleServiceTest {

    @InjectMocks
    private AreaControleService areaControleService;

    @Mock
    private MapperAreaControle mapperAreaControle;

    @Mock
    private AreaControleRepository areaControleRepository;

    @Test
    void saveAreaControle() {
        // Arrange
        var areaControleEntity = new AreaControle(3L , "Espiritualidade" , null);
        var areaControleRequest = new AreaControleRequest("Espiritualidade");
        var areaControleResponse = new AreaControleResponse(3L , "Espiritualidade");
        Mockito.when(mapperAreaControle.toAreaControleEntity(areaControleRequest)).thenReturn(areaControleEntity);
        Mockito.when(mapperAreaControle.toAreaControleResponse(areaControleEntity)).thenReturn(areaControleResponse);
        Mockito.when(areaControleRepository.save(areaControleEntity)).thenReturn(areaControleEntity);

        // Act
        var output = areaControleService.saveAreaControle(areaControleRequest);

        // Assert
        assertEquals(output.id(), areaControleResponse.id());
        assertEquals(output.nome(), areaControleResponse.nome());
    }
}