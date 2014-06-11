package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name="pFacade")
public class ProductFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;

	public Product createProduct(String name, String code, Float price, String description, Integer quantity, Boolean vetrina) {
		Product product = new Product(name, price, description, code, quantity, vetrina);
		em.persist(product);
		return product;
	}

	public Product getProductById(Long id) {
		Product product = this.em.find(Product.class, id);
		return product;
	}

	public List<Product> listProducts() {
		TypedQuery<Product> q = this.em.createQuery("SELECT p FROM Product p", Product.class);
		return q.getResultList();
	}
	
	public void updateProduct(Product p) {
		this.em.merge(p);
	}

	public Product getProductByCode(String code) {
		Query q = this.em.createQuery("SELECT p FROM Product p WHERE p.code = :code");
		q.setParameter("code", code);
		return (Product)q.getSingleResult();
	}
}
