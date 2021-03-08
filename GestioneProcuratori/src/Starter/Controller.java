package Starter;

import GUI.*;

import java.util.List;

import entita.*;

import java.rmi.AccessException;
import java.sql.*;

import DBconfig.DBConnection;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class Controller {
	

	

	public static void main(String[] args) throws SQLException {

//	Controller C = new Controller();
		
		PreparedStatement DatiProcuratore, InserisciP;
		ResultSet rs;
		int RowCount;
		
		try {
			Connection conn= null;
			DBConnection dbc = DBConnection.getInstance();
			conn = dbc.getConnection();
			DatiProcuratore = conn.prepareStatement("SELECT * FROM procuratori");
			InserisciP = conn.prepareStatement("INSERT INTO procuratori VALUES ('stawa','c n sacc','1234567890qweoks','1234567890','facc@','1999-02-01','0007') ");
			rs = DatiProcuratore.executeQuery();
			
			while(rs.next()) {
				System.out.println ("nome : "+ rs.getString("nome"));
				System.out.println ("Cognome : "+ rs.getString(2));
				System.out.println ("codiceFiscale : "+ rs.getString(3));


			}
			
			RowCount = InserisciP.executeUpdate();
			
			
			}catch (SQLException e) {
				
				System.out.println ("errore§?");
			}
		
		
		
	}
}
