package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Long> {
}
