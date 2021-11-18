package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaEntityToEstrategiaResponseDto;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class EstrategiaServiceBuscarNombreImplTest {

    private EstrategiaEntity estrategiaEntity;
    private EstrategiaDto estrategiaDto;
    private EstrategiaResponseDto estrategiaResponseDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estrategiaDto = new EstrategiaDto();

        estrategiaEntity = new EstrategiaEntity();
        estrategiaEntity.setNombre("PRUEBA");
        estrategiaEntity.setDescripcion("UNITARIA");
        estrategiaEntity.setId(1l);

        estrategiaResponseDto = new EstrategiaResponseDto();
        estrategiaResponseDto.setNombre("PRUEBA");
        estrategiaResponseDto.setDescripcion("UNITARIAS");
        estrategiaResponseDto.setId(1l);
    }

    @Mock
    private EstrategiaDao estrategiaDao;

    @Mock
    private EstrategiaEntityToEstrategiaResponseDto toEstrategiaResponseDto;

    @InjectMocks
    private EstrategiaServiceBuscarNombreImpl estrategiaServiceBuscarNombre;

    @Test
    void ejecutar() {
        Mockito.when(estrategiaDao.findByNombre(Mockito.anyString()))
                .thenReturn(java.util.Optional.ofNullable(estrategiaEntity));
        Mockito.when(toEstrategiaResponseDto.entityToResonse(estrategiaEntity)).thenReturn(estrategiaResponseDto);
        Assert.assertNotNull(estrategiaServiceBuscarNombre.ejecutar(estrategiaResponseDto.getNombre()));
    }
}