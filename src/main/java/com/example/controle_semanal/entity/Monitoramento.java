package com.example.controle_semanal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MONITORAMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long areaControleId;

    private Long semanaId;

    private int pontuacao;
}
