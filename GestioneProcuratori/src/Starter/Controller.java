package Starter;

import GUI.*;

import java.util.List;

import entita.*;
import java.sql.SQLException;


import java.sql.Connection;
import java.rmi.AccessException;
import java.sql.*;

import DBconfig.DBConnection;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class Controller {
	
	

	
<<<<<<< HEAD
//	public Controller getInstance() throws SQLException
//	{
//		if (controller == null)
//		{
//			controller = new Controller();
//		}
//
//		return controller;
//	}
//	
=======
	public void NuovoProcuratore(String Nome,String Cognome,String CodiceFiscale,String NumeroTelefono,String NumeroTelefono2,String Email,
			String DataN)  {
		
		Procuratori procuratore = new Procuratori();
		
		try {
		
		procuratore.setNome(Nome);
		procuratore.setCognome(Cognome);
		procuratore.setCodiceFiscale(CodiceFiscale);
		procuratore.setNumeroTelefonico(NumeroTelefono);
		procuratore.setNumeroTelefonico2(NumeroTelefono2);
		procuratore.setEmail(Email);
     	procuratore.setDataN(DataN);
 	
		}
		catch (Exception e) {
			DataProcuratoreErrata.setVisible(true);
		} 
		
		try {
				ProcuratoriDAOpostgreImpl.InserisciProcuratoreDB(procuratore);
				
		}catch (SQLException e) {
			 
			    
		}
		
		NuovoProcuratore.setVisible(false);
		ProcuratoreInseritoOk.setVisible(true);		
		
>>>>>>> branch 'main' of https://github.com/mrdrage/procuratoriproject.git
	

	public static void main(String[] args) throws SQLException {

		Controller C = new Controller();
		
		
	}
}


