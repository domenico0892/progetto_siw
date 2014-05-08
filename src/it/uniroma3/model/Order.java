package it.uniroma3.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	    private Date creationTime;
	    
	    @ManyToOne
	    private Customer customer;
	    
	    @OneToMany (mappedBy = "order")
	    //@JoinColumn (name = "order_id")
	    private List<OrderLine> orderLines;
	    
	    public Order () {}
	    
	    public Order (Date creationTime) {
	    	this.creationTime = creationTime;
	    }
	    
	    
}
