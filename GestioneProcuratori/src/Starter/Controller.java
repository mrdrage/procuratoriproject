package Starter;

import GUI.*;



import java.util.List;

import ClassiDAOImpl.ProcuratoriDAOPostgreImpl;
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
	M_Benvenuto Benvenuto = null;
	M_NuovoProcuratore NuovoProcuratore = null;
	ProcuratoriDAOPostgreImpl ProcuratoriDAOpostgreImpl= null;
	M_ErroreDatabase ErroreDatabase = null;
	M_DataProcuratoreErrata DataProcuratoreErrata = null;
	M_ProcuratoreInseritoOk ProcuratoreInseritoOk = null;
	M_CercaProcuratore CercaProcuratore = null;  
	
	
	public void TornaAllaHome() {
		Benvenuto.setVisible(true);
	}
	
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
 	
// aggiungere il try prima del catch per DataProcuratoreErrata
		}
		catch (Exception e) {
			DataProcuratoreErrata.setVisible(true);
		} 
		
		try {
				ProcuratoriDAOpostgreImpl.InserisciProcuratoreDB(procuratore);
				
		}catch (SQLException e) {
			 
			    
		} catch (ParseException e) {
			   ErroreDatabase.setVisible(true);
			   e.printStackTrace();
		}
		
		NuovoProcuratore.setVisible(false);
		ProcuratoreInseritoOk.setVisible(true);		
		
	
		
		
		
		
	}
	
	public void InserisciProcuratore () {
		Benvenuto.setVisible(false);
		NuovoProcuratore.setVisible(true);
		
	}
	
	public void AnnullaInserimentoProcuratore() {
		NuovoProcuratore.setVisible(false);
		Benvenuto.setVisible(true);
	}
	
	public void IniziaRicerca () {
		
		Benvenuto.setVisible (false);
		//interrogazione a ProcuratoriDAOPostgreImpl che restituisce una List procuratri
		CercaProcuratore.setVisible(true);
		
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
	
     public Controller (){
    	    DataProcuratoreErrata = new M_DataProcuratoreErrata(this);
			CercaProcuratore = new M_CercaProcuratore(this);
			Benvenuto = new M_Benvenuto(this);
			NuovoProcuratore = new M_NuovoProcuratore(this);
			ErroreDatabase = new M_ErroreDatabase(this);
			ProcuratoreInseritoOk = new M_ProcuratoreInseritoOk(this);
			
			
			try {
				DBConnection dbconnection = null;
				dbconnection = DBConnection.getInstance();
				Connection connection = dbconnection.getConnection();	
				ProcuratoriDAOpostgreImpl = new ProcuratoriDAOPostgreImpl(connection);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		 
			Benvenuto.setVisible(true);
		}
	public static void main(String[] args) {

		Controller C = new Controller();
		
		
	}


	
}
