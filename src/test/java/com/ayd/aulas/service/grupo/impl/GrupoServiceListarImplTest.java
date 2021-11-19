package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrupoServiceListarImplTest {

    private GrupoEntity grupoEntity;
    private GrupoDto grupoDto;
    private GrupoResponseDto grupoResponseDto;
    private ArrayList<GrupoEntity> grupoEntities;
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        grupoDto = new GrupoDto();
        grupoEntity = new GrupoEntity();
        grupoEntity.setId(1l);
        grupoEntity.setNombre("A");
        grupoEntity.setAnioGrupos(new ArrayList<ClaseEntity>());

        grupoResponseDto = new GrupoResponseDto();
        grupoResponseDto.setDocente(1l);
        grupoResponseDto.setEstrategias(new ArrayList<Long>(1));
        grupoResponseDto.setEstudiantes(new ArrayList<Long>(1));
        grupoResponseDto.setId(1l);
        grupoResponseDto.setMaterias(new ArrayList<Long>(1));
        grupoResponseDto.setNombre("A");

        grupoEntities = new ArrayList<>();
        grupoEntities.add(grupoEntity);

    }

    @Mock
    private GrupoDao grupoDao;

    @Mock
    private GrupoServiceListarImpl grupoServiceListar;

    @Test
    void ejecutar() {
        Mockito.when(grupoDao.findAll()).thenReturn(grupoEntities);
        Assert.assertNotNull(grupoServiceListar.ejecutar());
    }
}