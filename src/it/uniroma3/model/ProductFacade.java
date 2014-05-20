package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name="pFacade")
public class ProductFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;

	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name, price, description, code);
		em.persist(product);
		return product;
	}

	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}
}
