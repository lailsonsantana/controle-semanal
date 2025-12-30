package com.example.controle_semanal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SEMANA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Semana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer semana;

}
