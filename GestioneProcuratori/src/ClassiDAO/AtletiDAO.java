package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.Atleti;

public interface AtletiDAO {

	public Atleti getAtletaByCf (String CodiceFiscale) throws SQLException;
	public List<Atleti> getAllAtleti() throws SQLException;
	public Atleti getAtletiByIDCollaborazione(int codcollaborazione) throws SQLException;
	public void inserisciAtleta(Atleti atleta) throws SQLException;
	public int getIdAtletaByCf (String CodiceFiscale) throws SQLException;
	public List<Atleti> getAtletiLiberi () throws SQLException;
}
