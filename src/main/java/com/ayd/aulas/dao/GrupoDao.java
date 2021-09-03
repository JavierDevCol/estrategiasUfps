package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoDao extends JpaRepository<GrupoEntity, Long> {

    Optional<GrupoEntity> findByNombre(String nombre);

}
