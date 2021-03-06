package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (unique = true)
	private String username;
	
	@Column
	private String password;
	
	@Column(nullable = false)
    private String firstName;
    
	@Column(nullable = false)
    private String lastName;
    
	@Column
	private String email;
	
	@Column
	private String phoneNumber;
    
	@Column
	@Temporal (TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column
	@Temporal (TemporalType.DATE)
	private Date registrationDate;
    
	@OneToOne (cascade=CascadeType.PERSIST)
	@JoinColumn (name = "address_fk")
    private Address address;
	
	@OneToMany (mappedBy="customer", fetch=FetchType.EAGER)
	private List<Order> orders;
	
	public Customer () {}

	public Customer (String username, String password, String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, Address address, Date registrationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.address = address;
		this.username = username;
		this.password = password;
		this.orders = new ArrayList<Order>();
	}

	public Long getId() {
		return id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate (Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public boolean verificaPassword (String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
}