package ClassiDAOImpl;
	//MSTSVT98B27F839L
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import ClassiDAO.ProcuratoriDAO;
import entita.Procuratori;

public class ProcuratoriDAOPostgreImpl implements ProcuratoriDAO {
	
    private Connection connection;
    private PreparedStatement InserisciProcuratoreDB;

   
 public ProcuratoriDAOPostgreImpl(Connection connection) throws SQLException{
	 this.connection = connection;
	 
	 InserisciProcuratoreDB = connection.prepareStatement("INSERT INTO Procuratori (nome, cognome, codicefiscale, numerotelefonico, numerotelefonico2, email, datan, codprocuratori) VALUES (?, ?, ?, ?, ?, ?, ?::date, 5)");
	 
 }

	@Override
	public void InserisciProcuratoreDB(Procuratori procuratore) throws SQLException{
		InserisciProcuratoreDB.setString(1, procuratore.getNome());
		InserisciProcuratoreDB.setString(2, procuratore.getCognome());
		InserisciProcuratoreDB.setString(3, procuratore.getCodiceFiscale());
		InserisciProcuratoreDB.setString(4, procuratore.getNumeroTelefonico());
		InserisciProcuratoreDB.setString(5, procuratore.getNumeroTelefonico2());
		InserisciProcuratoreDB.setString(6, procuratore.getEmail());
	    InserisciProcuratoreDB.setString(7, procuratore.getDataN());
	  
	    
		InserisciProcuratoreDB.executeUpdate();
}
	
}
