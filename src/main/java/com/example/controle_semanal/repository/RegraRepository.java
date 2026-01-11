package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.Regra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraRepository extends JpaRepository<Regra, Long> {
}
