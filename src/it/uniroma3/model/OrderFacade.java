package it.uniroma3.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

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
		return em.find (Order.class, id);
	}
	
	public Collection<Order> getCloseOrders() {
		Query q = this.em.createQuery("SELECT o FROM Order o WHERE o.status = :status");
		String status = "chiuso";
		q.setParameter("status", status );
		return q.getResultList();
	}
	
	public void updateOrder (Order o) {
		em.merge(o);
	}
	
	public void updateEvasionDateOfOrder(Long id, String evasionDate) {
		
	}
}
