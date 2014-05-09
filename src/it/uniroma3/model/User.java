package it.uniroma3.model;

import javax.persistence.OneToOne;

public class User {
	
	private Long id;
	
	private String username;
	
	private String password;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Administrator administrator;
	
	public User () {}
	
	public User (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Long getId() {
		return id;
	}

	public boolean checkPassword (String password) {
		return this.password.equals(password);
	}
}
