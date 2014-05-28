package it.uniroma3.model;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name="orderFacade")
public class OrderFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Order createOrder(Date creationDate, Customer customer) {
		Order order = new Order (creationDate, customer);
		em.persist(order);
		return order;
	}	
	
	public Order getOrderById(Long id) {
		Query q = this.em.createQuery("SELECT o FROM Order o WHERE o.id = :id");
		q.setParameter("id", id);
		return (Order) q.getSingleResult();
	}
}
