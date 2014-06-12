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
	
	public void deleteOrderLine (Long id) {
		this.em.remove(this.getOrderLineByOrderLineId(id));
	}
	
	public void updateOrderLine (OrderLine o) {
		this.em.merge(o);
	}
	

	public OrderLine getOrderLineByOrderLineId(Long id) {
		return this.em.find(OrderLine.class, id);
	}
}
