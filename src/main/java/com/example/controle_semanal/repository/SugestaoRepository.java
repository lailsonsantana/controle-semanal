package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.SugestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<SugestaoEntity, Long> {
}
