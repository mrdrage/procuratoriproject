package ClassiDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DBconfig.DBConnection;
import entita.Procuratori;

public interface ProcuratoriDAO {
	
		
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException;
	public List<Procuratori> getAllProcuratori() throws SQLException;
	public List<String> getAllCFProcuratori() throws SQLException;
	public Procuratori getProcuratoreByCf (String CodiceFiscale) throws SQLException;
	public Procuratori getProcuratoriByID (int codprocuratori) throws SQLException;
	public int getIDProcuratoreByCf (String CodiceFiscale) throws SQLException;
	public double getStipendioMensileProcuratore(int codprocuratori) throws SQLException;
	public double getGuadagnoSponsorProcuratore(int codatleti) throws SQLException;
	

	
 }

