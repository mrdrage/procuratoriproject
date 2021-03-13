package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiDAO.CollaborazioneDAO;
import entita.Collaborazione;
import entita.Procuratori;

public class CollaborazioneDAOPostgresImpl implements CollaborazioneDAO {
	

	private Connection connection;
	private PreparedStatement InserisciCollaborazione, getAllCollaborazioni, getAllCollaborazioniByProcuratore,getCodCollaborazione;
	
	
	
	

	public CollaborazioneDAOPostgresImpl(Connection connection) throws SQLException
	{
		this.connection = connection;
		
		getCodCollaborazione = connection.prepareStatement("SELECT MAX(codCollaborazione) FROM collaborazione ");
		
		getAllCollaborazioni = connection.prepareStatement("SELECT * FROM collaborazione");
		getAllCollaborazioniByProcuratore = connection.prepareStatement("SELECT * FROM collaborazione WHERE codprocuratore = ? ");
		InserisciCollaborazione = connection.prepareStatement("INSERT INTO collaborazione VALUES (?,?,?,?,?,?) ");
		
	}
	
	
	

	
	public List<Collaborazione> getAllCollaborazioni() throws SQLException {
		//Svolgo la Query ottenendo tutte le collaboraziioni presenti restituendole in una List
		ResultSet rs = getAllCollaborazioni.executeQuery();
		List <Collaborazione> CollabList = new ArrayList<Collaborazione>();
		
		while (rs.next()) {
			Collaborazione C = new Collaborazione (rs.getDate(1), rs.getDate(2), rs.getTimestamp(3));
			CollabList.add(C);
		}
		return CollabList;
	}

	
	public List<Collaborazione> getAllCollaborazioniByProcuratore(int CodProcuratore) throws SQLException {
		//Passo il codice procuratore all'interrogazione
		getAllCollaborazioniByProcuratore.setInt(1, CodProcuratore);
		//Metto in questa lista quindi le collaborazioni relative a questo procuratore
		List <Collaborazione> CollabList = new ArrayList<Collaborazione>();
		
		ResultSet rs = getAllCollaborazioniByProcuratore.executeQuery();
		
		while (rs.next()) {
			//rs.getTimestamp prima era rs.getDouble
			Collaborazione C = new Collaborazione (rs.getDate(1), rs.getDate(2), rs.getTimestamp(3));
			CollabList.add(C);
		}
		
		return CollabList;
	}

	
	public void InserisciCollaborazione(Collaborazione collaborazione, int CodProcuratori, int CodAtleti) throws SQLException {
		int CodC = 0;
		//inserisco anche i codici relativi ad atleta e procuratore, poiché richiesti dal DB
		java.sql.Date sqlDataInizio = new java.sql.Date(collaborazione.getDataInizio().getTime());
		InserisciCollaborazione.setDate(1, sqlDataInizio);
		
		java.sql.Date sqlDataFine = new java.sql.Date(collaborazione.getDataFine().getTime());
		InserisciCollaborazione.setDate(2, sqlDataFine);
		
		InserisciCollaborazione.setTimestamp(3, collaborazione.getStipendioMensile());
		
		
		
//		ResultSet CodiceCollaborazione = getCodCollaborazione.executeQuery();
//		CodC = CodiceCollaborazione.getInt("codCollaborazione");
//		InserisciCollaborazione.setInt(4, CodC + 1);
		//Codici estratti dal controller usando i metodi di  ProcuratoriDAOPostgresImpl
		
		InserisciCollaborazione.setInt(5, CodAtleti);
        InserisciCollaborazione.setInt(6, CodProcuratori);
		
        InserisciCollaborazione.executeUpdate();
 
		

	}

}
