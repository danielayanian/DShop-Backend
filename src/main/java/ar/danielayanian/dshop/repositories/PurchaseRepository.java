package ar.danielayanian.dshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ar.danielayanian.dshop.entities.Purchase;

@EnableJpaRepositories
@Repository
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long>, JpaRepository<Purchase, Long> {

	@Query(value = "select * from purchase where id_user = ?1 and active = ?2", nativeQuery = true)
    Page<Purchase> findAllPurchaseOfUser(int idUser, int active, Pageable pageable);
	
}
