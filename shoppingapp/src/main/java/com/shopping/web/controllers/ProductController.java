package com.shopping.web.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.entities.Order;
import com.shopping.model.entities.OrderHistory;
import com.shopping.model.entities.Product;
import com.shopping.model.entities.Store;
import com.shopping.model.entities.User;
import com.shopping.model.service.OrderHistoryService;
import com.shopping.model.service.OrderService;
import com.shopping.model.service.ProductService;
import com.shopping.model.service.StoreService;
import com.shopping.model.service.UserService;
import com.shopping.web.controllers.formbeans.OrderRequest;
import com.shopping.web.controllers.formbeans.RatingRequest;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private StoreService sService;
	
	@Autowired
	private OrderService oService;
	@Autowired
	private OrderHistoryService ohService;
	@Autowired
	private UserService uService;
	
	@GetMapping(path="allproducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<List<Product>>(pService.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping(path="search")
	public Resources<List<Product>> getSearchedProducts(String name){
		List<Product> searchedProducts = pService.getSearchedProducts(name);
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).getAvailableStores());
		Resources<List<Product>> available =new Resources<>(Arrays.asList(searchedProducts));
		available.add(link.withRel("availablestores"));
		return available;
		
		
	}
	@GetMapping(path="availablestores")
	public ResponseEntity<List<Store>> getAvailableStores(){
		List<Product> searchedProducts = pService.getSearchedProducts("phone");
		List<Store> availableStores = searchedProducts.get(0).getAvailableStores();
		return new ResponseEntity<List<Store>>(availableStores, HttpStatus.OK);
		
		
	}
	@GetMapping(path="allstores")
	public ResponseEntity<List<Store>> getAllStores(){
		return new ResponseEntity<List<Store>>(sService.getAllStores(),HttpStatus.OK);
	}
	
	@PostMapping(path="order")
	public ResponseEntity<Order> order(@RequestBody OrderRequest req){
		
		Product product=pService.getProductById(req.getProductId());
		Store store=sService.getStoreById(req.getStoreId());
		return new ResponseEntity<Order>(oService.orderProduct
				(product, req.getAddress(),store,req.getQuantity()),HttpStatus.OK);
	}
	@PutMapping(path="rating")
	public ResponseEntity<Store> giveRating(@RequestBody RatingRequest req){
		return new ResponseEntity<Store>
		(sService.giveRating(req.getRating(), req.getStoreId()),HttpStatus.OK);
		
	}
	@GetMapping(path="allorderhistory")
	public ResponseEntity<List<OrderHistory>> getAllHistory(){
		return new ResponseEntity<List<OrderHistory>>
		(ohService.getAllOrderHistory(),HttpStatus.OK);
	}
	@PostMapping(path="/registeruser",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerProduct(@RequestBody User user){
			return new ResponseEntity<User>(uService.registerUser(user),HttpStatus.OK);
			}
}
