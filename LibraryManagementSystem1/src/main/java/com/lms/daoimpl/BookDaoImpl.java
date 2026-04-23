package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lms.dao.BookDao;
import com.lms.pojo.Book;
import com.lms.util.Dbutil;

public class BookDaoImpl implements BookDao {

	@Override
	public boolean addBook(Book book) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			String query="insert into books (title,author,category,isbn,publisher,total_copies,available_copies,created_at)"
					+ "values(?,?,?,?,?,?,?,?)";
			
			conn=Dbutil.getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setString(4, book.getIsbn());
			ps.setString(5, book.getPublisher());
			ps.setInt(6, book.getTotalCopies());
			ps.setInt(7, book.getAvailableCopies());
			ps.setDate(8, (Date)book.getCreatedAt());
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
