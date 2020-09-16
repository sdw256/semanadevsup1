package com.devsuperior.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;

@RestController
@RequestMapping(value="/games")
public class GameResource {

	@Autowired
	private GameService gameService;
	
	@GetMapping //Avisa que eh uma requisicao get
	private ResponseEntity<List<GameDTO>> findAll(){		
		List<GameDTO> listGame = gameService.findAll();		
		return ResponseEntity.ok().body(listGame);
	}
}
