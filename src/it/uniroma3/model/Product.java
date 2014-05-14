package it.uniroma3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table (name = "products")
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private Float price;
	
	@Column(length = 2000)
	private String description;
	
	@Column(nullable = false)
	private String code;
	
	/*@ManyToMany (mappedBy="products")
	private List<Provider> providers;*/
	
	public Product() {
	}

	public Product (String name, Float price, String description, String code) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
	}     

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.getId().equals(product.getId());
	}

	public int hashCode() {
		return this.code.hashCode();
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public void setDescription (String desc) {
		this.description = desc;
	}
	
	public String getDescrizione() {
		return this.description;
	}
	
	public String getCodice() {
		return this.code;
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Product"); 
		sb.append("{id=").append(id); 
		sb.append(", name='").append(name); 
		sb.append(", price=").append(price);
		sb.append(", description='").append(description); 
		sb.append(", code='").append(code); 
		sb.append("}\n'");
		return sb.toString();
	}
}
