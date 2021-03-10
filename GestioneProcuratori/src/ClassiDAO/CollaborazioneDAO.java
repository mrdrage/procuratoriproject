package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.Collaborazione;
import entita.Procuratori;

public interface CollaborazioneDAO {

	public List<Collaborazione> getAllCollaborazioni() throws SQLException;
	public List<Collaborazione> getAllCollaborazioniByProcuratore(int CodProcuratore) throws SQLException;
	public void InserisciCollaborazione(Collaborazione collaborazione, int CodProcuratore, int CodAtleti) throws SQLException;
	
}
