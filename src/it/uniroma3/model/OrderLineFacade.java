package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless (name="orderLineFacade")
public class OrderLineFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public OrderLine createOrderLine (Integer quantity, Product product) {
		OrderLine ol = new OrderLine (product.getName(), quantity, product.getPrice(), product);
		em.persist(ol);
		return ol;
	}
}
