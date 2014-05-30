package it.uniroma3.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table (name = "order_line")
public class OrderLine {

    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
   
    @Column
    private String item;
    
    @Column
    private Integer quantity;
    
    @Column
    private Float price;
    
    @OneToOne
    @JoinColumn (name="product_id")
    private Product product;
    
    public OrderLine () {}
    
    public OrderLine (String item, Integer quantity, Float price, Product product) {
    	this.item = item;
    	this.quantity = quantity;
    	this.price = price;
    	this.product = product;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
