package com.ayd.aulas.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "grupo")
@ToString
public class GrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @ManyToOne()
    @ToString.Exclude
    private DocenteEntity docente;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "grupos"
    )
    @ToString.Exclude
    private List<EstudianteEntity> estudiantes;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "grupos")
    @ToString.Exclude
    private List<MateriaEntity> materias;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "grupos")
    @ToString.Exclude
    private List<EstrategiaEntity> estrategias;

//    @Override
//    public String toString() {
//        return "GrupoEntity{}";
//    }
}
