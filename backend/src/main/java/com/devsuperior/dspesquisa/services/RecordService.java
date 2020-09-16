package com.devsuperior.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repository.GameRepository;
import com.devsuperior.dspesquisa.repository.RecordRepository;

@Service //para injecao de dependencia
public class RecordService {
	
	@Autowired //injecao de dependencia
	private RecordRepository recordRepository;
	
	@Autowired //injecao de dependencia
	private GameRepository gameRepository;
	
	@Transactional//faz com que a parte do banco seja finalizada no service
	public RecordDTO insert(RecordInsertDTO dto){
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setMoment(Instant.now());
		entity.setAge(dto.getAge());
		
		Game game = gameRepository.getOne(dto.getGameId());		
		entity.setGame(game);		
		entity = recordRepository.save(entity);
		
		return new RecordDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}
}
