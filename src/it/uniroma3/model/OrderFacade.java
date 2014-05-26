package it.uniroma3.model;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless (name="orderFacade")
public class OrderFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Order createOrder (Date creationDate, Customer customer) {
		Order order = new Order (creationDate, customer);
		em.persist(order);
		return order;
	}

}
