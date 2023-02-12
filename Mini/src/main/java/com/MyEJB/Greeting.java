package com.MyEJB;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Greeting
 */
@Stateless
@LocalBean
public  class Greeting implements GreetingRemote, GreetingLocal {

    /**
     * Default constructor. 
     */
    public Greeting() {
        
    }
    
    public int generateOTP() {
    	String num = "0123456789";
    	Random rm =new Random();
    	int sum=0;
    	
    	char[]otp = new char [4];
    	for (int i = 0; i<4; i++) {    		
    		otp[i]=num.charAt(rm.nextInt(num.length())  );
    	}
    	
    	
		for(int i=0;i<4;i++) {
			sum = sum*10 + otp[i];
		}
    	
    	return sum;
    	
    	
    }
    
    
	public boolean checkotp(int enter, int random) {
	
		boolean result =false;
		


		
    	if(enter==random) {
    		
    		result =true;
    	}
    	 
    	return result;
	}
	
	public void update(int i) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "123456");
			Statement sta =connection.createStatement();
			
			String sql = "UPDATE user.buser SET otp = i WHERE pno = '012345678';";
			PreparedStatement statement = connection.prepareStatement(sql);
			int rowsUpdated = statement.executeUpdate();
			System.out.println(rowsUpdated);

			  // Check if update was successful
			  ResultSet rs =sta.executeQuery(sql);
		} catch(Exception e) {
			 e.printStackTrace();
		}
	}
    

}
