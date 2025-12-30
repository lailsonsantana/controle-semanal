package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.AreaControle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaControleRepository extends JpaRepository<AreaControle,Long> {
}
