package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

    @Override
    <S extends Sugestao> List<S> saveAll(Iterable<S> entities);
}
