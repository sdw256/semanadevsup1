package com.devsuperior.dspesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;

@RestController
@RequestMapping(value="/records")
public class RecordResource {

	@Autowired
	private RecordService recordService;
	
	@PostMapping //Avisa que eh uma requisicao post
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){		
		//@RequestBody informa que o json esta vindo do body		
		RecordDTO newDto = recordService.insert(dto);		
		return ResponseEntity.ok().body(newDto);
	}
}
