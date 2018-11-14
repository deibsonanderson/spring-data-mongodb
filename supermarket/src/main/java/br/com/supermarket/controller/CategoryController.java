package br.com.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supermarket.dto.Category;
import br.com.supermarket.service.CategoryService;

@RestController
@RequestMapping("/supermarket")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok(categoryService.findAll());		
	}
	
	@GetMapping(value = "/category/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> findByName(@PathVariable("name") String name) {
		return ResponseEntity.ok(categoryService.findByName(name));		
	}

	@GetMapping(value = "/category/regex/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> findByNameRegex(@PathVariable("name") String name) {
		return ResponseEntity.ok(categoryService.findByNameRegex(name));		
	}	
	
	@PostMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.create(category));		
	}
	
	@PutMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> update(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.update(category));		
	}
	
	@DeleteMapping(value = "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
		categoryService.remove(id);	
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}