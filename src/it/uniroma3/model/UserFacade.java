package it.uniroma3.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserFacade {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UserFacade () {
		this.emf = Persistence.createEntityManagerFactory ("products-unit");
		this.em = this.emf.createEntityManager();
	}
	
	public User getUser (String username) {
		Query q = em.createQuery("select * from users u where u.username = ?");
		q.setParameter(1, username);
		User u = (User) q.getSingleResult();
		return u;
	}
}
