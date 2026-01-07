package com.example.controle_semanal.entity;

import com.example.controle_semanal.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "TB_AREA_CONTROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaControle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "areaControle", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Sugestao> sugestoes;

    @OneToMany(mappedBy = "areaControle", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Pergunta> perguntas;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer pontuacao;

    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}
