package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless (name="orderLineFacade")
public class OrderLineFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public OrderLine createOrderLine (Order o, Integer quantity, Product product) {
		OrderLine ol = new OrderLine (product.getName(), quantity, product.getPrice(), product);
		o.addOrderLine(ol);
		em.persist(ol);
		em.merge(o);
		return ol;
	}
}
