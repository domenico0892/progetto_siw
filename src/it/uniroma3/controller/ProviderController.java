package it.uniroma3.controller;

import it.uniroma3.model.Provider;
import it.uniroma3.model.ProviderFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class ProviderController {
	
	@EJB (beanName="providerFacade")
	private ProviderFacade providerFacade;
	
	@ManagedProperty (value="#{param.id}")
	private Long id;
	
	private Provider provider;
	
	public String getProviderDetails () {
		this.provider = this.providerFacade.getProviderById(id);
		return "providerDetails";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
