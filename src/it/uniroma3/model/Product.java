package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@ManyToMany (mappedBy="products", fetch=FetchType.EAGER)
	private List<Provider> providers;
	
	@Column
	private Integer quantity;
	
	private boolean vetrina;
	
	public Product() {
		this.providers = new ArrayList<Provider>();
	}

	public Product (String name, Float price, String description, String code, Integer quantity, Boolean vetrina) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
		this.quantity = quantity;
		this.vetrina = vetrina;
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
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer q) {
		this.quantity = q;
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

	public boolean isVetrina() {
		return vetrina;
	}

	public void setVetrina(boolean vetrina) {
		this.vetrina = vetrina;
	}
	
	public void addProvider (Provider p) {
		this.providers.add(p);
	}
	
	public List<Provider> getProviders () {
		return this.providers;
	}
	
	public boolean verificaPresenzaProvider (Provider p) {
		for (Provider i : this.providers)
			if (i.getId().equals(p.getId()))
				return true;
		return false;
	}
}
