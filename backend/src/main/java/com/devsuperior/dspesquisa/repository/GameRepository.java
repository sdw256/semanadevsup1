package com.devsuperior.dspesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Game;

@Repository //Registra a classe no mecanismo de injecao de dependencia
public interface GameRepository extends JpaRepository<Game, Long> {

}
