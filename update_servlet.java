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


@WebServlet("/update_servlet")
public class update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public update_servlet() {
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
		String bn=request.getParameter("b_name");
		String be=request.getParameter("b_email");
		String bc=request.getParameter("b_cont_no");
		String ba=request.getParameter("b_address");
		String bw=request.getParameter("b_where_to");
		int bh=Integer.parseInt(request.getParameter("b_how_many"));
		String bar=request.getParameter("b_arrival");
		String bl=request.getParameter("b_leaving");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mmm-dd");
		java.util.Date date1=sdf.parse(bar);
		java.util.Date date2=sdf.parse(bl);
		
		long l=date1.getTime();
		long m=date2.getTime();
		
		java.sql.Date bar_new=new java.sql.Date(l);
		java.sql.Date bl_new=new java.sql.Date(m);

		b1.setB_id(bid);
		b1.setB_name(bn);
		b1.setB_email(be);
		b1.setB_cont_no(bc);
		b1.setB_address(ba);
		b1.setB_where_to(bw);
		b1.setB_how_many(bh);
		b1.setB_arrival(bar_new);
		b1.setB_leaving(bl_new);
		
		

		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root","");
			PreparedStatement ps=con.prepareStatement("update book set b_name=? ,b_email=?, b_cont_no=?, b_address=?, b_where_to=?, b_how_many=?, b_arrival=?, b_leaving=? where b_id=?");
			
			ps.setString(1, bn);
			ps.setString(2, be);
			ps.setString(3, bc);
			ps.setString(4, ba);
			ps.setString(5, bw);
			ps.setInt(6, bh);
			ps.setDate(7, bar_new);
			ps.setDate(8, bl_new);
			ps.setInt(9, bid);
			
			
			int j=ps.executeUpdate();
			
			
			if(j>0)
			{
				pw.print(" Updated Successfully");
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
