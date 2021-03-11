package Starter;


import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ClassiDAO.ProcuratoriDAO;
import ClassiDAOImpl.ProcuratoriDAOPostgresImpl;
import DBconfig.DBConnection;
import GUI.*;
import entita.Procuratori;




public class Controller {
	
	      ProcuratoriDAOPostgresImpl ProcuratoriDAOpostgresImpl;
	      M_NuovoProcuratore NuovoProcuratore = null;
	      M_Benvenuto Benvenuto = null;
	      
	      
	      
     public Controller (Connection connection) throws SQLException {
    	 
      //    ProcuratoriDAOPostgresImpl procuratoridao = new ProcuratoriDAOPostgresImpl(connection);
    	  
	      Benvenuto = new M_Benvenuto(this);
	      NuovoProcuratore = new M_NuovoProcuratore(this);
	      Benvenuto.setVisible(true);
     
     }
     
     public void IniziaInserimentoProcuratore () {
    	 Benvenuto.setVisible(false);
    	 NuovoProcuratore.setVisible(true);
    	 
     }
     
     public void InserisciProcuratoreDB (String nome, String cognome, String CF, String Ntel, String Ntel2, String email, String dataN, ProcuratoriDAOPostgresImpl PD) throws SQLException, ParseException {
    	
    	 
    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
 		Date parsedate = format.parse(dataN);
    	 
        Procuratori procuratore = new Procuratori(nome, cognome, CF, Ntel, Ntel2, email, parsedate);
    	 
        PD.InserisciProcuratore(procuratore);
     }
     
     public void setProcuratoriDAO(ProcuratoriDAOPostgresImpl PD) {
    	 ProcuratoriDAOpostgresImpl = PD;
     }
     
     public ProcuratoriDAOPostgresImpl getProcuratoriDAO() {
    	 return ProcuratoriDAOpostgresImpl; 	  
     }
     

	public static void main(String[] args) throws SQLException, ParseException 
	{
		ProcuratoriDAOPostgresImpl ProcuratoriDAOpostgresImpl; 

		try {
 			Connection conn= null;
 			DBConnection dbc = DBConnection.getInstance();
 			conn = dbc.getConnection();
 			
 		    ProcuratoriDAOpostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
 		    
 			Controller controller = new Controller(conn);
 			
 			controller.setProcuratoriDAO(ProcuratoriDAOpostgresImpl);
 			
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