package com.lms.serviceimpl;

import java.util.List;

import com.lms.dao.BookDao;
import com.lms.daoimpl.BookDaoImpl;
import com.lms.pojo.Book;
import com.lms.service.BookService;

public class BookServiceImpl implements BookService {
	
     BookDao bd=new BookDaoImpl();
     
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return bd.addBook(book);
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
