package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.Atleti;

public interface AtletiDAO {

	public List<Atleti> getAllAtleti() throws SQLException;
	public List<Atleti> getAtletiByProcuratore(int codcollaborazione) throws SQLException;
	
	public void inserisciAtleta(Atleti atleta, int codcollaborazione, int codatleti) throws SQLException;
	
}
