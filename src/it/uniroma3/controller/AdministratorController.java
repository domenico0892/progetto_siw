package it.uniroma3.controller;

import it.uniroma3.model.Administrator;
import it.uniroma3.model.AdministratorFacade;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean 
@SessionScoped
public class AdministratorController {
	
	@EJB(beanName="administratorFacade")
	private AdministratorFacade administratorFacade;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String eMail;
	private Administrator administrator;
	
	public String loginAdmin() {
		try {	
			Administrator a = this.administratorFacade.getAdministratorByUsername(this.username);	
			if(a.verificaPassword(this.password)){
				this.setAdministrator(a);
				return "dashboard";
			} else return "loginDashboard";
		}catch (Exception e) { return "loginDashboard"; }
	}
	
	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}
