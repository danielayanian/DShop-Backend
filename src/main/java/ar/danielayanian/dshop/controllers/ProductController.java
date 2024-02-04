package ar.danielayanian.dshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/listarProductosDeUnaCategoria")
	public ResponseEntity<?> listarProductosDeUnaCategoria(Pageable pageable,
			@RequestParam Long idCategoria) {
	
		return ResponseEntity.ok().body(productService.findAllCategoria(idCategoria, 1, pageable));
		
	}
	
	@GetMapping("/getProduct")
	public ResponseEntity<?> getProduct(@RequestParam Long id) {
	
		Product product = productService.findById(id);
		if(product!= null) {
			return ResponseEntity.ok().body(product);
		}
		return  ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<?> buscar(String palabra1, String palabra2,
			String palabra3, String palabra4, Pageable pageable) {
	
		//Cambiar por un metodo que busque las 4 palabras
		return ResponseEntity.ok().body(productService.findAll(pageable));
		
	}
	
	@GetMapping("/filtrarDestPorPrecio")
	public ResponseEntity<?> filtrarDestPorPrecio(Long precio, Pageable pageable) {
		
		return ResponseEntity.ok().body(productService.findAllDestPorPrecio(precio, 1, pageable));
		
	}
	
	@GetMapping("/filtrarOfertasPorPrecio")
	public ResponseEntity<?> filtrarOfertasPorPrecio(Long precio, Pageable pageable) {
		
		return ResponseEntity.ok().body(productService.findAllOfertasPorPrecio(precio, 1, pageable));
		
	}
	
	@GetMapping("/filtrarCategPorPrecio")
	public ResponseEntity<?> filtrarCategPorPrecio(Long precio, Long idCategoria, Pageable pageable) {
		
		return ResponseEntity.ok().body(productService.findAllCategPorPrecio(precio, idCategoria, 1, pageable));
		
	}
	
	
	
}
