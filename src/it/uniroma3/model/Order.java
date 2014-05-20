package it.uniroma3.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
	    private String state;
	    
	    @ManyToOne
	    private Customer customer;
	    
	    @OneToMany
	    @JoinColumn (name = "order_id")
	    private List<OrderLine> orderLines;
	    
	    public Order () {}
	    
	    public Order (Date creationDate) {
	    	this.creationDate = creationDate;
	    	this.state = "open";
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

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
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
	    
	    
	    
	    
}
