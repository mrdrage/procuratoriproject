package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import Starter.Controller;

import ClassiDAO.ContrattiDAO;
import entita.ContrattoClub;
import entita.ContrattoSponsor;

public class ContrattiDAOPostgresImpl implements ContrattiDAO {
	
	private Connection connection;
	private PreparedStatement inserisciContrattoClubPS;
	private PreparedStatement inserisciContrattoSponsorPS;
	
	
	
	public ContrattiDAOPostgresImpl(Connection connection) throws SQLException{
		this.connection = connection;
		
		inserisciContrattoClubPS = connection.prepareStatement("INSERT INTO contrattoclub VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		inserisciContrattoSponsorPS = connection.prepareStatement("INSERT INTO contrattosponsor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?");
		
		
	}
	
	
	public void inserisciContrattoClub(ContrattoClub contrattoclub, int codtransazioneclub, int codatleti) throws SQLException {
		
		java.sql.Date datainizio = new java.sql.Date(contrattoclub.getDataInizio().getTime());
		inserisciContrattoClubPS.setDate(1, datainizio);
		
		java.sql.Date datafine = new java.sql.Date(contrattoclub.getDataFine().getTime());
		inserisciContrattoClubPS.setDate(2, datafine);
		inserisciContrattoClubPS.setDouble(3, contrattoclub.getStipendioAtletaStagione());
		inserisciContrattoClubPS.setString(4, contrattoclub.getBonusStagione());
		inserisciContrattoClubPS.setDouble(5, contrattoclub.getGuadagnoBonus());
		inserisciContrattoClubPS.setString(6, contrattoclub.getVincoloContrattuale());
		
		// Gestire codici codtransazioneclub e codatleti
		
		codtransazioneclub = 0;
		inserisciContrattoClubPS.setInt(7, codtransazioneclub);
		codatleti = 1;
		inserisciContrattoClubPS.setInt(8,  codatleti);
		
		inserisciContrattoClubPS.executeUpdate();
	}




public void inserisciContrattoSponsor(ContrattoSponsor contrattosponsor, int codtransazionesponsor, int codatleti) throws SQLException {
	
	java.sql.Date datainizio = new java.sql.Date(contrattosponsor.getDataInizio().getTime());
	inserisciContrattoSponsorPS.setDate(1, datainizio);
	
	java.sql.Date datafine = new java.sql.Date(contrattosponsor.getDataFine().getTime());
	inserisciContrattoSponsorPS.setDate(2, datafine);
	
	inserisciContrattoSponsorPS.setDouble(3, contrattosponsor.getGuadagno());
	inserisciContrattoSponsorPS.setDouble(4, contrattosponsor.getPercentualeProcuratore());
	inserisciContrattoSponsorPS.setString(5, contrattosponsor.getTipologiaSponsor());
	inserisciContrattoSponsorPS.setString(6, contrattosponsor.getMarcaSponsor());
	inserisciContrattoSponsorPS.setString(7, contrattosponsor.getVincoliContrattuali());
	
	// Gestire codici codtransazionesponsor e codatleti
	
	codtransazionesponsor = 0;
	inserisciContrattoSponsorPS.setInt(8, codtransazionesponsor);
	codatleti = 0;
	inserisciContrattoSponsorPS.setInt(9, codatleti);
	
	inserisciContrattoSponsorPS.executeUpdate();
	
	
 }
}