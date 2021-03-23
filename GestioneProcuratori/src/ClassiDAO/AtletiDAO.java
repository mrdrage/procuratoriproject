package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.Atleti;
import entita.GettoneNazionale;

public interface AtletiDAO {

	public void setAtletaNull (int codatleti) throws SQLException;
	public Atleti getAtletaByCf (String CodiceFiscale) throws SQLException;
	public List<Atleti> getAllAtleti() throws SQLException;
	public Atleti getAtletiByIDCollaborazione(int codcollaborazione) throws SQLException;
	public void inserisciAtleta(Atleti atleta) throws SQLException;
	public int getIdAtletaByCf (String CodiceFiscale) throws SQLException;
	public List<Atleti> getAtletiLiberi () throws SQLException;
	public void setCodCollaborazione (int codCollaborazione, int codAtleta) throws SQLException;
	public int getIDAtletiByIDCollaborazione (int codCollaborazione) throws SQLException;
	public Atleti getAtletiByID (int codAtleta) throws SQLException;
	public List<GettoneNazionale> getGettoniNazionali(int codAtleta) throws SQLException;
}
