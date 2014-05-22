package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="administratorFacade")
public class AdministratorFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Administrator getAdministratorByUsername(String username) {
		Query q = em.createQuery("SELECT a FROM Administrator a WHERE a.username = :username");
		q.setParameter("username", username);
		return (Administrator) q.getSingleResult();
	}
}
