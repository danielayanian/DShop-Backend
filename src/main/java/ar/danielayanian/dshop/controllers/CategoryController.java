package ar.danielayanian.dshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.services.CategoryService;
import ar.danielayanian.dshop.services.ProductService;

@RestController
public class CategoryController {

	@Autowired
    private CategoryService categoryService;
	
	@GetMapping("/getCategories")
	public ResponseEntity<?> getCategories() {
	
		return ResponseEntity.ok().body(categoryService.findAllCategorias());
		
	}
	
	@GetMapping("/getCategory")
	public ResponseEntity<?> getCategory(@RequestParam int id) {
		
		Category category = categoryService.findById(id);
		
		if(category!= null) {
			
			return ResponseEntity.ok().body(category);
		}
		return  ResponseEntity.notFound().build();
		
	}
	
}
