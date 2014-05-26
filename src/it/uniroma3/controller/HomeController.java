package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeController {
	
	@EJB (beanName="pFacade")
	private ProductFacade pf;
	
	private List<Product> products;
	
	public HomeController () {
		this.products = this.pf.listProducts();
		
	}

}
