package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name="pFacade")
public class ProductFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;

	public Product createProduct(String name, String code, Float price, String description, Integer quantity) {
		Product product = new Product(name, price, description, code, quantity);
		em.persist(product);
		return product;
	}

	public Product getProductById(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	public List<Product> listProducts() {
		Query q = em.createQuery("SELECT p FROM Product p");
		List<Product> l = (List<Product>) q.getResultList();
		return l;
	}
	
	public void updateProduct(Product p) {
		this.em.merge(p);
	}
}
