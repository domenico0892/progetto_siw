package it.uniroma3.model;

import java.util.Date;

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

	public Customer createCustomer(String username, String password,
			String firstName, String lastName, String email,
			String phoneNumber, Date dateOfBirth, Date date) {
		Customer c = new Customer(username, password, firstName, lastName, email, phoneNumber,dateOfBirth, null,date);
		this.em.persist(c);
		return c;
	}
}
