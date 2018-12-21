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
	@WebServlet("/Upadate")
	public class Update extends HttpServlet {

			static  Connection connection=null;
			static{
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

				String customerId = request.getParameter("customerId");
				String CustomerCode = request.getParameter("CustomerCode");
				String CustomerName = request.getParameter("CustomerName");
				String CustomerAddress1 = request.getParameter("CustomerAddress1");
				String CustomerAddress2 = request.getParameter("CustomerAddress2");
				String CustomerPinCode = request.getParameter("CustomerPinCode");
				String Emailaddress = request.getParameter("Emailaddress");
				String ContactNumber = request.getParameter("ContactNumber");
				String PrimaryContactPerson = request.getParameter("PrimaryContactPerson");
				String RecordStatus = request.getParameter("RecordStatus");
				String ActiveInactiveFlag = request.getParameter("ActiveInactiveFlag");
				String CreateDate = request.getParameter("CreateDate");
				String CreatedBy = request.getParameter("CreatedBy");
				String ModifiedDate = request.getParameter("ModifiedDate");
				String ModifiedBy = request.getParameter("ModifiedBy");
				String AuthorizedDate = request.getParameter("AuthorizedDate");
				String AuthorizedBy = request.getParameter("AuthorizedBy");
			
		try {
			PreparedStatement pre = connection.prepareStatement("update from ninmasercustomer SET values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where CustomerCode=?");
		

			pre.setString(1, customerId);
			pre.setString(2, CustomerCode);
			pre.setString(3, CustomerName);
			pre.setString(4, CustomerAddress1);
			pre.setString(5, CustomerAddress2);
			pre.setString(6, CustomerPinCode);
			pre.setString(7, Emailaddress);
			pre.setString(8, ContactNumber);
			pre.setString(9, PrimaryContactPerson);
			pre.setString(10, RecordStatus);
			pre.setString(11, ActiveInactiveFlag);
			pre.setString(12, CreateDate);
			pre.setString(13, CreatedBy);
			pre.setString(14, ModifiedDate);
			pre.setString(15, ModifiedBy);
			pre.setString(16, AuthorizedDate);
			pre.setString(17, AuthorizedBy);
			pre.executeUpdate();
			connection.commit();
			 int i = pre.executeUpdate();

		        if(i > 0) {
		            out.println("User successfully update...");
		        }

		    } catch (Exception e) {
		        System.out.println(e);
		    }
		}
	}


