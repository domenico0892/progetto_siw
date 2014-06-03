package it.uniroma3.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "orders")
public class Order {
		
	    @Id 
	    @GeneratedValue (strategy = GenerationType.AUTO)
	    private Long id;	
	   
	    @Column (nullable = false)
	    @Temporal (TemporalType.DATE)
	    private Date creationDate;
	    
	    @Column
	    @Temporal (TemporalType.DATE)
	    private Date closeDate;
	    
	    @Column
	    @Temporal (TemporalType.DATE)
	    private Date evasionDate;
	    
	    @Column
	    private String status;
	    
	    @ManyToOne
	    private Customer customer;
	    
	    @OneToMany (fetch = FetchType.EAGER)
	    @JoinColumn (name = "order_id")
	    private List<OrderLine> orderLines;
	    
	    public Order () {}
	    
	    public Order (Date creationDate, Customer customer) {
	    	this.creationDate = creationDate;
	    	this.customer = customer;
	    	this.status = "aperto";
	    	this.orderLines = new ArrayList<OrderLine>();
	    }
	    
		public boolean verificaDisponibilita() {
			for(OrderLine line : this.getOrderLines()) {
				Product p = line.getProduct();
				if(p.getQuantity()<line.getQuantity()) {
					return false;
				}
			}
			return true;
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

		public List<OrderLine> getOrderLines() {
			return orderLines;
		}

		public void setOrderLines(List<OrderLine> orderLines) {
			this.orderLines = orderLines;
		}

		public Long getId() {
			return id;
		}

		public void addOrderLine(OrderLine ol) {
			this.orderLines.add(ol);
		}

		public void closeOrder() {
			this.status = "chiuso";
			this.closeDate = new Date();
		}
		
		public void evadeOrder() {
			this.status = "evaso";
			this.evasionDate = new Date();
		}
}
