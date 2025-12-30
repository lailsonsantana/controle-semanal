package com.example.controle_semanal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "TB_AREA_CONTROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaControleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    private Set<SugestaoEntity> sugestoes;
}
