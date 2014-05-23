package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class CustomerController {
	
	@EJB (beanName="customerFacade")
	private CustomerFacade customerFacade;	
	
	private String username;
	private String password;
	private Customer customer;
	
	public String login () {
		try {
		Customer c = this.customerFacade.getCustomerByUsername(this.username);
			if (c.verificaPassword(this.password)) {
				this.customer = c;
				return "home";
			}
			else 
				return "login";
		}
		catch (Exception e) {
			return "login";
		}
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
}
