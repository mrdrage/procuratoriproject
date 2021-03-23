package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ClassiDAO.CollaborazioneDAO;
import entita.Collaborazione;
import entita.Procuratori;

public class CollaborazioneDAOPostgresImpl implements CollaborazioneDAO {
	
	private int CodCollaborazione;
	
	private Connection connection;
	private PreparedStatement InserisciCollaborazione;
	private PreparedStatement getAllCollaborazioni;
	private PreparedStatement getAllCollaborazioniByProcuratore;
	private PreparedStatement getIDCollaborazioniByProcuratore;
	private PreparedStatement getMaxId;
	private PreparedStatement getMesiCollaborazione;
	private PreparedStatement getDataFineCollaborazione;
	private PreparedStatement cancellaCollaborazione;
	private PreparedStatement getIDCollaborazioneByIDAtleta;
	String ciao;
	

	public CollaborazioneDAOPostgresImpl(Connection connection) throws SQLException{
		
		this.connection = connection;

		getMaxId = connection.prepareStatement("SELECT MAX(codcollaborazione) FROM collaborazione");

		
		getAllCollaborazioni = connection.prepareStatement("SELECT * FROM collaborazione");
		getAllCollaborazioniByProcuratore = connection.prepareStatement("SELECT * FROM collaborazione WHERE codprocuratori = ? ");
		InserisciCollaborazione = connection.prepareStatement("INSERT INTO collaborazione VALUES (?,?,?,?,?,?) ");
		getIDCollaborazioniByProcuratore = connection.prepareStatement("SELECT codcollaborazione FROM collaborazione WHERE codprocuratori = ?");
		getMesiCollaborazione = connection.prepareStatement("SELECT datainizio, datafine FROM collaborazione WHERE codatleti = ?");
		getDataFineCollaborazione = connection.prepareStatement("SELECT datafine FROM collaborazione WHERE codatleti = ?");
		cancellaCollaborazione = connection.prepareStatement("DELETE FROM collaborazione WHERE codcollaborazione = ?");
		getIDCollaborazioneByIDAtleta = connection.prepareStatement("SELECT codcollaborazione FROM collaborazione WHERE codatleti = ?");
	}
	
	public int getIDCollaborazioneByIDAtleta(int codatleti) throws SQLException {
		
		int codCollab = 0;
		getIDCollaborazioneByIDAtleta.setInt(1, codatleti);
		ResultSet rs = getIDCollaborazioneByIDAtleta.executeQuery();
		while(rs.next()) {
			codCollab = rs.getInt(1);
		}
		
		return codCollab;
	}
	
	public void cancellaCollaborazione(int codcollaborazione) throws SQLException {
		
		int row = 0;
		
		cancellaCollaborazione.setInt(1, codcollaborazione);
		row = cancellaCollaborazione.executeUpdate();
	}
	
	public Date getDataFineCollaborazione (int codatleti) throws SQLException {
		
		Date DataFineCollaborazione = new Date();
		getDataFineCollaborazione.setInt(1, codatleti);
		ResultSet rs = getDataFineCollaborazione.executeQuery();
		while(rs.next()) {
			DataFineCollaborazione = rs.getDate(1);
		}
		return DataFineCollaborazione;
		
	}
	
	public boolean controllaFineCollaborazione(int codatleti) throws SQLException {
		 Date DataFineCollaborazione = null;
		 Date date = new Date();
		 DataFineCollaborazione = getDataFineCollaborazione(codatleti);
		 if (DataFineCollaborazione.compareTo(date) < 0)
			 return true;
		 
		 return false;
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
	
	
	public int getCodiceCollaborazione () {
		return CodCollaborazione;
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
		
       
        CodCollaborazione = CodC;
        
         System.out.println (CodProcuratori + "-"+ CodCollaborazione + "-"+CodC+"-" + CodAtleti);
         
        InserisciCollaborazione.executeUpdate();
 
        
	}
	
	public  long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	public long getMesiCollaborazione(int codatleti) throws SQLException {
		
		getMesiCollaborazione.setInt(1, codatleti);
		
		ResultSet rs = getMesiCollaborazione.executeQuery();
		Date datainizio = null;
		Date datafine = null;
		
		while(rs.next()) {
			datainizio = rs.getDate(1);
			datafine = rs.getDate(2);
		}
//		
//		  java.sql.Date dataInizio = new java.sql.Date(datainizio.getTime());
//		  java.sql.Date dataFine = new java.sql.Date(datafine.getTime());
//		
		  
		 
          return (getDateDiff(datainizio,datafine,TimeUnit.HOURS)/720);
  }
}
