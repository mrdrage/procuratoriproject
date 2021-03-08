package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entita.Procuratori;

public class ProcuratoriDAOPostgresImpl {
	
	private Connection connection;
	private PreparedStatement InserisciProcuratorePS;
	
	public ProcuratoriDAOPostgresImpl(Connection connection) throws SQLException
	{
		this.connection = connection;
		
		InserisciProcuratorePS = connection.prepareStatement("INSERT INTO procuratori VALUES (?,?,?,?,?,?,?,?) ");
		
	}
	
	
	public int InserisciProcuratore(Procuratori procuratore) throws SQLException {
		
		InserisciProcuratorePS.setString(1, "asdrubale");
		InserisciProcuratorePS.setString(2, "lini");
		InserisciProcuratorePS.setString(3, "12345678901qwdog");
		InserisciProcuratorePS.setString(4, "081888999");
		InserisciProcuratorePS.setString(5, "042134055");
		InserisciProcuratorePS.setString(6, "asfdur");
		InserisciProcuratorePS.setTimestamp(7,procuratore.getDataN());
		InserisciProcuratorePS.setInt(8, 0007);
		
		int row = InserisciProcuratorePS.executeUpdate();
		return row;
	}
	

}
