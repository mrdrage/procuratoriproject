package ClassiDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DBconfig.DBConnection;
import entita.Procuratori;

public interface ProcuratoriDAO {
	
	public List<Procuratori> getAllProcuratori() throws SQLException;
	public List<String> getAllCFProcuratori() throws SQLException;
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException;
	public Procuratori getProcuratoreByCf (String CodiceFiscale) throws SQLException;
	

	
 }

