package ar.danielayanian.dshop.services;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.entities.Purchase;
import ar.danielayanian.dshop.entities.User;

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
	
	@Autowired
	PurchaseService purchaseService;
	
	public void loadInitial() {
		
		Optional<User> userOpt = userService.findByEmail("admin@gmail.com");
    	
    	if(!userOpt.isPresent()) {
    		
    		//Cargo el usuario ADMIN en la DB
    		User userAdmin = new User();
    		userAdmin.setNombre("Daniel");
    		userAdmin.setApellido("Ayanian");
    		userAdmin.setEmail("admin@gmail.com");
    		userAdmin.setPassword(passwordEncoder.encode("Dan-1234"));
    		userAdmin.setRoles("ADMIN");
        	
        	userService.userRegist(userAdmin);
        	
        	//Cargo un usuario USER en la DB
    		User userUser = new User();
    		userUser.setNombre("Juan");
    		userUser.setApellido("Lopez");
    		userUser.setEmail("user@gmail.com");
    		userUser.setPassword(passwordEncoder.encode("Dan-1234"));
    		userUser.setRoles("USER");
        	
        	userService.userRegist(userUser);
        	
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
        	
    		//Creo un calendario
    		Calendar calendario = Calendar.getInstance();
    		
    		//Cargo productos iniciales en la DB
        	Product product = new Product();
        	product.setTitulo("Remera negra Narrow Classic manga corta");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva de algodón, manga corta y cuello redondo, marca Narrow Classic.");
        	product.setFotoPrecargada("1.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(0);
        	product.setPrecio(25000);
        	product.setStock(23);
        	productService.insert(product);
        	
        	Purchase purchase = new Purchase();
        	purchase.setFecha(calendario.get(Calendar.DATE)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+calendario.get(Calendar.YEAR));
        	purchase.setCantidad(1);
        	purchase.setPrecioUnidad(25000);
        	product.setId((long)1);
        	purchase.setProduct(product);
        	purchase.setIdUser((long)1);
        	purchase.setActive(1);
        	purchaseService.insert(purchase);
        	
        	product = new Product();
        	product.setTitulo("Remera azul petróleo marca Narrow");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva de algodón, manga corta y cuello redondo, marca Narrow Classic.");
        	product.setFotoPrecargada("2.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(25000);
        	product.setStock(14);
        	productService.insert(product);
        	
        	purchase = new Purchase();
        	purchase.setFecha(calendario.get(Calendar.DATE)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+calendario.get(Calendar.YEAR));
        	purchase.setCantidad(1);
        	purchase.setPrecioUnidad(25000);
        	product.setId((long)2);
        	purchase.setProduct(product);
        	purchase.setIdUser((long)1);
        	purchase.setActive(1);
        	purchaseService.insert(purchase);
        	
        	product = new Product();
        	product.setTitulo("Remera blanca marca Narrow");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva de algodón, manga corta y cuello redondo, marca Narrow Classic.");
        	product.setFotoPrecargada("3.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(35000);
        	product.setStock(16);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera amarilla entrenamiento running crossfit");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva marca Kadur. Corte regular Fit. Confeccionadas con poliéster de primra calidad. Para todo tipo de deportes.");
        	product.setFotoPrecargada("4.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(12200);
        	product.setStock(26);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera naranja entrenamiento running crossfit");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva marca Kadur. Corte regular Fit. Confeccionadas con poliéster de primra calidad. Para todo tipo de deportes.");
        	product.setFotoPrecargada("5.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(18000);
        	product.setStock(14);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera roja entrenamiento running crossfit");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva marca Kadur. Corte regular Fit. Confeccionadas con poliéster de primra calidad. Para todo tipo de deportes.");
        	product.setFotoPrecargada("6.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(18000);
        	product.setStock(44);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera gris básica premium Kingdom vintage");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera marca Kingdom, modelo Alaska, de algodón y poliéster, manga corta y cuello redondo.");
        	product.setFotoPrecargada("7.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(13400);
        	product.setStock(34);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera gris claro básica premium Kingdom vintage");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera marca Kingdom, modelo Alaska, de algodón y poliéster, manga corta y cuello redondo.");
        	product.setFotoPrecargada("8.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(13400);
        	product.setStock(12);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera negra básica premium Kingdom vintage");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera marca Kingdom, modelo Alaska, de algodón y poliéster, manga corta y cuello redondo.");
        	product.setFotoPrecargada("9.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(13400);
        	product.setStock(3);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera color agua básica premium Kingdom vintage");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera marca Kingdom, modelo Alaska, de algodón y poliéster, manga corta y cuello redondo.");
        	product.setFotoPrecargada("10.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(13400);
        	product.setStock(6);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jogging clásico negro de algodon rústico");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Jogging confeccionado en algodón rústico peinado. Los bolsillos delanrteros tienen cierres reforzados muy confiables y duraderos.");
        	product.setFotoPrecargada("11.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(0);
        	product.setPrecio(23500);
        	product.setStock(4);
        	productService.insert(product);
        	
        	purchase = new Purchase();
        	purchase.setFecha(calendario.get(Calendar.DATE)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+calendario.get(Calendar.YEAR));
        	purchase.setCantidad(2);
        	purchase.setPrecioUnidad(23500);
        	product.setId((long)11);
        	purchase.setProduct(product);
        	purchase.setIdUser((long)1);
        	purchase.setActive(1);
        	purchaseService.insert(purchase);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jogging clásico azul de algodon rústico");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Jogging confeccionado en algodón rústico peinado. Los bolsillos delanrteros tienen cierres reforzados muy confiables y duraderos.");
        	product.setFotoPrecargada("12.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(0);
        	product.setPrecio(23500);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jogging clásico gris claro de algodon rústico");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Jogging confeccionado en algodón rústico peinado. Los bolsillos delanrteros tienen cierres reforzados muy confiables y duraderos.");
        	product.setFotoPrecargada("13.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(20300);
        	product.setStock(2);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera azul marino entrenamiento running crossfit");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva Kadur. Corte regular Fit. Confeccionada con poliéster de primera calidad.");
        	product.setFotoPrecargada("14.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(0);
        	product.setPrecio(14800);
        	product.setStock(14);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Remera blanca entrenamiento running crossfit");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Remera deportiva Kadur. Corte regular Fit. Confeccionada con poliéster de primera calidad.");
        	product.setFotoPrecargada("15.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)1);
        	product.setOferta(1);
        	product.setPrecio(14800);
        	product.setStock(3);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón gris Cargo Jogger de gabardina");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Pantalón Cargo Jogger importado marca Irun. Confeccionado en gabardina semielastizada, liviana, de alta calidad. Dos bolsillos delanteros. Puños con elástico. Cordón de ajuste en la cintura.");
        	product.setFotoPrecargada("16.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(48600);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón gris Cargo Jogger de gabardina");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Pantalón Cargo Jogger importado marca Irun. Confeccionado en gabardina semielastizada, liviana, de alta calidad. Dos bolsillos delanteros. Puños con elástico. Cordón de ajuste en la cintura.");
        	product.setFotoPrecargada("17.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(48600);
        	product.setStock(34);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón gris Cargo Jogger de gabardina");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Pantalón Cargo Jogger importado marca Irun. Confeccionado en gabardina semielastizada, liviana, de alta calidad. Dos bolsillos delanteros. Puños con elástico. Cordón de ajuste en la cintura.");
        	product.setFotoPrecargada("18.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(48600);
        	product.setStock(1);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón gris Cargo Jogger de gabardina");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Pantalón Cargo Jogger importado marca Irun. Confeccionado en gabardina semielastizada, liviana, de alta calidad. Dos bolsillos delanteros. Puños con elástico. Cordón de ajuste en la cintura.");
        	product.setFotoPrecargada("19.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(48600);
        	product.setStock(11);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jean azul marca Izzulino");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Jean marca Izzulin. Calidad premium. Corte clásico. Dos bolsillos delanteros, dos traseros y un bolsillo monedero.");
        	product.setFotoPrecargada("20.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(0);
        	product.setPrecio(42700);
        	product.setStock(8);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jogging babucha negro con puño de algodón");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Jogging babucha de algodón. Los bolsillos tienen cierres reforzados muy confiables y duraderos.");
        	product.setFotoPrecargada("21.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(0);
        	product.setPrecio(26100);
        	product.setStock(23);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Pantalón de jogging babucha azul con puño de algodón");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Jogging babucha de algodón. Los bolsillos tienen cierres reforzados muy confiables y duraderos.");
        	product.setFotoPrecargada("22.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)2);
        	product.setOferta(1);
        	product.setPrecio(20000);
        	product.setStock(14);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo gris Canguro Hoodie con capucha de algodón");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo deportivo con capucha, bolsillo, puño y cintura en rib elastizado. Tiene bolsillo canguro y cordones en la capucha, ajustables.");
        	product.setFotoPrecargada("23.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(0);
        	product.setPrecio(16400);
        	product.setStock(14);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo azul marino Canguro Hoodie con capucha de algodón");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo deportivo con capucha, bolsillo, puño y cintura en rib elastizado. Tiene bolsillo canguro y cordones en la capucha, ajustables.");
        	product.setFotoPrecargada("24.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(0);
        	product.setPrecio(16400);
        	product.setStock(29);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo negro Canguro Hoodie con capucha de algodón");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo deportivo con capucha, bolsillo, puño y cintura en rib elastizado. Tiene bolsillo canguro y cordones en la capucha, ajustables.");
        	product.setFotoPrecargada("25.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(1);
        	product.setPrecio(12400);
        	product.setStock(6);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo negro Canguro Hang Loose");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo Canguro Hang Loose. De frisa, 65% algodón y 35% poliéster. Estampa en frente y en capucha.");
        	product.setFotoPrecargada("26.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(1);
        	product.setPrecio(44500);
        	product.setStock(5);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo morado Canguro Hang Loose");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo Canguro Hang Loose. De frisa, 65% algodón y 35% poliéster. Estampa en frente y en capucha.");
        	product.setFotoPrecargada("27.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(1);
        	product.setPrecio(44500);
        	product.setStock(9);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo verde oliva Canguro Hang Loose");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo Canguro Hang Loose. De frisa, 65% algodón y 35% poliéster. Estampa en frente y en capucha.");
        	product.setFotoPrecargada("28.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(1);
        	product.setPrecio(35500);
        	product.setStock(14);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo gris Wilson Sweat Canguro Long");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo Wilson Sweat training long. Con bolsillo canguro y capucha. Con cordón regulable. Original.");
        	product.setFotoPrecargada("29.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(1);
        	product.setPrecio(25900);
        	product.setStock(35);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Buzo negro Wilson Sweat Canguro Long");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Buzo Wilson Sweat training long. Con bolsillo canguro y capucha. Con cordón regulable. Original.");
        	product.setFotoPrecargada("30.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)3);
        	product.setOferta(1);
        	product.setPrecio(25900);
        	product.setStock(12);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Par de medias negras invisibles de algodón Didar");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias 100% de algodón. Talle único, adaptable.");
        	product.setFotoPrecargada("31.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(0);
        	product.setPrecio(1300);
        	product.setStock(32);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Par de medias grises invisibles de algodón Didar");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias 100% de algodón. Talle único, adaptable.");
        	product.setFotoPrecargada("32.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(1000);
        	product.setStock(54);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Par de medias blancas invisibles de algodón Didar");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias 100% de algodón. Talle único, adaptable.");
        	product.setFotoPrecargada("33.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(1000);
        	product.setStock(38);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Medias blancas caña media Wilson");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias con plantilla acolchada con protección de talón. De algodón.");
        	product.setFotoPrecargada("34.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(3100);
        	product.setStock(17);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Medias negras caña media Wilson");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias con plantilla acolchada con protección de talón. De algodón.");
        	product.setFotoPrecargada("35.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(3100);
        	product.setStock(21);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Medias azul marino Sox Outdoor térmicas");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias con puño doble elastizado, pie con toalla. Remallado plano. Talón y puntera reforzados.");
        	product.setFotoPrecargada("36.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(2400);
        	product.setStock(8);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Medias beige marino Sox Outdoor térmicas");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias con puño doble elastizado, pie con toalla. Remallado plano. Talón y puntera reforzados.");
        	product.setFotoPrecargada("37.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(2400);
        	product.setStock(41);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Medias negras Sox Outdoor térmicas");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias con puño doble elastizado, pie con toalla. Remallado plano. Talón y puntera reforzados.");
        	product.setFotoPrecargada("38.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(2400);
        	product.setStock(23);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Medias verdes Sox Outdoor térmicas");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Medias con puño doble elastizado, pie con toalla. Remallado plano. Talón y puntera reforzados.");
        	product.setFotoPrecargada("39.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)5);
        	product.setOferta(1);
        	product.setPrecio(2400);
        	product.setStock(2);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera negra de abrigo con capucha desmontable ultralight");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Campera finita de costura soft. Dos bolsillos con cierre. Dos bolsillos internos. Capucha desmontable. Con relleno vellón siliconado.");
        	product.setFotoPrecargada("40.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(45000);
        	product.setStock(3);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera ocre saco lapón de poliester");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Muy abrigada y contruida con los materiales más resistentes. Cuenta con capucha desmontable y múltiples bolsillos.");
        	product.setFotoPrecargada("41.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(0);
        	product.setPrecio(300000);
        	product.setStock(23);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera azul saco lapón de poliester");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Muy abrigada y contruida con los materiales más resistentes. Cuenta con capucha desmontable y múltiples bolsillos.");
        	product.setFotoPrecargada("42.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(0);
        	product.setPrecio(300000);
        	product.setStock(35);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera verde oscuro saco lapón de poliester");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Muy abrigada y contruida con los materiales más resistentes. Cuenta con capucha desmontable y múltiples bolsillos.");
        	product.setFotoPrecargada("43.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(250000);
        	product.setStock(4);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera gris con capucha Gdo Lines");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Campera confeccionada con algodón de primera calidad. Excelentes terminaciones. Ideales para media estación. Con bolsillos y capucha.");
        	product.setFotoPrecargada("44.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(114000);
        	product.setStock(18);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera azul marino con capucha Gdo Lines");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Campera confeccionada con algodón de primera calidad. Excelentes terminaciones. Ideales para media estación. Con bolsillos y capucha.");
        	product.setFotoPrecargada("45.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(114000);
        	product.setStock(41);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera negra con capucha Gdo Lines");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Campera confeccionada con algodón de primera calidad. Excelentes terminaciones. Ideales para media estación. Con bolsillos y capucha.");
        	product.setFotoPrecargada("46.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(114000);
        	product.setStock(65);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera negra Softshell Cascade Ridge Columbia");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Campera de running con bolsillos en los laterales para mantener la temperatura de las manos, y para los artículos personales tiene un bolsillo de seguridad. Además, para facilitar la ajustabilidad tiene un dobladillo con cordón.");
        	product.setFotoPrecargada("47.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(0);
        	product.setPrecio(216000);
        	product.setStock(16);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera azul Softshell Cascade Ridge Columbia");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Campera de running con bolsillos en los laterales para mantener la temperatura de las manos, y para los artículos personales tiene un bolsillo de seguridad. Además, para facilitar la ajustabilidad tiene un dobladillo con cordón.");
        	product.setFotoPrecargada("48.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(185000);
        	product.setStock(34);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera verde botella inflable super abrigada");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Excelente calce, calidad y confección. Ultra liviana y compacta. Super abrigada. Capucha no desmontable. Tres bolsillos frontales con cierre.");
        	product.setFotoPrecargada("49.jpg");
        	product.setDestacado(0);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(58000);
        	product.setStock(29);
        	productService.insert(product);
        	
        	product = new Product();
        	product.setTitulo("Campera azul inflable super abrigada");
        	product.setTituloNormalizado(normalize(product.getTitulo()));
        	product.setDescripcion("Excelente calce, calidad y confección. Ultra liviana y compacta. Super abrigada. Capucha no desmontable. Tres bolsillos frontales con cierre.");
        	product.setFotoPrecargada("50.jpg");
        	product.setDestacado(1);
        	product.setActive(1);
        	product.setIdCategoria((long)4);
        	product.setOferta(1);
        	product.setPrecio(58000);
        	product.setStock(3);
        	productService.insert(product);
        	
    	}
		
	}
	
	public static String normalize(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
	
}
