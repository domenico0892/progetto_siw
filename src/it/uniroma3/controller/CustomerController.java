package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean @SessionScoped
public class CustomerController {
	
	@EJB (beanName="customerFacade")
	private CustomerFacade customerFacade;	
	
	@EJB (beanName="orderFacade")
	private OrderFacade orderFacade;
	
	private String username;
	private String password;
	private Customer customer;
	private Order currentOrder;
	private List<Order> orders;
	
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
	
	public String logout () {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "home.jsp";
	}
	
	public String listOrders () {
		if (this.customer==null)
			return "login.jsp";
		else {
			this.orders = this.customer.getOrders();
			return "myOrders.jsp";
		}
	}
	
	public String customerProfile() {
		return "customerProfile.jsp";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String newOrder () {
		this.currentOrder = this.orderFacade.createOrder (new Date(), this.customer);
		this.customer.addOrder(this.currentOrder);
		return "home.jsp";
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

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
