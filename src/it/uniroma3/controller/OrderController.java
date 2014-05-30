package it.uniroma3.controller;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLineFacade;
import it.uniroma3.model.ProductFacade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

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
	
	@ManagedProperty(value="#{param.productid}")
	private Long productId;

	private Date creationDate;
	private Date closeDate;
	private Date evasionDate;
	private String status;
	
	@ManagedProperty (value="#{sessionScope['customerController'].customer}")
	private Customer customer;
	
	private List<Order> orders;
	
	@ManagedProperty(value="#{sessionScope['customerController'].currentOrder}")
	private Order order;
	
	private Integer orderedQuantity;

	public String addOrderLine () {
		if (this.order == null)
			return "myOrders.jsp";
		else {
			this.orderLineFacade.createOrderLine(this.order, this.orderedQuantity, this.productFacade.getProductById(this.productId));
			return "orderDetails";
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
			this.orders = (List<Order>) this.orderFacade.getCloseOrders();
		} catch(Exception e) { return "dashboard"; }
		return "allOrders";
	}
	
	public String evadeOrder() {
		this.order = this.orderFacade.getOrderById(this.productId);
		
		return "allOrders";
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

	public Integer getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(Integer orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
}
