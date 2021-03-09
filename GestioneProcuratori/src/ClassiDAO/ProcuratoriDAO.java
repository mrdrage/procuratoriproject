package ClassiDAO;

import java.sql.Connection;
import java.sql.SQLException;

import DBconfig.DBConnection;
import entita.Procuratori;

public interface ProcuratoriDAO {
	
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException;

	
 }

