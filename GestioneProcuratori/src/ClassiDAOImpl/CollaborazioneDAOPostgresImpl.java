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
	private PreparedStatement InserisciCollaborazione;
	private PreparedStatement getAllCollaborazioni;
	private PreparedStatement getAllCollaborazioniByProcuratore;
	private PreparedStatement getIDCollaborazioniByProcuratore;
	private PreparedStatement getMaxId;

	public CollaborazioneDAOPostgresImpl(Connection connection) throws SQLException
	{
		this.connection = connection;

		getMaxId = connection.prepareStatement("SELECT MAX(codcollaborazione) FROM collaborazione");

		
		getAllCollaborazioni = connection.prepareStatement("SELECT * FROM collaborazione");
		getAllCollaborazioniByProcuratore = connection.prepareStatement("SELECT * FROM collaborazione WHERE codprocuratori = ? ");
		InserisciCollaborazione = connection.prepareStatement("INSERT INTO collaborazione VALUES (?,?,?,?,?,?) ");
		getIDCollaborazioniByProcuratore = connection.prepareStatement("SELECT codcollaborazione FROM collaborazione where codprocuratori = ?");
	}
	
	private int getNextCod () throws SQLException {
		int codCollab = 0;
		ResultSet rs = getMaxId.executeQuery();
		
		while (rs.next()) {
			codCollab = rs.getInt(1);
		}
		codCollab++;
       
		return codCollab;
	}
	

	
	public List<Collaborazione> getAllCollaborazioni() throws SQLException {
		//Svolgo la Query ottenendo tutte le collaboraziioni presenti restituendole in una List
		ResultSet rs = getAllCollaborazioni.executeQuery();
		List <Collaborazione> CollabList = new ArrayList<Collaborazione>();
		
	
		while (rs.next()) {
			Collaborazione C = new Collaborazione (rs.getDate(1), rs.getDate(2), rs.getDouble(3));
			CollabList.add(C);
		}
		return CollabList;
	}

	
	public List<Integer> getIDCollaborazioniByProcuratore(int CodProcuratori) throws SQLException{
		//Passo il codice procuratore all'interrogazione
		getIDCollaborazioniByProcuratore.setInt(1, CodProcuratori);
		
		//Metto nella lista tutti i codici collaborazioni relativi ad un procuratore
		List <Integer> CollabIDList = new ArrayList <Integer>();
		
		ResultSet rs = getIDCollaborazioniByProcuratore.executeQuery();
		while(rs.next()) {
			int codprocuratori = rs.getInt(1);
			CollabIDList.add(codprocuratori);
		}
		
		return CollabIDList;
	}
	
	public List<Collaborazione> getAllCollaborazioniByProcuratore(int CodProcuratori) throws SQLException {
		//Passo il codice procuratore all'interrogazione
		getAllCollaborazioniByProcuratore.setInt(1, CodProcuratori);
		
		//Metto in questa lista quindi le collaborazioni relative a questo procuratore
		List <Collaborazione> CollabList = new ArrayList<Collaborazione>();
		
		ResultSet rs = getAllCollaborazioniByProcuratore.executeQuery();
		
		while (rs.next()) {
			
			Collaborazione C = new Collaborazione (rs.getDate(1), rs.getDate(2), rs.getDouble(3));
			CollabList.add(C);
		}
		
		return CollabList;
	}

	

	public void InserisciCollaborazione(Collaborazione collaborazione, int CodProcuratori, int CodAtleti) throws SQLException {
		int CodC = getNextCod();

		//inserisco anche i codici relativi ad atleta e procuratore, poich� richiesti dal DB
		java.sql.Date sqlDataInizio = new java.sql.Date(collaborazione.getDataInizio().getTime());
		InserisciCollaborazione.setDate(1, sqlDataInizio);
		java.sql.Date sqlDataFine = new java.sql.Date(collaborazione.getDataFine().getTime());
		InserisciCollaborazione.setDate(2, sqlDataFine);
		
		InserisciCollaborazione.setDouble(3, collaborazione.getStipendioMensile());
		//inserimento codici
		InserisciCollaborazione.setInt(4, CodC);
		InserisciCollaborazione.setInt(5, CodAtleti);
        InserisciCollaborazione.setInt(6, CodProcuratori);
		
        InserisciCollaborazione.executeUpdate();
 
		

	}

}
