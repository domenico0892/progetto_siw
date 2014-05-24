package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

@ManagedBean
public class ProductController {
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private Float price;
	private String description;
	private String code;
	private Integer quantity;
	private Product product;
	private List<Product> products;
	
	public String createProduct() {
		this.product = productFacade.createProduct(name, code, price, description, quantity);
		return "product"; 
	}
	
	public String listProducts() {
		this.products = this.productFacade.listProducts();
		return "allProducts";
	}
	
	public String getProductById () {
		this.product = this.productFacade.getProductById(this.id);
		return "product";
	}
	
	public Long getId () {
		return this.id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}
}