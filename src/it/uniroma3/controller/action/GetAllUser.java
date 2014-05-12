package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.model.User;
import it.uniroma3.model.UserFacade;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class GetAllUser implements Action {

	@EJB
	private UserFacade facade;
	
	@Override
	public String perform(HttpServletRequest request) {
		UserFacade facade = new UserFacade();
		List<User> l = facade.getAllUser();
		if (l == null)
			return "/login.jsp";
		else {
			request.setAttribute("users", l);
			return "/allUsers.jsp";
		}
	}
}
