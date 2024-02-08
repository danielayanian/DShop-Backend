package ar.danielayanian.dshop.services;

import java.text.Normalizer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.repositories.CategoryRepository;

@Service
public class InitServiceImpl implements InitService {

	@Autowired
	UserService userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	public void loadInitial() {
		
		Optional<UserDTO> userDTOOpt = userService.findByEmail("dani@gmail.com");
    	
    	if(!userDTOOpt.isPresent()) {
    		
    		//Cargo el usuario ADMIN en la DB
    		UserDTO userDTO = new UserDTO();
    		userDTO.setNombre("Daniel");
    		userDTO.setApellido("Ayanian");
    		userDTO.setEmail("dani@gmail.com");
    		userDTO.setPassword(passwordEncoder.encode("root"));
        	userDTO.setRoles("ADMIN");
        	
        	userService.userRegist(userDTO);
        	
        	//Cargo las categorias iniciales en la DB
        	Category category1 = new Category();
    		category1.setNombre("Remeras");
    		categoryService.insert(category1);
    		//categoryRepository.save(category1);
    		
    		Category category2 = new Category();
    		category2.setNombre("Pantalones");
    		categoryService.insert(category2);
    		
    		Category category3 = new Category();
    		category3.setNombre("Buzos");
    		categoryService.insert(category3);
    		
    		Category category4 = new Category();
    		category4.setNombre("Camperas");
    		categoryService.insert(category4);
    		
    		Category category5 = new Category();
    		category5.setNombre("Medias");
    		categoryService.insert(category5);
        	
    		//Cargo productos iniciales en la DB
        	Product product = new Product();
        	product.setTitulo("Remera roja marca Narrow");
        	product.setTituloNormalizado(normalize("Remera roja marca Narrow"));
        	product.setDescripcion("Remera cuello redondo, 100% algodón, ideal para el verano.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(45000);
        	product.setStock(23);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera verde marca Narrow");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera cuello redondo, 100% algodón, ideal para el verano.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(45000);
        	product.setStock(14);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean azul marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean verde marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean verde marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean azul marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean azul marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean azul marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean rojo marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean azul marca Levis");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Moderno pantalón de jean, de la legendaria marca Levis. Modelo ajustado.");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(84000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	
    	}
		
	}
	
	public static String normalize(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
	
}
