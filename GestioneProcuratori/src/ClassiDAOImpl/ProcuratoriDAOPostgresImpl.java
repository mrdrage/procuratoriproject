package ClassiDAOImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Sequence;

import org.postgresql.core.Field;

import ClassiDAO.ProcuratoriDAO;
import Starter.Controller;
import entita.Procuratori;

public class ProcuratoriDAOPostgresImpl implements ProcuratoriDAO {
	
	private Connection connection;
	private PreparedStatement inserisciProcuratorePS;
	private PreparedStatement getAllProcuratori;
	private PreparedStatement getAllCFProcuratori;
	private PreparedStatement getCodProcuratore;
	private PreparedStatement getProcuratoreByCf;
	private PreparedStatement getIDProcuratoreByCf;
	private PreparedStatement getMaxId;
	private PreparedStatement isNewId;
	private PreparedStatement getStipendioMensileProcuratore;
	private PreparedStatement getGuadagnoSponsorProcuratore;
	private PreparedStatement getProcuratoreByID;
	
	
	public ProcuratoriDAOPostgresImpl(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		getMaxId = connection.prepareStatement("SELECT MAX(codprocuratori) FROM procuratori");

		inserisciProcuratorePS = connection.prepareStatement("INSERT INTO procuratori(nome,cognome,codicefiscale,numerotelefonico,"
				+ "numerotelefonico2,email,datan,codprocuratori)"
				+ " VALUES (?,?,?,?,?,?,?,?)");
		getAllProcuratori = connection.prepareStatement("SELECT * FROM procuratori");
		getAllCFProcuratori = connection.prepareStatement("SELECT codicefiscale FROM procuratori");
		getProcuratoreByCf = connection.prepareStatement("SELECT * FROM procuratori WHERE codicefiscale = ?");
		getIDProcuratoreByCf = connection.prepareStatement("SELECT codprocuratori FROM procuratori WHERE codicefiscale = ?");
		getStipendioMensileProcuratore = connection.prepareStatement("SELECT stipendiomensileprocuratore FROM collaborazione where codprocuratori = ?");
		getGuadagnoSponsorProcuratore = connection.prepareStatement("SELECT guadagnoatleta, percentualeprocuratore FROM contrattosponsor where codatleti = ?");
		getProcuratoreByID = connection.prepareStatement("SELECT * from procuratori WHERE codprocuratori = ?");
		
		
	//	isNewId = connection.prepareStatement("SELECT MAX(codprocuratori)  FROM procuratori WHERE ? NOT IN (SELECT codprocuratori FROM procuratori) ");
	}
	
	
	
	private int getNextCod () throws SQLException {
		int codP = 0;
		ResultSet rs = getMaxId.executeQuery();
		
		while (rs.next()) {
			codP = rs.getInt(1);
		}
		codP++;
       
		return codP;
	}
	
	public void InserisciProcuratore(Procuratori procuratore) throws SQLException {
        //prendo il nextval 
		int codP=getNextCod();
		
		
		inserisciProcuratorePS.setString(1, procuratore.getNome());
		inserisciProcuratorePS.setString(2, procuratore.getCognome());
		inserisciProcuratorePS.setString(3, procuratore.getCodiceFiscale());
		inserisciProcuratorePS.setString(4, procuratore.getNumeroTelefonico());
		inserisciProcuratorePS.setString(5, procuratore.getNumeroTelefonico2());
		inserisciProcuratorePS.setString(6, procuratore.getEmail());

		//conversione della data di procuratore formato java.util, ad una data java.sql per poter usare "setDate".
		java.sql.Date sqlDate = new java.sql.Date(procuratore.getDataN().getTime());
		inserisciProcuratorePS.setDate(7,sqlDate);
		inserisciProcuratorePS.setInt(8,codP);
		
       
		
	    inserisciProcuratorePS.executeUpdate();
		
	}
	
    public List<Procuratori> getAllProcuratori() throws SQLException{
	 
	   ResultSet rs  = getAllProcuratori.executeQuery();
	   List<Procuratori> lista = new ArrayList<Procuratori>();
	   while(rs.next())
	   {
		   Procuratori p = new Procuratori(rs.getString("nome"), rs.getString("cognome"), rs.getString("codicefiscale"), rs.getString("numerotelefonico"), rs.getString("numerotelefonico2"), rs.getString("email"), rs.getDate("datan"));
		   lista.add(p);
	   }
	   rs.close();
	   return lista;
   }
	


   public List<String> getAllCFProcuratori() throws SQLException{

	
	   ResultSet rs = getAllCFProcuratori.executeQuery();
	   List<String> lista = new ArrayList<String>();
	 
	   while(rs.next()) {
	  	   String f = rs.getString(1);
		   lista.add(f);
	   }
	 
	   rs.close();
	   return lista;
   }  
   
   public Procuratori getProcuratoreByCf (String CodiceFiscale) throws SQLException {
	   
	  
	   int codprocuratori =0;
	   Procuratori procuratore = new Procuratori();
	   getProcuratoreByCf.setString(1, CodiceFiscale);
	   ResultSet rs = getProcuratoreByCf.executeQuery();
	   
	   
	   //Essendo il cf unico basta utilizzare solo una volta il next(), che punterà quindi all'unica tupla presente
	   while(rs.next()) {
	   Procuratori p = new Procuratori(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
	   procuratore = p;
	   codprocuratori = rs.getInt(8);
	
	   }
	   
	   return procuratore;
   }
   
   public Procuratori getProcuratoriByID (int codprocuratori) throws SQLException{
	   
	   Procuratori procuratore = new Procuratori();
	   getProcuratoreByID.setInt(1, codprocuratori);
	   ResultSet rs = getProcuratoreByID.executeQuery();
	   
	   while(rs.next()) {
		   Procuratori p = new Procuratori(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
		   procuratore = p;
	   }
	   
	   return procuratore;
	   
   }
   
   public int getIDProcuratoreByCf (String CodiceFiscale) throws SQLException {
	  
	   getIDProcuratoreByCf.setString(1, CodiceFiscale);
	   ResultSet rs = getIDProcuratoreByCf.executeQuery();
	   int codprocuratori = 0;
		   while(rs.next()) {

			   codprocuratori = rs.getInt(1);
	  
   }
	   return codprocuratori;
 }
   
   public double getStipendioMensileProcuratore(int codprocuratori) throws SQLException {
	   getStipendioMensileProcuratore.setInt(1, codprocuratori);
	   ResultSet rs = getStipendioMensileProcuratore.executeQuery();
	   double stipendiomensile = 0;
	   while(rs.next()) {
		   stipendiomensile = rs.getDouble(1);
	   }
	   return stipendiomensile;
   }
   
   public double getGuadagnoSponsorProcuratore(int codatleti) throws SQLException {
	   getGuadagnoSponsorProcuratore.setInt(1, codatleti);
	   ResultSet rs = getGuadagnoSponsorProcuratore.executeQuery();
	   double guadagnoatleta = 0;
	   double percentualeprocuratore = 0;
	   double guadagnofinale = 0;
	   while(rs.next()) {
		   guadagnoatleta = rs.getDouble(1);
		   percentualeprocuratore = rs.getDouble(2);
	   }
	   guadagnofinale = ((guadagnoatleta*percentualeprocuratore)/100);
	   return guadagnofinale;
   }
   
}
