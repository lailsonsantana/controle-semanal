package com.example.controle_semanal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SUGESTAO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SugestaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sugestaoMelhoria;

    @ManyToOne
    private AreaControleEntity areaControleEntity;
}
