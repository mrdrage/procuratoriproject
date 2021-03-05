package Starter;

import java.util.List;
import entita.*;
import java.sql.SQLException;


import java.sql.Connection;
import java.rmi.AccessException;
import java.sql.*;

import DBconfig.DBConnection;

public class Controller {
	
		
	
	public void IniziaRicerca () {
		
	}
	
	public void CercaProcuratore (String CodiceFiscaleP) {
		
	}
	
	public List<Atleti> AtletiDelProcuratore (String CodiceFiscaleP) {
		return null;
	}
	
	public double CalcolaGuadagnoMensile (int anno, String mese) {
		return 0;
	}
	
	public double CalcolaGuadagnoAnnuale (int anno) {
		return 0;
	}
	
	public List<String> MesiLAvorativi (String CodiceFiscaleP){
		return null;
	}
	
	public List<Integer> AnniLavorativi (int anno){
		return null;
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
