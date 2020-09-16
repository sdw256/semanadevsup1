package com.devsuperior.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repository.GameRepository;

@Service //para injecao de dependencia
public class GameService {
	
	@Autowired //injecao de dependencia
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //faz com que a parte do banco seja finalizada no service, readOnly evita lock de banco
	public List<GameDTO> findAll(){
		List<Game> games = gameRepository.findAll();
		return games.stream().map(g -> new GameDTO(g)).collect(Collectors.toList());
	}
}
