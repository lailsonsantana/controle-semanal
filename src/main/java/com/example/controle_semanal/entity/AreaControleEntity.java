package com.example.controle_semanal.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TB_AREA_CONTROLE")
public class AreaControleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    private Set<SugestaoEntity> sugestoes;
}
