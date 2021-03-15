package ClassiDAO;

import java.sql.SQLException;

import entita.ContrattoClub;
import entita.ContrattoSponsor;

public interface ContrattiDAO {

	public void inserisciContrattoClub(ContrattoClub contrattoclub, int codtransazioneclub, int  codatleti) throws SQLException;
	public void inserisciContrattoSponsor(ContrattoSponsor contrattosponsor, int codtransazionesponsor, int codatleti)  throws SQLException;
	
}
