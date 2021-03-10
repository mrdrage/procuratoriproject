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
import entita.Procuratori;




public class Controller {
	
//	ProcuratoriDAOPostgresImpl procuaratoriDAOPostgresImpl = null;

	public static void main(String[] args) throws SQLException, ParseException {

	//	List<Procuratori> Pr = new ArrayList <Procuratori>();
		
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Date parsedate = format.parse("2000-01-01");
		java.sql.Date sqlDate = new java.sql.Date(parsedate.getTime());
		
//	Controller C = new Controller();
		
//		PreparedStatement DatiProcuratore, InserisciP,inserisciA
//		ResultSet rs;
//		int RowCount=0;
		Procuratori procuratore = new Procuratori("sevio","mast","CF1234567890edfg","9911088189","1234567890","sani@mail.it",parsedate);
		
		try {
			Connection conn= null;
			DBConnection dbc = DBConnection.getInstance();
			conn = dbc.getConnection();
			
//			ProcuratoriDAOPostgresImpl procuaratoriDAOPostgresImpl  = new ProcuratoriDAOPostgresImpl(conn);
			ProcuratoriDAOPostgresImpl procuratoriDAOPostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
			
 
<<<<<<< HEAD
 System.out.println(procuratoriDAOPostgresImpl.getAllCFProcuratori());
 
 for(Procuratori PR:procuratoriDAOPostgresImpl.getAllProcuratori()) {
	 System.out.print(PR.getNome());
	 System.out.print(PR.getCognome());
	 System.out.print(" ");
 }
// System.out.println(procuratoriDAOPostgresImpl.getAllProcuratori());

//			procuaratoriDAOPostgresImpl.InserisciProcuratore(procuratore);
			
=======
            System.out.println(procuratoriDAOPostgresImpl.getAllCFProcuratori());
            
            
            for (Procuratori PR: procuratoriDAOPostgresImpl.getAllProcuratori()) {
            	PR.StampaProcuratore();
            }
>>>>>>> branch 'main' of https://github.com/mrdrage/procuratoriproject.git
	
			
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println ("errore�? " + e.getMessage());
				return;
			}
		
		
		
	}
}
