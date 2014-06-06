import java.util.List;

import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeController {
	
	@EJB (beanName="pFacade")
	private ProductFacade productFacade;
	private List<Product> products;
	
	@PostConstruct
	public void init() {
	  this.products = this.productFacade.listProducts();
	}
	
	public String home() {
		this.products = this.productFacade.listProducts();
		return "index";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
