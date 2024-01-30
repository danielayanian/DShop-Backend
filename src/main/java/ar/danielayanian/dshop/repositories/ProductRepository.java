package ar.danielayanian.dshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ar.danielayanian.dshop.entities.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, JpaRepository<Product, Integer> {
	
	
	//@Query("select f from Foo f where f.name like %?1% or f.alias like %?1% or ...")
	//public List<Foo> findByAnyColumnContaining(String text, Pageable pageable);
	
	/*@Query(value = "select * from product p where p.destacado = %?1% and active = %?2%", 
			   nativeQuery = true)
	Page<Product> findDestacados(String destacado, String active, Pageable pageable);*/
	
	/*@Query(value = "select * from product p where p.destacado = %?1% and active = %?2%", 
			   nativeQuery = true)*/
	Page<Product> findAllByDestacadoAndActive(int destacado, int active, Pageable pageable);
	
	
	
	/*@Query(value = "select * from product p where p.destacado = 1 and active = 1", 
		   nativeQuery = true)
	Page<Product> findDestacados(Pageable pageable);*/
	
	/*@Query(value = "select * from product p where p.oferta = 1 and active = 1", 
			   nativeQuery = true)*/
	Page<Product> findAllByOfertaAndActive(int oferta, int active, Pageable pageable);
	
	/*@Query(value = "select * from product p where p.idCategoria = %?1% and active = %?2%", 
	   nativeQuery = true)*/
	Page<Product> findAllByIdCategoriaAndActive(int idCategoria, int active, Pageable pageable);
	
}
