package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cancel_servlet")
public class cancel_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public cancel_servlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try
		{
		book_bean b1=new book_bean();
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		

		int bid=Integer.parseInt(request.getParameter("b_id"));
		
		

			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root","");
			PreparedStatement ps=con.prepareStatement("delete from book where b_id=?");
			
		
			ps.setInt(1, bid);
			
			
			int j=ps.executeUpdate();
			
			
			if(j>0)
			{
				pw.print(" BOOKING CANCELLED !!");
				response.sendRedirect("show_book.jsp");
			}
			else
			{
				pw.print("Errror!!!");
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}

	}

}
