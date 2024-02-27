package ar.danielayanian.dshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.entities.Purchase;
import ar.danielayanian.dshop.services.PurchaseService;

@RestController
public class PurchaseController {

	@Autowired
    private PurchaseService purchaseService;
	
	@GetMapping("/listarComprasDeUnUsuario")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<?> listarComprasDeUnUsuario(@RequestParam int idUser,
			Pageable pageable) {	
		
		return ResponseEntity.ok().body(purchaseService.findAllPurchaseOfUser(idUser, 1, pageable));
		
	}
	
	@PostMapping("/addPurchase")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public String addPurchase(@RequestBody Purchase purchase) {	
		
		purchaseService.insert(purchase);
    	
		return "OK";
		
	}
	
}
