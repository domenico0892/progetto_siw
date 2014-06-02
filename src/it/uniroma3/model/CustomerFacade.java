package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless (name="customerFacade")
public class CustomerFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Customer getCustomerByUsername(String username) {
		Query q = em.createQuery("SELECT c FROM Customer c WHERE c.username = :username");
		q.setParameter("username", username);
		Customer c = (Customer) q.getSingleResult();
		return c;
	}	
	
	public Customer getCustomerById(Long id) {
		return em.find(Customer.class, id);
	}

	public void updateCustomer(Customer customer) {
		em.merge(customer);
	}
	
	public void refreshCustomer(Long id) {
		Customer c = this.getCustomerById(id);
		em.refresh(c);
	}
}
