package com.java.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignment.bean.Unicorn;
import com.java.assignment.serviceimpl.UnicornServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Validated
@Api(tags = "RewardPoint APIs")
@RestController
@RequestMapping(value = "/unicorns")
public class UnicornController {
	
	@Autowired
	private UnicornServiceImpl service;

	@PostMapping()
	@ApiOperation(value = "Create Unicorn ", notes = "Create Unicorn")
	 public ResponseEntity<Integer> createUnicorn(@RequestBody(required = true) Unicorn unicorn) {
		Integer id = service.createUnicorn(unicorn);
		return new ResponseEntity<>(id, HttpStatus.OK);
	} 
	
	@PutMapping("/{unicornId}")
	@ApiOperation(value = "Update Unicorn ", notes = "Update Unicorn")
	public ResponseEntity<Unicorn> updateUnicorn(@ApiParam(value = "unicornId", required = true) @PathVariable("unicornId") String unicornId
			,@RequestBody(required = true) Unicorn unicorn) {
		Unicorn response = service.UpdateUnicorn(unicorn, Integer.parseInt(unicornId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 

	@GetMapping(value = "/unicorns")
	@ApiOperation(value = "Get all Unicorns ", notes = "Get all Unicorns")
	public ResponseEntity<List<Unicorn>> getAll() {
		
		List<Unicorn> result = service.getAll();
		if(result.size() > 0) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/{unicornId}")
	@ApiOperation(value = "Get all Unicorns ", notes = "Get all Unicorns")
	public ResponseEntity<Optional<Unicorn>> getById(@ApiParam(value = "unicornId", required = true) @PathVariable("unicornId") String unicornId) {
		
		Optional<Unicorn> result = service.getById(Integer.parseInt(unicornId));
		if(result.isPresent()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

}
