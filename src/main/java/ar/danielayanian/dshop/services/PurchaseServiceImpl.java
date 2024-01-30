package ar.danielayanian.dshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.danielayanian.dshop.entities.Purchase;
import ar.danielayanian.dshop.repositories.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
    private PurchaseRepository purchaseRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Purchase> findAllPurchaseOfUser(int idUser, int active, Pageable pageable) {
		return purchaseRepository.findAllPurchaseOfUser(idUser, active, pageable);
	}
	
}
