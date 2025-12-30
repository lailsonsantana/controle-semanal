package com.example.controle_semanal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SUGESTAO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sugestaoMelhoria;

    @ManyToOne
    @JsonBackReference
    private AreaControle areaControle;
}
