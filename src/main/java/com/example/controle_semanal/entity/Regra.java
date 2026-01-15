package com.example.controle_semanal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_REGRA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Regra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}
