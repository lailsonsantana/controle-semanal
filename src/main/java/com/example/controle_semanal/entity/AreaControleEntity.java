package com.example.controle_semanal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "TB_AREA_CONTROLE")
@Data
@AllArgsConstructor
public class AreaControleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    private Set<SugestaoEntity> sugestoes;
}
