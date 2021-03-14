package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import Starter.Controller;

import ClassiDAO.ContrattiDAO;
import entita.ContrattoClub;

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

}
