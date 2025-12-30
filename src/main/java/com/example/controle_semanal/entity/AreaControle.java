package com.example.controle_semanal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "areaControle")
    @JsonBackReference
    private Set<Sugestao> sugestoes = new HashSet<>();
}
