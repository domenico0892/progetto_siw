package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	public List<OrderLine> getOrderLinesByOrderId(Long id) {
		Query q = this.em.createQuery("SELECT o FROM OrderLine o WHERE o.order_id= :orderId");
		return (List<OrderLine>) q.getResultList();
	}
}
