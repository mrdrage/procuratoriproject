package Starter;


import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ClassiDAO.ProcuratoriDAO;
import ClassiDAOImpl.ProcuratoriDAOPostgresImpl;
import DBconfig.DBConnection;
import GUI.*;
import entita.Procuratori;




public class Controller {
	
	      public ProcuratoriDAOPostgresImpl ProcuratoriDAOpostgresImpl;
	      M_NuovoProcuratore NuovoProcuratore;
	      M_Benvenuto Benvenuto;
	      M_ProcuratoreInseritoOk ProcuratoreInseritoOK;
	      M_CercaProcuratore CercaProcuratore;
	      
     public Controller () throws SQLException {
    	 
     
    	  //Avvio dell'app
	      Benvenuto = new M_Benvenuto(this);
	      Benvenuto.setVisible(true);
	      
	      
	      NuovoProcuratore = new M_NuovoProcuratore(this);
	      ProcuratoreInseritoOK = new M_ProcuratoreInseritoOk(this);
	      CercaProcuratore = new M_CercaProcuratore(this);
     }
     
     public void IniziaInserimentoProcuratore () {
    	 
    	 Benvenuto.setVisible(false);
    	 NuovoProcuratore.setVisible(true);
    	 
     }
     
     public void InserisciProcuratoreDB (String nome, String cognome, String CF, String Ntel, String Ntel2, String email, String dataN) throws SQLException, ParseException {
    	
    	//Conversione da String a Date della dataN
    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
 		Date parsedate = format.parse(dataN);
    	 
        Procuratori procuratore = new Procuratori(nome, cognome, CF, Ntel, Ntel2, email, parsedate);
    	 
        ProcuratoriDAOpostgresImpl.InserisciProcuratore(procuratore);
        
        //Se tutto va bene
        ProcuratoreInseritoOK.setVisible(true);
        
      
        
     }
     
     public void RicercaProcuratori () throws SQLException {
    	 
    	 Benvenuto.setVisible(false);
    	 List<Procuratori> procuratori = new ArrayList<Procuratori>();
    	 List<String> InfoProcuratori = new ArrayList<String>();
    	 
    	 //prelevo dal DB i procuratori	 
    	 procuratori = ProcuratoriDAOpostgresImpl.getAllProcuratori();
    	 //estrapolo le info dai procuratori 
         Iterator<Procuratori> i = procuratori.iterator();
    	 
    	       while (i.hasNext()) {  
    		        Procuratori p = i.next();
    		        InfoProcuratori.add(p.getInfoProcuratore());
    	       }
    	       
    	 //li imposto sulla combobox
         CercaProcuratore.setProcuratoriComboBox(InfoProcuratori);
    	 //visualizzo la  finestra 
   	     CercaProcuratore.setVisible(true);
    		 
    	
    		 
    	 
    	 
     }
     
     
     public void setProcuratoriDAO(ProcuratoriDAOPostgresImpl PD) {
    	 ProcuratoriDAOpostgresImpl = PD;
     }
     
     public ProcuratoriDAOPostgresImpl getProcuratoriDAO() {
    	 return ProcuratoriDAOpostgresImpl; 	  
     }
     

	public static void main(String[] args) throws SQLException, ParseException 
	{
	//	ProcuratoriDAOPostgresImpl procuratoriDAOpostgresImpl; 

		try {
 			Connection conn= null;
 			DBConnection dbc = DBConnection.getInstance();
 			conn = dbc.getConnection();
 			
 			ProcuratoriDAOPostgresImpl  procuratoriDAOpostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
 		    
 			Controller controller = new Controller();
 			
 			controller.setProcuratoriDAO(procuratoriDAOpostgresImpl);
 			
 			}catch (SQLException e) {
 				e.printStackTrace();
 				System.out.println ("errore�? " + e.getMessage());
 				return;
 			}
    	  
		
 			
		
	   
		
//		
//		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
//		Date parsedate = format.parse("2000-01-01");
//		java.sql.Date sqlDate = new java.sql.Date(parsedate.getTime());
//		
//
//		Procuratori procuratore = new Procuratori("sevio","mast","CF1234569890edfg","9911088189","1234567890","sani@mail.it",parsedate);
//		
//		try {
//			Connection conn= null;
//			DBConnection dbc = DBConnection.getInstance();
//			conn = dbc.getConnection();
//			
////			ProcuratoriDAOPostgresImpl procuaratoriDAOPostgresImpl  = new ProcuratoriDAOPostgresImpl(conn);
//			ProcuratoriDAOPostgresImpl procuratoriDAOPostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
//			
//			procuratoriDAOPostgresImpl.InserisciProcuratore(procuratore);
//			
//			}catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println ("errore�? " + e.getMessage());
//				return;
//			}
		
		
		
	}
}