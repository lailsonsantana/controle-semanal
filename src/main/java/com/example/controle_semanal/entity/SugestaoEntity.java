package com.example.controle_semanal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SUGESTAO")
public class SugestaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sugestaoMelhoria;

    @ManyToOne
    private AreaControleEntity areaControleEntity;
}
