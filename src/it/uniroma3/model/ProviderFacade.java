package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name="providerFacade")
public class ProviderFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Provider createProvider (String name, String phoneNumber, String email, String vatin, Address address) {
		Provider p = new Provider (name, phoneNumber, email, vatin, address);
		em.persist(p);
		return p;
	}
	
	/*public List<Provider> getAllProviders () {
		Query q = this.em.createQuery("SELECT p FROM Provider p");
		return (List<Provider>) q.getResultList();
	}*/
	
	public List<Provider> getAllProviders () {
		TypedQuery<Provider> q = this.em.createQuery("SELECT p FROM Provider p", Provider.class);
		return  q.getResultList();
	}
	public Provider getProviderById (Long id) {
		return this.em.find(Provider.class, id);
	}

	public void updateFacade(Provider p) {
		this.em.merge(p);
	}
}
