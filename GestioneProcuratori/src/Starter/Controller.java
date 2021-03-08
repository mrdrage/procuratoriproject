package Starter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassiDAOImpl.ProcuratoriDAOPostgresImpl;
import DBconfig.DBConnection;




public class Controller {
	

	public static void main(String[] args) throws SQLException {

//	Controller C = new Controller();
		
		PreparedStatement DatiProcuratore, InserisciP,inserisciA;
		ResultSet rs;
		int RowCount=0,codAtleta = 3, codCollab = 1;
		
		
		try {
			Connection conn= null;
			DBConnection dbc = DBConnection.getInstance();
			conn = dbc.getConnection();
			DatiProcuratore = conn.prepareStatement("SELECT * FROM procuratori");
			InserisciP = conn.prepareStatement("INSERT INTO procuratori VALUES (?,?,?,?,?,?,?,?) ");
			inserisciA = conn.prepareStatement("INSERT INTO Atleti VALUES (?,?,?,?,?,?,?,?,?)");
			rs = DatiProcuratore.executeQuery();
			
			while(rs.next()) {
				System.out.println ("nome : "+ rs.getString("nome"));
				System.out.println ("Cognome : "+ rs.getString(2));
				System.out.println ("codiceFiscale : "+ rs.getString(3));


			}
			
			InserisciP.setString(1, "asdrubale");
			InserisciP.setString(2, "lini");
			InserisciP.setString(3, "12345678901qwdog");
			InserisciP.setString(4, "081888999");
			InserisciP.setString(5, "042134055");
			InserisciP.setString(6, "asfdur");
			InserisciP.setString(7, "2000-12-30");
			InserisciP.setInt(8, 0007);
			
			

			inserisciA.setString(1, "asdrubale");
      		inserisciA.setString(2, "lini");
			inserisciA.setString(4, "12345678901qwdog");
			inserisciA.setString(3, "italiana");
			inserisciA.setString(5, "pallone");
			inserisciA.setString(6, "napulegno");
			inserisciA.setString(7, "SerieA");
			inserisciA.setInt(8, 3);
			inserisciA.setObject(9,codCollab);







			//RowCount = InserisciP.executeUpdate();
			inserisciA.executeUpdate();
			
			
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println ("errore§? " + e.getMessage());
				return;
			}
		
		
		
	}
}
