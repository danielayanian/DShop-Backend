package ar.danielayanian.dshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ar.danielayanian.dshop.entities.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, JpaRepository<Product,Integer> {
	
}
