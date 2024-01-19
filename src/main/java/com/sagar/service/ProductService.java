package com.sagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.component.Product;
import com.sagar.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(int productId, String productName, double productPrice) {
		
		productRepository.save(productId, productName, productPrice);
		
	}
	
	public List<Product> findAll(){
		
		List<Product> productList = productRepository.findAll();

		return productList;
	}
	
	public Product getProductById(int productId) {
		
		Product product = productRepository.getProductById(productId);
		return product;
		
	}
	
	public void saveUpdatedProduct(int productId, String productName, double productPrice) {
		productRepository.saveUpdatedProduct(productId, productName, productPrice);
	}
	
	public void deleteProductById(int productId) {
		productRepository.deleteProductById(productId);
	}
	
}
