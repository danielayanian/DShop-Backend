package ar.danielayanian.dshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ar.danielayanian.dshop.entities.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, JpaRepository<Product,Integer> {
	
	@Query(value = "SELECT * FROM PRODUCT P WHERE P.DESTACADO = 1 AND ACTIVE = 1", 
		   nativeQuery = true)
	Page<Product> findDestacados(Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT P WHERE P.OFERTA = 1 AND ACTIVE = 1", 
			   nativeQuery = true)
	Page<Product> findOfertas(Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT P WHERE P.DESTACADO = 1", 
			   nativeQuery = true)
	Page<Product> findTelevisores(Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT P WHERE P.DESTACADO = 1", 
			   nativeQuery = true)
	Page<Product> findCelulares(Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT P WHERE P.DESTACADO = 1", 
			   nativeQuery = true)
	Page<Product> findNotebooks(Pageable pageable);
	
}
