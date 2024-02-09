package ar.danielayanian.dshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ar.danielayanian.dshop.entities.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaRepository<Product, Long> {
	
	
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
	Page<Product> findAllByIdCategoriaAndActive(Long idCategoria, int active, Pageable pageable);
	
	@Query(value = "select * from product where precio <= ?1 and destacado = 1 active = ?2", nativeQuery = true)
	Page<Product> findAllDestPorPrecioMaximo(Long precio, int active, Pageable pageable);
	
	@Query(value = "select * from product where precio <= ?1 and oferta = 1 active = ?2", nativeQuery = true)
	Page<Product> findAllOfertaPorPrecioMaximo(Long precio, int active, Pageable pageable);
	
	@Query(value = "select * from product where precio <= ?1 and active = ?2", nativeQuery = true)
	Page<Product> findAllPorPrecioMaximo(Long precio, int active, Pageable pageable);
	
	@Query(value = "select * from product where precio <= ?1 and destacado = 1 and active = ?2", nativeQuery = true)
	Page<Product> findAllDestPorPrecio(Long precio, int active, Pageable pageable);
	
	@Query(value = "select * from product where precio <= ?1 and oferta = 1 and active = ?2", nativeQuery = true)
	Page<Product> findAllOfertasPorPrecio(Long precio, int active, Pageable pageable);
	
	@Query(value = "select * from product where precio <= ?1 and id_categoria = ?2 and active = ?3", nativeQuery = true)
	Page<Product> findAllCategPorPrecio(Long precio, Long idCategoria, int active, Pageable pageable);
	
	@Query(value = "((select p from Product p where p.tituloNormalizado like %:palabra1% and p.tituloNormalizado like %:palabra2% and p.tituloNormalizado like %:palabra3% and p.active = %:active%)"
			+ " union (select p from Product p where p.tituloNormalizado like %:palabra1% and p.tituloNormalizado like %:palabra2% and p.active = %:active%)"
			+ " union (select p from Product p where p.tituloNormalizado like %:palabra1% and p.active = %:active%)"
			+ " union (select p from Product p where p.tituloNormalizado like %:palabra2% and p.tituloNormalizado like %:palabra3% and p.active = %:active%)"
			+ " union (select p from Product p where p.tituloNormalizado like %:palabra2% and p.active = %:active%)"
			+ " union (select p from Product p where p.tituloNormalizado like %:palabra3% and p.active = %:active%))",
			countQuery = "select count(*) from Product p where ((p.tituloNormalizado like %:palabra1% or p.tituloNormalizado like %:palabra2% or p.tituloNormalizado like %:palabra3%) and p.active = %:active%)")
	Page<Product> findAllWithWords(@Param("palabra1") String palabra1, @Param("palabra2") String palabra2,
			@Param("palabra3") String palabra3, @Param("active") int active, Pageable pageable);
	
	@Query(value = "((select p from Product p where p.precio <= %:precio% and p.tituloNormalizado like %:palabra1% and p.tituloNormalizado like %:palabra2% and p.tituloNormalizado like %:palabra3% and p.active = %:active%)"
			+ " union (select p from Product p where p.precio <= %:precio% and p.tituloNormalizado like %:palabra1% and p.tituloNormalizado like %:palabra2% and p.active = %:active%)"
			+ " union (select p from Product p where p.precio <= %:precio% and p.tituloNormalizado like %:palabra1% and p.active = %:active%)"
			+ " union (select p from Product p where p.precio <= %:precio% and p.tituloNormalizado like %:palabra2% and p.tituloNormalizado like %:palabra3% and p.active = %:active%)"
			+ " union (select p from Product p where p.precio <= %:precio% and p.tituloNormalizado like %:palabra2% and p.active = %:active%)"
			+ " union (select p from Product p where p.precio <= %:precio% and p.tituloNormalizado like %:palabra3% and p.active = %:active%))",
			countQuery = "select count(*) from Product p where ((p.tituloNormalizado like %:palabra1% or p.tituloNormalizado like %:palabra2% or p.tituloNormalizado like %:palabra3%) and p.precio <= %:precio% and p.active = %:active%)")
	Page<Product> findAllWithWordsAndPrice(@Param("palabra1") String palabra1, @Param("palabra2") String palabra2,
			@Param("palabra3") String palabra3, @Param("precio") Long precio, @Param("active") int active, Pageable pageable);
	
}
