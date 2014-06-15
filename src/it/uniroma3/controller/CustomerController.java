package it.uniroma3.controller;

import java.util.Date;

import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	private Address address;
	private String city;
	private String country;
	private String state;
	private String street;
	private String zipcode;
	private Date dateOfBirth;
	private Date registrationDate;
	private Customer customer;
	private String message;	
	
	public String createCustomer() {
		this.address = new Address(this.street, this.city, this.state, this.zipcode, this.country);
		try {
		this.customer = this.customerFacade.createCustomer(this.username, this.password, 
				 this.firstName, this.lastName, this.email, this.phoneNumber, 
				 this.dateOfBirth, this.address, new Date());
		this.message = "Cliente inserito correttamente";
		return "summaryCustomer";
		} catch (Exception e) {
			this.message = "Username gia' esistente!";
			return "newCustomer.jsp";
		}
	}

	public String login () {
		try {
		Customer c = this.customerFacade.getCustomerByUsername(this.username);
			if (c.verificaPassword(this.password)) {
				this.customer = c;
				return "index";
			}
			else {
				this.message = "Password errata";
				return "login";
		}
		}
		catch (Exception e) {
			this.message = "Username errato";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
