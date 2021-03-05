package Starter;

import java.sql.SQLException;


import java.sql.Connection;
import java.rmi.AccessException;
import java.sql.*;

import DBconfig.DBConnection;

public class Controller {
	
		
	
	public void IniziaRicerca () {
		
	}
	

	public static void main(String[] args) {

		try{
			DBConnection newdbconnection = DBConnection.getInstance();
			Connection pon = newdbconnection.getConnection();
		}
			catch(SQLException e){
				
			}
		
	}


	
}
