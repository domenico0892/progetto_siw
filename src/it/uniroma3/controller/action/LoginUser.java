package it.uniroma3.controller.action;

import it.uniroma3.model.UserFacade;

import javax.servlet.http.HttpServletRequest;

public class LoginUser implements Action {

	private UserFacade facade;
	
	public LoginUser () {
		this.facade = new UserFacade();
	}
	
	@Override
	public String perform(HttpServletRequest request) {
				
	}

}
