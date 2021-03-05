package Starter;

import GUI.*;
import java.util.List;
import entita.*;
import java.sql.SQLException;


import java.sql.Connection;
import java.rmi.AccessException;
import java.sql.*;

import DBconfig.DBConnection;

public class Controller {
	
	M_CercaProcuratore MCP = null;  
	M_Benvenuto B = null;
	M_NuovoProcuratore NP = null;
		
	
	public void InserisciProcuratore() {
		B.setVisible(false);
		NP.setVisible(true);
	}
	
	public void AnnullaInserimentoProcuratore() {
		NP.setVisible(false);
		B.setVisible(true);
	}
	
	public void IniziaRicerca () {
		
		B.setVisible (false);
		MCP.setVisible(true);
		
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
			MCP = new M_CercaProcuratore(this);
			B = new M_Benvenuto(this);
			NP = new M_NuovoProcuratore(this);
			
			B.setVisible(true);
		}
	public static void main(String[] args) {

		Controller C = new Controller();
		
		
	}


	
}
