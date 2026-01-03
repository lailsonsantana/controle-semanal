package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.AreaControle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaControleRepository extends JpaRepository<AreaControle,Long> {

    List<AreaControle> findAllByOrderByIdAsc();
}
