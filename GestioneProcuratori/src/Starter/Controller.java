package Starter;

import GUI.*;


import java.util.List;
import entita.*;
import java.sql.SQLException;


import java.sql.Connection;
import java.rmi.AccessException;
import java.sql.*;

import DBconfig.DBConnection;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Controller {
	Date d = null;
	M_CercaProcuratore CercaProcuratore = null;  
	M_Benvenuto Benvenuto = null;
	M_NuovoProcuratore NuovoProcuratore = null;
		
	
	public void NuovoProcuratore(String Nome,String Cognome,String CodiceFiscale,String NumeroTelefono,String NumeroTelefono2,String Email,
			String DataNGiorno, String DataNMese, String DataNAnno) {
		try {
		Procuratori procuratore = new Procuratori();
		procuratore.setNome(Nome);
		procuratore.setCognome(Cognome);
		procuratore.setCodiceFiscale(CodiceFiscale);
		procuratore.setNumeroTelefonico(NumeroTelefono);
		procuratore.setNumeroTelefonico2(NumeroTelefono2);
		procuratore.setEmail(Email);
		
		String DataNascita = DataNGiorno + DataNMese + DataNAnno;
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
		Date date1=formatter1.parse(DataNascita);  
		procuratore.setDataN(date1);
		}
		catch (Exception e) {
			
		}
		
		
		
		
		
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
			CercaProcuratore = new M_CercaProcuratore(this);
			Benvenuto = new M_Benvenuto(this);
			NuovoProcuratore = new M_NuovoProcuratore(this);
			
			Benvenuto.setVisible(true);
		}
	public static void main(String[] args) {

		Controller C = new Controller();
		
		
	}


	
}
