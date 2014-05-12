package it.uniroma3.model;



import java.util.ArrayList;
import java.util.List;

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
		Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
		q.setParameter("username", username);
		User u = (User) q.getSingleResult();
		return u;
	}
	
	public List<User> getAllUser () {
		Query q = em.createQuery("SELECT u FROM User u");
		List<User> l = new ArrayList<User>();
		l = q.getResultList();
		return l;
	}
	
}
