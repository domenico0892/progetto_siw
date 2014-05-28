package it.uniroma3.controller;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.OrderLineFacade;
import it.uniroma3.model.ProductFacade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean

public class OrderController {
	
	@EJB(beanName="orderFacade")
	private OrderFacade orderFacade;
	
	@EJB(beanName="customerFacade")
	private CustomerFacade customerFacade;

	@EJB(beanName="orderLineFacade")
	private OrderLineFacade orderLineFacade;

	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	
	private Long id;
	
	@ManagedProperty(value="#{param.productId}")
	private Long productId;

	private Date creationDate;
	private Date closeDate;
	private Date evasionDate;
	private String status;
	private Customer customer;
	private List<Order> orders;
	
	@ManagedProperty(value="#{param.currentOrder}")
	private Order order;

	
	public String addOrderLine () {
		if (this.order == null)
			return "myOrders.jsp";
		else {
			OrderLine ol = this.orderLineFacade.createOrderLine(1, this.productFacade.getProductById(this.productId));
			this.order.addOrderLine(ol);
			return "allProduct.jsp";
		}
	}
	

	public String getCustomerByIdOrder() {
		try {
		    this.order = this.orderFacade.getOrderById(this.id);
			this.customer = this.customerFacade.getCustomerById(this.order.getId());
		} catch(Exception e) { return "dashboard"; }
		return "infoCustomer";
	}
	
	public String listOrders() {
		try {
			
		} catch(Exception e) { return "dashboard"; }
		this.orders = (List<Order>) this.orderFacade.getCloseOrders();
		return "allOrders";
	}
	
	public String evadeOrder() {
		try {
			this.order = this.orderFacade.getOrderById(this.id);
		} catch(Exception e) { return "dashboard"; }
		return "insertEvasionDateOfOrder.jsp";
	}
	
	public List<Order> getOrders() {
		return orders;
	}	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Date getEvasionDate() {
		return evasionDate;
	}
	public void setEvasionDate(Date evasionDate) {
		this.evasionDate = evasionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public Long getProductId () {
		return this.productId;
	}
	
	public void setProductId (Long productId) {
		this.productId = productId;
	}
}
