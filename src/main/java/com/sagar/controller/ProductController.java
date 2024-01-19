package com.sagar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sagar.component.Product;
import com.sagar.service.ProductService;

@Controller
public class ProductController{
	
	@Autowired
	private ProductService productService;
	
//	@RequestMapping(value = "/SaveProduct")
//	public void registerProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		
//		int productId = Integer.parseInt(req.getParameter("ProductId"));
//		String productName = req.getParameter("ProductName");
//		double productPrice = Double.parseDouble(req.getParameter("ProductPrice"));
//		
//		Product product = productService.saveProduct(productId, productName, productPrice);
//		
//		req.setAttribute("message", "Sucessfull");
//		req.setAttribute("productId", product.getProductId());
//		req.setAttribute("productName", product.getProductName());
//		req.setAttribute("productPrice", product.getProductPrice());
//		RequestDispatcher dispatcher = req.getRequestDispatcher("output.jsp");
//		dispatcher.forward(req, res);
//	}
	
//	--------------------------------------------- OR ----------------------------------------------
	
//	@RequestMapping(value = "/SaveProduct")
//	public ModelAndView registerProduct(@RequestParam int ProductId, @RequestParam String ProductName, @RequestParam double ProductPrice){
//		
//		Product product = productService.saveProduct(ProductId, ProductName, ProductPrice);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("output.jsp");
//		modelAndView.addObject("message", "Date Inserted Sucessfull...!");
//		modelAndView.addObject("productId", product.getProductId());
//		modelAndView.addObject("productName", product.getProductName());
//		modelAndView.addObject("productPrice", product.getProductPrice());
//		
//		return modelAndView;
//	}
	
//	--------------------------------------------- DISPLAYING ALL RECORDS ---------------------------------------------
	
//	@RequestMapping(value = "/AddProduct")
//	public ModelAndView registerProduct(@RequestParam int ProductId, @RequestParam String ProductName, @RequestParam double ProductPrice) {
//		List<Product> productList = productService.saveProduct(ProductId, ProductName, ProductPrice);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("output.jsp");
//		modelAndView.addObject("Products",productList);
//		
//		return modelAndView;
//	}
	
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam int productId, @RequestParam String productName, @RequestParam double productPrice) {
		productService.saveProduct(productId, productName, productPrice);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.jsp");
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView viewAllProduct() {
		List<Product> products = productService.findAll();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayAllProducts.jsp");
		modelAndView.addObject("productList",products);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateProduct(@RequestParam int productId) {
		Product product = productService.getProductById(productId);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateProduct.jsp");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	public ModelAndView saveUpdatedProduct(@RequestParam int productId, @RequestParam String productName, @RequestParam double productPrice) {
		productService.saveUpdatedProduct(productId, productName, productPrice);
		List<Product> products = productService.findAll();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayAllProducts.jsp");
		modelAndView.addObject("productList",products);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@RequestParam int productId) {
		productService.deleteProductById(productId);
		List<Product> products = productService.findAll();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayAllProducts.jsp");
		modelAndView.addObject("productList",products);
		
		return modelAndView;
	}
	
}
