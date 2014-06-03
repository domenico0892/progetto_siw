package it.uniroma3.controller;

import java.util.Date;

import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean @SessionScoped
public class CustomerController {
	
	@EJB (beanName="customerFacade")
	private CustomerFacade customerFacade;	
	
	private String username;
	private String password;
    private String firstName;
    private String lastName;
	private String email;
	private String phoneNumber;
	private Date dateOfBirth;
	private Date registrationDate;
	private Customer customer;
	
	public String createCustomer() {
		this.customer = this.customerFacade.createCustomer(this.username, this.password, 
				 this.firstName, this.lastName, this.email, this.phoneNumber, 
				 this.dateOfBirth, new Date());
		return "customerProfile";
	}

	public String login () {
		try {
		Customer c = this.customerFacade.getCustomerByUsername(this.username);
			if (c.verificaPassword(this.password)) {
				this.customer = c;
				return "index";
			}
			else 
				return "login";
		}
		catch (Exception e) {
			return "login";
		}
	}
	
	public String logout () {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}
	
	public String customerProfile() {
		return "customerProfile";
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
