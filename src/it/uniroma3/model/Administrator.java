package it.uniroma3.model;

import javax.persistence.OneToOne;

public class Administrator {
	
	@OneToOne
	private User user;

}
