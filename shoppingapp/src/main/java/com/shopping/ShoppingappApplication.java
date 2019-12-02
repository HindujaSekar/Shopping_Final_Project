package com.shopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
	}
/*
	@Autowired
	private ProductRepository pRepo;
	
	@Autowired
	private StoreRepository sRepo;*/
	
	/*@Autowired
	private UserRepository uRepo;*/
	
	@Override
	public void run(String... args) throws Exception {
		/*Product product1=new Product("phone", 16000, 12);
		Product product2=new Product("watch", 1000, 18);
		Product product3=new Product("laptop", 30000, 23);
		Product product4=new Product("earphones", 500, 45);
		
		Store store1=new Store("abc", "electronic city", "5746467", 4.5, 109);
		Store store2=new Store("pqr", "btm", "34547568679", 4.2, 45);
		Store store3=new Store("xyz", "silkboard", "3453654756", 3.5, 24);
		Store store4=new Store("hijk", "jigani", "4567578568", 4.7, 208);
		
		sRepo.save(store1);
		sRepo.save(store2);
		sRepo.save(store3);
		sRepo.save(store4);
		
		product1.getAvailableStores().add(store1);
		product1.getAvailableStores().add(store3);
		
		product2.getAvailableStores().add(store2);
		product2.getAvailableStores().add(store3);
		
		product3.getAvailableStores().add(store4);
		product3.getAvailableStores().add(store1);
		
		product4.getAvailableStores().add(store4);
		product4.getAvailableStores().add(store2);
		
		store1.getProducts().add(product1);
		store1.getProducts().add(product3);
		
		store2.getProducts().add(product2);
		store2.getProducts().add(product4);
		
		store3.getProducts().add(product2);
		store3.getProducts().add(product1);
		
		store4.getProducts().add(product4);
		store4.getProducts().add(product3);
		
		pRepo.save(product1);
		pRepo.save(product2);
		pRepo.save(product3);
		pRepo.save(product4);
		
		sRepo.save(store1);
		sRepo.save(store2);
		sRepo.save(store3);
		sRepo.save(store4);*/
		
	/*List<Product> products=pRepo.findByNameLike("phone");
	List<Store> availableStores = products.get(0).getAvailableStores();
	for (Store store : availableStores) {
		System.out.println(store);
	}*/
	}
}
