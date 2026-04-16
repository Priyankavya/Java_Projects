package com.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.pojo.user;
import com.lms.service.userService;
import com.lms.serviceimpl.userServiceImpl;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AuthenticationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if("checkLogin".equalsIgnoreCase(action))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			userService uservice=new userServiceImpl();
			user u=uservice.checkLogin(username, password);
			
			if(u!=null)
			{
				System.out.println("no user");
				
			}
			else
			{
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/login.jsp");
				dispatcher.forward(request, response);
			}
		}
		else
		{
			System.out.println("No Action Found");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
