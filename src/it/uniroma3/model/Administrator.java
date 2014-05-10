package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Administrator {
	
	@OneToOne (mappedBy="administrator")
	private User user;

}
