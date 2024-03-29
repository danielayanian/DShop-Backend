package ar.danielayanian.dshop.services;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.repositories.ProductRepository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(int destacado, int active, int stock, Pageable pageable) {
		return productRepository.findAllByDestacadoAndActiveAndStockGreaterThan(destacado, active, stock, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	/*@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(Pageable pageable) {
		return productRepository.findDestacados(pageable);
	}*/
	/*@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(String destacado, String active, Pageable pageable) {
		return productRepository.findDestacados(destacado, active, pageable);
	}*/
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findOfertas(int oferta, int active, int stock, Pageable pageable) {
		return productRepository.findAllByOfertaAndActiveAndStockGreaterThan(oferta, active, stock, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllCategoria(Long idCategoria, int active, int stock, Pageable pageable) {
		return productRepository.findAllByIdCategoriaAndActiveAndStockGreaterThan(idCategoria, active, stock, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		
		Optional<Product> op = productRepository.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}
		return null;
		
	}
	
	@Override
	@Transactional
	public void insert(Product product) {
		productRepository.save(product);
	}
	
	@Override
	@Transactional
	public void save(Product product) {
		
		productRepository.save(product);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllDestPorPrecio(Long precio, int active, Pageable pageable){
		return productRepository.findAllDestPorPrecio(precio, active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllOfertasPorPrecio(Long precio, int active, Pageable pageable){
		return productRepository.findAllOfertasPorPrecio(precio, active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllCategPorPrecio(Long precio, Long idCategoria, int active, Pageable pageable){
		return productRepository.findAllCategPorPrecio(precio, idCategoria, active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllWithWords(String palabra1, String palabra2, String palabra3, int active, Pageable pageable){
		
		return productRepository.findAllWithWords(normalize(palabra1), normalize(palabra2), normalize(palabra3), active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllWithWordsAndPrice(String palabra1, String palabra2, String palabra3, Long precio,
			int active, Pageable pageable){
		
		return productRepository.findAllWithWordsAndPrice(normalize(palabra1), normalize(palabra2), normalize(palabra3),
				precio, active, pageable);
	}
	
	
	public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
	
	public static String normalize(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
	
}
