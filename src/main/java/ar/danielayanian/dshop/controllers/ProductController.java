package ar.danielayanian.dshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
    private ProductService productService;

	@GetMapping("/listarTodos")
	public ResponseEntity<?> listarTodos(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findAll(pageable));
		
	}
	
	@GetMapping("/listarDestacados")
	public ResponseEntity<?> listarProductoDestacados(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findDestacados(1, 1, pageable));
		
	}
	
	@GetMapping("/listarOfertas")
	public ResponseEntity<?> listarProductoOfertas(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findOfertas(1, 1, pageable));
		
	}
	
	@GetMapping("/listarTelevisores")
	public ResponseEntity<?> listarProductoTelevisores(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findAllCategoria(1, 1, pageable));
		
	}
	
	@GetMapping("/listarCelulares")
	public ResponseEntity<?> listarProductoCelulares(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findAllCategoria(2, 1, pageable));
		
	}
	
	@GetMapping("/listarNotebooks")
	public ResponseEntity<?> listarProductoNotebooks(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findAllCategoria(3, 1, pageable));
		
	}
	
	@GetMapping("/getProduct")
	public ResponseEntity<?> getProduct(@RequestParam int id) {
	
		Product product = productService.findById(id);
		if(product!= null) {
			return ResponseEntity.ok().body(product);
		}
		return  ResponseEntity.notFound().build();
		
	}
	
}
