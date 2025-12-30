package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {
}
