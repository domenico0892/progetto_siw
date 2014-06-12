package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name="orderFacade")
public class OrderFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Order createOrder(Date creationDate, Customer customer) {
		Order order = new Order (creationDate, customer);
		customer.addOrder(order);
		em.persist(order);
		em.merge(customer);
		return order;
	}	
	
	public Order getOrderById(Long id) {
		return this.em.find (Order.class, id);
	}
	
	public List<Order> getCloseOrders() {
		TypedQuery<Order> q = this.em.createQuery("SELECT o FROM Order o WHERE o.status = :status", Order.class);
		q.setParameter("status", "chiuso");
		return q.getResultList();
	}

	public void updateOrder (Order o) {
		this.em.merge(o);
	}
}
