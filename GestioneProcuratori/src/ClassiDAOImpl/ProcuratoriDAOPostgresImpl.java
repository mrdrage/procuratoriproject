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
	private PreparedStatement InserisciProcuratorePS, getAllProcuratori, getAllCFProcuratori;
	
	public ProcuratoriDAOPostgresImpl(Connection connection) throws SQLException
	{
		this.connection = connection;
		
		
		InserisciProcuratorePS = connection.prepareStatement("INSERT INTO procuratori VALUES (?,?,?,?,?,?,?,?) ");
		getAllProcuratori = connection.prepareStatement("Select * FROM procuratori");
		getAllCFProcuratori = connection.prepareStatement("Select codicefiscale FROM procuratori");
		
	}
	
	
	
	
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException {
		
		InserisciProcuratorePS.setString(1, procuratore.getNome());
		InserisciProcuratorePS.setString(2, procuratore.getCognome());
		InserisciProcuratorePS.setString(3, procuratore.getCodiceFiscale());
		InserisciProcuratorePS.setString(4, procuratore.getNumeroTelefonico());
		InserisciProcuratorePS.setString(5, procuratore.getNumeroTelefonico2());
		InserisciProcuratorePS.setString(6, procuratore.getEmail());
		//conversione della data di procuratore formato java.util, ad una data java.sql per poter usare "setDate".
		java.sql.Date sqlDate = new java.sql.Date(procuratore.getDataN().getTime());
		InserisciProcuratorePS.setDate(7,sqlDate);
		InserisciProcuratorePS.setInt(8, 0012);
		
	    InserisciProcuratorePS.executeUpdate();
		
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
