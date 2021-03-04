package Starter;

import java.sql.SQLException;


import java.sql.Connection;
import java.sql.*;

import DBconfig.DBConnection;

public class Controller {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgres.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println ("non trovata classe");
		}
		
 
		try {
			DBConnection dbconnection = DBConnection.getInstance();
			 
			Connection conn = dbconnection.getConnection(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
