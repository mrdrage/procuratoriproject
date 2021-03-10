package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Starter.Controller;
import entita.Procuratori;

public class ProcuratoriDAOPostgresImpl {
	
	
	private Connection connection;
	private PreparedStatement InserisciProcuratore, getAllProcuratori, getAllCFProcuratori;
	
	public ProcuratoriDAOPostgresImpl(Connection connection) throws SQLException
	{
		this.connection = connection;
		
		
		InserisciProcuratore = connection.prepareStatement("INSERT INTO procuratori VALUES (?,?,?,?,?,?,?,?) ");
		getAllProcuratori = connection.prepareStatement("SELECT * FROM procuratori");
		getAllCFProcuratori = connection.prepareStatement("SELECT codicefiscale FROM procuratori");
		
	}
	
	
	
	
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException {
		
		InserisciProcuratore.setString(1, procuratore.getNome());
		InserisciProcuratore.setString(2, procuratore.getCognome());
		InserisciProcuratore.setString(3, procuratore.getCodiceFiscale());
		InserisciProcuratore.setString(4, procuratore.getNumeroTelefonico());
		InserisciProcuratore.setString(5, procuratore.getNumeroTelefonico2());
		InserisciProcuratore.setString(6, procuratore.getEmail());
		//conversione della data di procuratore formato java.util, ad una data java.sql per poter usare "setDate".
		java.sql.Date sqlDate = new java.sql.Date(procuratore.getDataN().getTime());
		InserisciProcuratore.setDate(7,sqlDate);
		InserisciProcuratore.setInt(8, 0012);
		
	    InserisciProcuratore.executeUpdate();
		
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
