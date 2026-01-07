package com.example.controle_semanal.repository;

import com.example.controle_semanal.entity.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    @Override
    <S extends Pergunta> List<S> saveAll(Iterable<S> entities);

}
