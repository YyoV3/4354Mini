package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyEJB.GreetingRemote;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	@EJB private GreetingRemote hello;
    public Servlet()  {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "123456");
			Statement sta =connection.createStatement();
			
			String sql = "select OTP from buser";
			//PreparedStatement statement = connection.prepareStatement(sql);
		
			//get otp store in DB
			  ResultSet rs =sta.executeQuery(sql);
			  //gotp is otp from DB 
			  int gotp = rs.getInt("OTP");
			  
			  //otp from user input
				int otp = Integer.parseInt(request.getParameter("otp"));
				
				//check if otps are similar
				boolean entered = hello.checkotp(otp, gotp);
				
				if(entered) {
					request.getRequestDispatcher("/true.jsp").forward(request, response);
				}
				else
					request.getRequestDispatcher("/false.jsp").forward(request, response);
			  
		} catch(Exception e) {
			 e.printStackTrace();
		}
	
		
		
		
		
	
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
