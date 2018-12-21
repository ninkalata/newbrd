package com.demo.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveRecord
 */
@WebServlet("/RemoveRecord")
public class RemoveRecord extends HttpServlet {
	static  Connection connection=null;
	static {
		try {
			// Load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Get a connection
			 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			 }
		catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}
	
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		String CustomerCode = request.getParameter("CustomerCode");
		
	try {
		PreparedStatement ps = connection.prepareStatement("delete from ninmasercustomer where CustomerCode=?");
		ps.setString(1,CustomerCode );
		 int i = ps.executeUpdate();

	        if(i > 0) {
	            out.println("User successfully removed...");
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}
		 
