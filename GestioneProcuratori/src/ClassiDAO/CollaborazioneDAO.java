package ClassiDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entita.Collaborazione;
import entita.Procuratori;

public interface CollaborazioneDAO {

	public int getIDCollaborazioneByIDAtleta(int codatleti) throws SQLException;
	public void cancellaCollaborazione(int codcollaborazione) throws SQLException;
	public Date getDataFineCollaborazione (int codatleti) throws SQLException ;
	public boolean controllaFineCollaborazione(int codatleti) throws SQLException;
	public List<Collaborazione> getAllCollaborazioni() throws SQLException;
	public List<Integer> getIDCollaborazioniByProcuratore(int CodProcuratori) throws SQLException;
	public List<Collaborazione> getAllCollaborazioniByProcuratore(int CodProcuratore) throws SQLException;
	public void InserisciCollaborazione(Collaborazione collaborazione, int CodProcuratore, int CodAtleti) throws SQLException;
	public long getMesiCollaborazione(int codatleti) throws SQLException;
}
