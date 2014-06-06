package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="providerFacade")
public class ProviderFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Provider createProvider (String name, String phoneNumber, String email, String vatin, Address address) {
		Provider p = new Provider (name, phoneNumber, email, vatin, address);
		em.persist(p);
		return p;
	}
	
	public List<Provider> getAllProviders () {
		Query q = this.em.createQuery("SELECT p FROM Provider");
		return (List<Provider>) q.getResultList();
	}
	
	public List<Provider> getProvidersByProductId (Long id) {
		Query q = this.em.createQuery("SELECT p FROM provider_products WHERE p.products = :id");
		q.setParameter("id", id);
		return (List<Provider>) q.getResultList();
	}
	
	public Provider getProviderById (Long id) {
		return this.em.find(Provider.class, id);
	}
}
