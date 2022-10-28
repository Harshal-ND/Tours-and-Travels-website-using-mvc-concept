package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register_servlet")
public class register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public register_servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try
		{
		register_bean b1=new register_bean();
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		

		
		String rn=request.getParameter("r_name");
		String re=request.getParameter("r_email");
		String rp=request.getParameter("r_password");
		String rm=request.getParameter("r_mob_no");
		
		b1.setR_name(rn);
		b1.setR_email(re);
		b1.setR_password(rp);
		b1.setR_mob_no(rm);
		
	
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root","");
			PreparedStatement ps=con.prepareStatement("insert into register (r_name,r_email,r_password, r_mob_no) values(?,?,?,?)");
			
			ps.setString(1, rn);
			ps.setString(2, re);
			ps.setString(3, rp);
			ps.setString(4, rm);
			
			
			
			int j=ps.executeUpdate();
			
			
			if(j>0)
			{
				pw.print(" Registeration Done Successfully !!");
				response.sendRedirect("login.html");
				
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
