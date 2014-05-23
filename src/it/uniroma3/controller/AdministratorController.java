package it.uniroma3.controller;

import it.uniroma3.model.Administrator;
import it.uniroma3.model.AdministratorFacade;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

@ManagedBean 
@SessionScoped
public class AdministratorController {
	
	@EJB (beanName="administratorFacade")
	private AdministratorFacade administratorFacade;
	
	private String username;
	private String password;
	private Administrator administrator;
	
	public String loginAdmin() {
		try {	
			Administrator a = this.administratorFacade.getAdministratorByUsername(this.username);	
			if(a.verificaPassword(this.password)){
				this.administrator = a;
				return "dashboard";
			} else return "loginDashboard";
		}catch (Exception e) { return "loginDashboard"; }
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Administrator getAdministrator() {
		return administrator;
	}
	
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
}
