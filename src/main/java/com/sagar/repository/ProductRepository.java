package com.sagar.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.sagar.component.Product;

@Repository
public class ProductRepository {

	@Autowired
	private Product product;

	public static Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	public void save(int productId, String productName, double productPrice) {
		Session session = ProductRepository.getSession();
		Transaction transaction = session.beginTransaction();

		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);

		session.save(product);

		System.out.println("-----------------Data Inserted Sucessfully-----------------");

		transaction.commit();
		session.close();
	}

	public List<Product> findAll() {
		Session session = ProductRepository.getSession();
		Transaction transaction = session.beginTransaction();

		Query<Product> query = session.createQuery("FROM Product");
		List<Product> products = query.list();

		transaction.commit();
		session.close();

		return products;
	}

	public Product getProductById(int productId) {

		Session session = ProductRepository.getSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, productId);

		transaction.commit();

		return product;
	}

	public void saveUpdatedProduct(int productId, String productName, double productPrice) {
		Session session = ProductRepository.getSession();
		Transaction transaction = session.beginTransaction();

		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);

		session.update(product);

		transaction.commit();
		session.close();

	}
	
	public void deleteProductById(int productId) {
		Session session = ProductRepository.getSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, productId);
		
		session.delete(product);
		
		transaction.commit();
		session.close();
	}

}
