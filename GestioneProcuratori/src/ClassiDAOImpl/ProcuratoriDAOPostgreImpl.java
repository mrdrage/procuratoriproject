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
    private PreparedStatement InserisciProcuratoreDB_PS;
    String SQLSt = "INSERT INTO Procuratori VALUES (?, ?, ?, ?, ?, ?, ?)";
    
	public ProcuratoriDAOPostgreImpl(Connection connection) throws SQLException {
		this.connection = connection;
		InserisciProcuratoreDB_PS = connection.prepareStatement(SQLSt);
	}


	@Override
	public boolean TrovaProcuratore(String CodiceFiscale) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Procuratori getInfoProcuratore(String CodiceFiscale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Procuratori> getProcuratori() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InserisciProcuratoreDB(Procuratori procuratore) throws SQLException, ParseException {
		InserisciProcuratoreDB_PS.setString(1, procuratore.getNome());
		InserisciProcuratoreDB_PS.setString(2, procuratore.getCognome());
		InserisciProcuratoreDB_PS.setString(3, procuratore.getCodiceFiscale());
		InserisciProcuratoreDB_PS.setString(4, procuratore.getNumeroTelefonico());
		InserisciProcuratoreDB_PS.setString(5, procuratore.getNumeroTelefonico2());
		InserisciProcuratoreDB_PS.setString(6, procuratore.getEmail());
		
	//	
		    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        Date parsed = (Date) format.parse(procuratore.getDataN());
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    InserisciProcuratoreDB_PS.setDate(7, parsed);
	    
		InserisciProcuratoreDB_PS.executeUpdate();
}
	
}
