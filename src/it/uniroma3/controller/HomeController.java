package it.uniroma3.controller;

import it.uniroma3.controller.action.GetAllProduct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/") 
public class HomeController extends HttpServlet {

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			GetAllProduct gap = new GetAllProduct();
			gap.perform(request);
		    String nextPage = response.encodeURL("/home.jsp");
			ServletContext application = getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
}
