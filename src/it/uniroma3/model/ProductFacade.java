package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class ProductFacade {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProductFacade() {
		this.emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = this.emf.createEntityManager();
	}
	
	public List<Product> getAllProducts() {
		Query allProducts = this.em.createQuery("SELECT p FROM Product p");
		List<Product> l = new ArrayList<Product>();
		l = allProducts.getResultList();
		return l;
	}
}
