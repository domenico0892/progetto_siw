package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.OrderLineFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean
public class OrderController {
	
	/* Start EJB */
	@EJB(beanName="orderFacade")
	private OrderFacade orderFacade;
	
	@EJB(beanName="customerFacade")
	private CustomerFacade customerFacade;

	@EJB(beanName="orderLineFacade")
	private OrderLineFacade orderLineFacade;

	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	/* End EJB */
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationDate;
	private Date closeDate;
	private Date evasionDate;
	private String status;
	private List<Order> orders;
	private Integer orderedQuantity;
	private Order order;
	private String message;
	
	@ManagedProperty(value="#{param.productid}")
	private Long productId;

	@ManagedProperty (value="#{sessionScope['customerController'].customer}")
	private Customer customer;

	@ManagedProperty(value="#{sessionScope['currentOrder']}")
	private Order currentOrder;
	
	@ManagedProperty(value="#{param.selectedorder}")
	private Long selectedOrder;
	
	@ManagedProperty(value="#{param.selectedorderline}")
	private Long selectedOrderLine;
	
	
	public String newOrder () {
		Order o = this.orderFacade.createOrder(new Date(), this.customer);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentOrder", o);
		return "index";
	}
	
	public String listOrders () {
		if (this.customer==null)
			return "login";
		else {
			this.orders = this.customer.getOrders();
			return "myOrders";
		}
	}
	
	public String selectOrder () {
		Order o = this.orderFacade.getOrderById(this.selectedOrder);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentOrder", o);
		return "index";
	}

	public String addOrderLine () {
		if (this.currentOrder == null)
			return "index";
		else {
			this.orderLineFacade.createOrderLine(this.currentOrder, this.orderedQuantity, this.productFacade.getProductById(this.productId));
			this.order = this.currentOrder;
			return "orderDetails";
		}
	}
	
	public String closeOrder () {
		for (Order o : this.customer.getOrders())
			if (o.getId().equals(this.selectedOrder)) {
				o.closeOrder();
				this.orderFacade.updateOrder(o);
			}
			if (this.currentOrder!=null)
				if (this.currentOrder.getId().equals(this.selectedOrder))
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentOrder");
			this.orders = this.customer.getOrders();
			return "myOrders";
		}
	
	public String getCustomerByIdOrder() {
		try {
		    this.order = this.orderFacade.getOrderById(this.id);
			this.customer = this.customerFacade.getCustomerById(this.order.getId());
		} catch(Exception e) { return "dashboard"; }
		return "infoCustomer";
	}
	
	public String listCloseOrders() {
		try {
			this.orders = (List<Order>) this.orderFacade.getCloseOrders();
		} catch(Exception e) { return "dashboard"; }
		return "allOrders";
	}
	
	public String evadeOrder() {
		Order o = this.orderFacade.getOrderById(this.id);
		if(this.orderFacade.verificaDisponibilita(o)) {
			o.setCloseDate(new Date());
			o.setStatus("evaso");
			this.orderFacade.updateOrder(o);
			this.aggiornaQuantitaMagazzino(o);
		}
		this.orders = (List<Order>) this.orderFacade.getCloseOrders();
		return "allOrders";
	}
	
	private void aggiornaQuantitaMagazzino(Order o) {
		for(OrderLine line : o.getOrderLines()) {
			Product p = line.getProduct();
			p.setQuantity(p.getQuantity()-line.getQuantity());
			this.productFacade.updateProduct(p);
		}
	}

	public String getOrderDetails () {
		this.order = this.orderFacade.getOrderById(this.selectedOrder);
		if (this.order.getStatus().equals("aperto"))
			return "openOrderDetails";
		else return "orderDetails";
	}
	
	public String deleteOrderLine () {
		this.orderLineFacade.deleteOrderLine(this.selectedOrderLine);
		this.order = this.orderFacade.getOrderById(this.selectedOrder);
		return "openOrderDetails";
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
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

	public Long getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(Long selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getSelectedOrderLine() {
		return selectedOrderLine;
	}

	public void setSelectedOrderLine(Long selectedOrderLine) {
		this.selectedOrderLine = selectedOrderLine;
	}
}
