package com.collabera.material.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.material.service.MaterialService;
import com.collabera.material.itemdto.ItemDto;

@RestController
public class MaterialController {

	private final MaterialService service;

	public MaterialController(MaterialService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/api/materials")
	public List<ItemDto> getAll() {

		return service.findAll();
	}

	@GetMapping("/api/materials/{id}")
	public ResponseEntity<ItemDto> getByID(@PathVariable long id) {
		ItemDto hero = service.findById(id);

		return ResponseEntity.ok(hero);
	}

	@PostMapping("/api/materials")
	public ResponseEntity<ItemDto> post(@RequestBody @Valid ItemDto materials) throws URISyntaxException {

		ItemDto result = service.save(materials);

		return ResponseEntity.created(new URI("/api/materials/" + result.getId())).body(result);
	}

	@PutMapping("/api/materials")
	public ResponseEntity<ItemDto> updateJob(@RequestBody @Valid ItemDto hero) {
		ItemDto result = service.update(hero);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/api/materials/{id}")
	public ResponseEntity<Void> deleteByID(@PathVariable Long id) {

		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
