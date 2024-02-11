package ar.danielayanian.dshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.danielayanian.dshop.entities.Purchase;

public interface PurchaseService {

	public Page<Purchase> findAllPurchaseOfUser(int idUser, int active, Pageable pageable);
	
	public void insert(Purchase purchase);
	
}
