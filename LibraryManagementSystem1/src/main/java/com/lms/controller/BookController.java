package com.lms.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.pojo.Book;
import com.lms.service.BookService;
import com.lms.serviceimpl.BookServiceImpl;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if("showAddBook".equalsIgnoreCase(action))
		{
			request.setAttribute("errorMessage", "Invalid username or password");
			RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/addBook.jsp");
			dispatcher.forward(request, response);
			
		}
		else if("addbook".equalsIgnoreCase(action))
		{
			String bookTitle=request.getParameter("bookTitle");
			String author=request.getParameter("author");
			String isbn=request.getParameter("isbn");
			String category=request.getParameter("category");
			String publisher=request.getParameter("publisher");
			String availableCopies=request.getParameter("availableCopies");

			String numberofcopies=request.getParameter("numberofcopies");
			
			Book book=new Book();
			book.setTitle(bookTitle);
			book.setAuthor(author);
			book.setCategory(category);
			book.setIsbn(isbn);
			book.setPublisher(publisher);
			book.setTotalCopies(Integer.parseInt(numberofcopies));
			book.setAvailableCopies(Integer.parseInt(availableCopies));
			book.setCreatedAt(new Date());
			
			BookService bks=(BookService) new BookServiceImpl();
			boolean flag=bks.addBook(book);
			if(flag)
			{
				request.setAttribute("successmessage", "book added successsfully !");
			     RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/addBook.jsp");
			     dispatcher.forward(request, response);
			}
			
			else
			{
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/addBook.jsp");
				dispatcher.forward(request, response);
			
			}
			





		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
