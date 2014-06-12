package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Administrator;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import it.uniroma3.model.Provider;
import it.uniroma3.model.ProviderFacade;

@ManagedBean
public class ProductController {
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	
	@EJB(beanName="providerFacade")
	private ProviderFacade providerFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private String name;
	private Float price;
	private String description;
	private String code;
	private Integer quantity;
	private Product product;
	private List<Product> products;
	private String message;
	private Boolean vetrina;
	private List<Provider> providers;
	private List<Provider> providersByProduct;
	
	@ManagedProperty(value="#{sessionScope['administratorController'].administrator}")
	private Administrator admin;
	
	@ManagedProperty(value="#{param.providerid}")
	private Long providerId;
	
	public String providerEditor () {
		this.product = this.productFacade.getProductById(this.id);
		this.providers = this.providerFacade.getAllProviders();
		this.providersByProduct = this.product.getProviders();
		return "providerEditor";
	}
	
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String createProduct() {
		try {
			this.product = this.productFacade.createProduct(name, code, price, description, quantity, vetrina);
			return "product";
		} 
		catch(Exception e) { 			
			this.message = "Prodotto già esistente";
			return "newProduct";  
		}
	}
	
	public String updateProduct() {
		Product p = this.productFacade.getProductById(this.id);
		p.setPrice(this.price);
		p.setDescription(this.description);
		p.setQuantity(this.quantity);
		this.productFacade.updateProduct(p);
		this.products = this.productFacade.listProducts();
		return "allProductsAdmin";
	}
	
	public String deleteProduct() {
		this.productFacade.deleteProduct(this.productFacade.getProductById(this.id));
		this.products = this.productFacade.listProducts();
		return "allProductsAdmin";
	}
	
	public String listProducts() {
		this.products = this.productFacade.listProducts();
		if (this.admin==null)
			return "allProducts";
		else return "allProductsAdmin";
			
	}
	
	public String getProductById () {
		this.product = this.productFacade.getProductById(this.id);
		if (this.admin==null)
			return "product";
		else
			return "productAdmin";
	}
	
	public String addProvider () {
		Provider p = this.providerFacade.getProviderById(this.providerId);
		Product pr = this.productFacade.getProductById(this.id);
		pr.addProvider(p);
		p.addProduct(pr);
		this.productFacade.updateProduct(pr);
		this.providerFacade.updateFacade(p);
		
		return this.providerEditor();
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
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getVetrina() {
		return vetrina;
	}

	public void setVetrina(Boolean vetrina) {
		this.vetrina = vetrina;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<Provider> getProvidersByProduct() {
		return providersByProduct;
	}

	public void setProvidersByProduct(List<Provider> providersByProduct) {
		this.providersByProduct = providersByProduct;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
}