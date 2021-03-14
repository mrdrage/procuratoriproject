package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiDAO.ProcuratoriDAO;
import Starter.Controller;
import entita.Procuratori;

public class ProcuratoriDAOPostgresImpl implements ProcuratoriDAO {
	
	
	private Connection connection;
	private PreparedStatement inserisciProcuratorePS;
	private PreparedStatement getAllProcuratori;
	private PreparedStatement getAllCFProcuratori;
	private PreparedStatement getCodProcuratore;
	
	public ProcuratoriDAOPostgresImpl(Connection connection) throws SQLException{
		this.connection = connection;
		
		getCodProcuratore = connection.prepareStatement("SELECT MAX(codProcuratori) FROM Procuratori ");

		inserisciProcuratorePS = connection.prepareStatement("INSERT INTO procuratori VALUES (?,?,?,?,?,?,?,?) ");
		getAllProcuratori = connection.prepareStatement("SELECT * FROM procuratori");
		getAllCFProcuratori = connection.prepareStatement("SELECT codicefiscale FROM procuratori");
	}
	
	
	
	
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException {
<<<<<<< HEAD
		int codP=35;
		inserisciProcuratorePS.setString(1, procuratore.getNome());
		inserisciProcuratorePS.setString(2, procuratore.getCognome());
		inserisciProcuratorePS.setString(3, procuratore.getCodiceFiscale());
		inserisciProcuratorePS.setString(4, procuratore.getNumeroTelefonico());
		inserisciProcuratorePS.setString(5, procuratore.getNumeroTelefonico2());
		inserisciProcuratorePS.setString(6, procuratore.getEmail());
=======
		int codP=9;
		InserisciProcuratore.setString(1, procuratore.getNome());
		InserisciProcuratore.setString(2, procuratore.getCognome());
		InserisciProcuratore.setString(3, procuratore.getCodiceFiscale());
		InserisciProcuratore.setString(4, procuratore.getNumeroTelefonico());
		InserisciProcuratore.setString(5, procuratore.getNumeroTelefonico2());
		InserisciProcuratore.setString(6, procuratore.getEmail());
>>>>>>> branch 'main' of https://github.com/mrdrage/procuratoriproject.git
		//conversione della data di procuratore formato java.util, ad una data java.sql per poter usare "setDate".
		java.sql.Date sqlDate = new java.sql.Date(procuratore.getDataN().getTime());
		inserisciProcuratorePS.setDate(7,sqlDate);
		
		//Prendo il valore massimo del codiceProcuratori che è anche l'ultomo poichè è gestito da una sequence sul DB
//		ResultSet CodiceProcuratore = getCodProcuratore.executeQuery();
//		
//		while (CodiceProcuratore.next()) {
//		      codP = CodiceProcuratore.getInt(8);
//		}
//		codP++;
        inserisciProcuratorePS.setInt(8, codP);
		
	    inserisciProcuratorePS.executeUpdate();
		
	}
	
    public List<Procuratori> getAllProcuratori() throws SQLException{
	 
	   ResultSet rs  = getAllProcuratori.executeQuery();
	   List<Procuratori> lista = new ArrayList<Procuratori>();
	   while(rs.next())
	   {
		   Procuratori p = new Procuratori(rs.getString("nome"), rs.getString("cognome"), rs.getString("codicefiscale"), rs.getString("numerotelefonico"), rs.getString("numerotelefonico2"), rs.getString("email"), rs.getDate("datan"));
		   lista.add(p);
	   }
	   rs.close();
	   return lista;
   }
	


   public List<String> getAllCFProcuratori() throws SQLException{

	
	   ResultSet rs = getAllCFProcuratori.executeQuery();
	   List<String> lista = new ArrayList<String>();
	 
	   while(rs.next()) {
	  	   String f = rs.getString(1);
		   lista.add(f);
	   }
	 
	   rs.close();
	   return lista;
   }  
	
}
