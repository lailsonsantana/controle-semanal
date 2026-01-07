package com.example.controle_semanal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PERGUNTA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String textoPergunta;

    @ManyToOne
    @JsonBackReference
    private AreaControle areaControle;
}
