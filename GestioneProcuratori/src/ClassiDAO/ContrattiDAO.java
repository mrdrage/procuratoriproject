package ClassiDAO;

import java.sql.SQLException;

import entita.ContrattoClub;

public interface ContrattiDAO {

	public void inserisciContrattoClub(ContrattoClub contrattoclub, int codtransazioneclub, int  codatleti) throws SQLException;
	
}
