package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import entita.Atleti;

public interface AtletiDAO {

	public List<Atleti> getAllAtleti() throws SQLException;
	public List<Atleti> getAllAtletiByProcuratore() throws SQLException;
	
	public void inserisciAtleta() throws SQLException;
	
}
