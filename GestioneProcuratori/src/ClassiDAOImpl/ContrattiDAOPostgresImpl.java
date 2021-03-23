package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Starter.Controller;

import ClassiDAO.ContrattiDAO;
import entita.ContrattoClub;
import entita.ContrattoSponsor;

public class ContrattiDAOPostgresImpl implements ContrattiDAO {
	
	private Connection connection;
	private PreparedStatement inserisciContrattoClubPS;
	private PreparedStatement inserisciContrattoSponsorPS;
	private PreparedStatement getContrattiClubById;
	private PreparedStatement getContrattiSponsorById;
	private PreparedStatement getMaxIdClub, getMaxIdSponsor;
	
	
	public ContrattiDAOPostgresImpl(Connection connection) throws SQLException{
		this.connection = connection;
		getMaxIdClub = connection.prepareStatement("SELECT MAX(codtransazioneclub) as cod FROM contrattoclub");
		getMaxIdSponsor = connection.prepareStatement("SELECT MAX(codtransazionesponsor) as cod FROM contrattosponsor");

		inserisciContrattoClubPS = connection.prepareStatement("INSERT INTO contrattoclub VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		inserisciContrattoSponsorPS = connection.prepareStatement("INSERT INTO contrattosponsor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		getContrattiClubById = connection.prepareStatement("SELECT * FROM contrattoclub WHERE codatleti = ?");
		getContrattiSponsorById = connection.prepareStatement("SELECT * FROM contrattosponsor WHERE codatleti = ?");
		
	}
	
	//gestione codici contratti
	private int getNextCodClub () throws SQLException {
		int codClub = 0;
		ResultSet rs = getMaxIdClub.executeQuery();
		
		while (rs.next()) {
			codClub = rs.getInt(1);
		}
		codClub++;
       
		return codClub;
	}
	
	private int getNextCodSponsor () throws SQLException {
		int codSponsor = 0;
		ResultSet rs = getMaxIdClub.executeQuery();
		
		while (rs.next()) {
			codSponsor = rs.getInt(1);
		}
		codSponsor++;
       
		return codSponsor;
	}
	
	public void inserisciContrattoClub(ContrattoClub contrattoclub, int codatleti) throws SQLException {
	    //nextval del codice contratto
		int CodClub = getNextCodClub();
		
		java.sql.Date datainizio = new java.sql.Date(contrattoclub.getDataInizio().getTime());
		inserisciContrattoClubPS.setDate(1, datainizio);
		java.sql.Date datafine = new java.sql.Date(contrattoclub.getDataFine().getTime());
		inserisciContrattoClubPS.setDate(2, datafine);
		
		inserisciContrattoClubPS.setDouble(3, contrattoclub.getStipendioAtletaStagione());
		inserisciContrattoClubPS.setString(4, contrattoclub.getBonusStagione());
		inserisciContrattoClubPS.setDouble(5, contrattoclub.getGuadagnoBonus());
		inserisciContrattoClubPS.setString(6, contrattoclub.getVincoloContrattuale());
		
		// inserimento codici
		inserisciContrattoClubPS.setInt(7, CodClub);
		inserisciContrattoClubPS.setInt(8, codatleti);
		
		inserisciContrattoClubPS.executeUpdate();
	}

	public void inserisciContrattoSponsor(ContrattoSponsor contrattosponsor, int codatleti) throws SQLException {
	    //nextval del codice contratto
		int CodSponsor = getNextCodSponsor();
	
		java.sql.Date datainizio = new java.sql.Date(contrattosponsor.getDataInizio().getTime());
		inserisciContrattoSponsorPS.setDate(1, datainizio);
		java.sql.Date datafine = new java.sql.Date(contrattosponsor.getDataFine().getTime());
		inserisciContrattoSponsorPS.setDate(2, datafine);
		
		inserisciContrattoSponsorPS.setDouble(3, contrattosponsor.getGuadagno());
		inserisciContrattoSponsorPS.setDouble(4, contrattosponsor.getPercentualeProcuratore());
		inserisciContrattoSponsorPS.setString(5, contrattosponsor.getTipologiaSponsor());
		inserisciContrattoSponsorPS.setString(6, contrattosponsor.getMarcaSponsor());
	    inserisciContrattoSponsorPS.setString(7, contrattosponsor.getVincoliContrattuali());
	
	    //inserimento dei codici 
 		inserisciContrattoSponsorPS.setInt(8, CodSponsor);
		inserisciContrattoSponsorPS.setInt(9, codatleti);
		
		inserisciContrattoSponsorPS.executeUpdate();
	
	
      }
	
	public List<ContrattoClub> getContrattiClubById (int id) throws SQLException {
		List <ContrattoClub> listaContratti = new ArrayList<ContrattoClub>();
		
		getContrattiClubById.setInt (1,id);
		ResultSet rs = getContrattiClubById.executeQuery();
		
		while (rs.next()) {
			ContrattoClub c = new ContrattoClub(rs.getDate(1), rs.getDate(2), rs.getDouble(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
			listaContratti.add(c);
		}
		return listaContratti;
	}
	
	public List<ContrattoSponsor> getContrattiSponsorById (int id) throws SQLException {
		List <ContrattoSponsor> listaContratti = new ArrayList<ContrattoSponsor>();
		
		getContrattiSponsorById.setInt (1,id);
		ResultSet rs = getContrattiSponsorById.executeQuery();
		
		while (rs.next()) {
			ContrattoSponsor s = new ContrattoSponsor(rs.getDate(1), rs.getDate(2), rs.getDouble(3), rs.getDouble(4),rs.getString(5), rs.getString(6),rs.getString(7));
			listaContratti.add(s);
		}
		
		return listaContratti;
	}

}