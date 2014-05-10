package it.uniroma3.controller.action;

import it.uniroma3.model.User;
import it.uniroma3.model.UserFacade;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUser implements Action {

	@EJB
	private UserFacade facade;
	
	@Override
	public String perform(HttpServletRequest request) {
		String nextPage = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserFacade facade = new UserFacade ();
		User u = facade.getUser(username);
		if (u == null) {
			request.setAttribute("state", "utente inesistente");
			nextPage = "/index.jsp";
		}
		else {
			if (u.checkPassword(password)) {
				if (u.getCustomer() == null)
					nextPage = "/dashboard.jsp";
				else {
					nextPage = "/index.jsp";
					request.setAttribute("state", "la perform è stata effettuata");
				}
			HttpSession hs = request.getSession();
			hs.setAttribute("user", u);
			}
			else
				nextPage = "/login.jsp";
		}
		return nextPage;
	}
}
