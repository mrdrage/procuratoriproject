package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Starter.Controller;
import entita.Procuratori;

public class ProcuratoriDAOPostgresImpl {
	
	
	private Connection connection;
	private PreparedStatement InserisciProcuratorePS;
	
	public ProcuratoriDAOPostgresImpl(Connection connection) throws SQLException
	{
		this.connection = connection;
		
		
		InserisciProcuratorePS = connection.prepareStatement("INSERT INTO procuratori VALUES (?,?,?,?,?,?,?,?) ");
		
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
	

}
