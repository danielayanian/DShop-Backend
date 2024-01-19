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
	
	@GetMapping("/listarDestacados")
	public ResponseEntity<?> listarProductoDestacados(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findDestacados(pageable));
		
	}
	
	@GetMapping("/listarOfertas")
	public ResponseEntity<?> listarProductoOfertas(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findOfertas(pageable));
		
	}
	
	@GetMapping("/listarTelevisores")
	public ResponseEntity<?> listarProductoTelevisores(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findTelevisores(pageable));
		
	}
	
	@GetMapping("/listarCelulares")
	public ResponseEntity<?> listarProductoCelulares(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findCelulares(pageable));
		
	}
	
	@GetMapping("/listarNotebooks")
	public ResponseEntity<?> listarProductoNotebooks(Pageable pageable) {
	
		return ResponseEntity.ok().body(productService.findNotebooks(pageable));
		
	}
	
}
