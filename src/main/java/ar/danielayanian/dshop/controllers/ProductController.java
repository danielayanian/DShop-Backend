package ar.danielayanian.dshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import ar.danielayanian.dshop.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
    private ProductService productService;

	@GetMapping("/pagina") //Este metodo paginara considerando todos los productos
	public ResponseEntity<?> listarPagina(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findAll(pageable));
		
	}
	
}
