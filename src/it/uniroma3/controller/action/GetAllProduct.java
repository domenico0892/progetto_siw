package it.uniroma3.controller.action;

import java.util.List;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import javax.servlet.http.HttpServletRequest;

public class GetAllProduct implements Action{
	
	public String perform(HttpServletRequest request) {
		ProductFacade facade = new ProductFacade();
		List<Product> l = facade.getAllProducts();
		request.setAttribute("products", l);
		return "/allProducts.jsp";
	}
}
