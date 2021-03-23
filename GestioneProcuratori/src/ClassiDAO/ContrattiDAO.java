package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.ContrattoClub;
import entita.ContrattoSponsor;

public interface ContrattiDAO {

	public void inserisciContrattoClub(ContrattoClub contrattoclub, int  codatleti) throws SQLException;
	public void inserisciContrattoSponsor(ContrattoSponsor contrattosponsor, int codatleti)  throws SQLException;
	public List<ContrattoClub> getContrattiClubById (int id) throws SQLException;
	public List<ContrattoSponsor> getContrattiSponsorById (int id) throws SQLException;
}
