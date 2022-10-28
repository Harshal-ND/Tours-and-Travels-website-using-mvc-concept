package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login_servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String e=request.getParameter("r_email");
		String p=request.getParameter("r_password");
	
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root","");
			PreparedStatement ps=con.prepareStatement("select r_email,r_password from register where r_email=? and r_password=? ");
		ps.setString(1, e);
		ps.setString(2, p);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			
			
			if(e.equals(rs.getString(1)) && p.equals(rs.getString(2)))
			{
				response.sendRedirect("package.html");
			}
			else
			{
				pw.print("Invalid email and password");
			}
		}
		else
		{
			pw.print("Invalid email and password");
		}
			
			
		
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}

		
	}

}
