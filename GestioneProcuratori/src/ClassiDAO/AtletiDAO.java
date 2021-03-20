package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.Atleti;

public interface AtletiDAO {

	public List<Atleti> getAllAtleti() throws SQLException;
	public Atleti getAtletiByIDCollaborazione(int codcollaborazione) throws SQLException;
	
	public void inserisciAtleta(Atleti atleta, int codcollaborazione) throws SQLException;
	
}
