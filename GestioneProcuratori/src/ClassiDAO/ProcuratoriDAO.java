package ClassiDAO;

import entita.Procuratori;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.SQLException;
import java.util.List;

public interface ProcuratoriDAO {
	
	boolean TrovaProcuratore(String CodiceFiscale) throws SQLException;
	Procuratori getInfoProcuratore (String CodiceFiscale) throws SQLException;
    List<Procuratori> getProcuratori () throws SQLException;
    void InserisciProcuratoreDB (Procuratori procuratore) throws SQLException,ParseException;
}
