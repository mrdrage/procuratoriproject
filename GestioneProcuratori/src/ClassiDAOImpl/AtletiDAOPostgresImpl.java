package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiDAO.AtletiDAO;
import entita.Atleti;
import entita.GettoneNazionale;
import entita.Procuratori;

public class AtletiDAOPostgresImpl implements AtletiDAO {
	
	private Connection connection;
	private PreparedStatement  getMaxId;
	private PreparedStatement  getAllAtleti;
	private PreparedStatement  getAtletiByIDCollaborazione;
	private PreparedStatement  inserisciAtleta;	
	private PreparedStatement  getAtletaByCf;
	private PreparedStatement  getAtletiLiberi;
	private PreparedStatement  setCodCollaborazione;
	private PreparedStatement  getIDAtletiByIDCollaborazione;
	private PreparedStatement  getAtletiByID;
	private PreparedStatement  getGettoniNazionali;

	private PreparedStatement  setAtletaNull;

	
	public AtletiDAOPostgresImpl(Connection connection) throws SQLException {
		
		this.connection = connection;
		
		getMaxId = connection.prepareStatement("SELECT MAX(codatleti) FROM atleti");
		
		getAllAtleti = connection.prepareStatement("SELECT * from atleti");
		getAtletiByIDCollaborazione = connection.prepareStatement("SELECT * FROM atleti WHERE codcollaborazione = ?");
		inserisciAtleta = connection.prepareStatement("INSERT INTO atleti VALUES (?, ?, ?, ?, ?, ?, ?, ?, null)");
		getAtletaByCf = connection.prepareStatement("SELECT * FROM atleti WHERE codicefiscale = ?");
		getAtletiLiberi = connection.prepareStatement("SELECT * FROM atleti WHERE codcollaborazione is null");
		setCodCollaborazione = connection.prepareStatement("UPDATE atleti SET codcollaborazione = ? WHERE codatleti = ?");
		getIDAtletiByIDCollaborazione = connection.prepareStatement("SELECT codatleti FROM atleti WHERE codcollaborazione = ?");
		getAtletiByID = connection.prepareStatement("SELECT * FROM atleti WHERE codatleti = ?");
		getGettoniNazionali = connection.prepareStatement("SELECT * FROM gettonenazionale WHERE codatleti = ?");
		setAtletaNull = connection.prepareStatement("UPDATE atleti SET codcollaborazione = null WHERE codatleti = ?");

	}
	
	
	
	
	private int getNextCod () throws SQLException {
		int codAtleti = 0;
		ResultSet rs = getMaxId.executeQuery();
		
		while (rs.next()) {
			codAtleti = rs.getInt(1);
		}
		codAtleti++;
       
		return codAtleti;
	}
	
	public void setAtletaNull (int codatleti) throws SQLException {
		int row = 0;
		setAtletaNull.setInt(1, codatleti);
		row = setAtletaNull.executeUpdate();
		
	}
	
	public Atleti getAtletaByCf (String CodiceFiscale) throws SQLException {
		  
		   Atleti atleta = new Atleti();
		   getAtletaByCf.setString(1, CodiceFiscale);
		   ResultSet rs = getAtletaByCf.executeQuery();
		   int codatleti =0;
		   
		   //Essendo il cf unico basta utilizzare solo una volta il next(), che punterà quindi all'unica tupla presente
		   while(rs.next()) {
		   Atleti a = new Atleti(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		   atleta = a;
		   codatleti = rs.getInt(8);
		
		   }
		   
		   return atleta;
	   }
	
	public List<Atleti> getAllAtleti() throws SQLException{
		
		ResultSet rs = getAllAtleti.executeQuery();
		List<Atleti> lista = new ArrayList<Atleti>();
		
		while(rs.next())
		{
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"));
			lista.add(a);
		}
		rs.close();
		
		return lista;
	}
	
	public Atleti getAtletiByIDCollaborazione(int codcollaborazione) throws SQLException{
		
		Atleti atleta = new Atleti();
		getAtletiByIDCollaborazione.setInt(1, codcollaborazione);
		ResultSet rs = getAtletiByIDCollaborazione.executeQuery();
		
		while(rs.next()) {
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"));
			atleta = a;
		}
	    rs.close();
	    
		return atleta;
	}
	
	public void inserisciAtleta(Atleti atleta) throws SQLException{
		
		int CodAtleta = getNextCod();
		
		inserisciAtleta.setString(1, atleta.getNome());
		inserisciAtleta.setString(2, atleta.getCognome());
		inserisciAtleta.setString(3, atleta.getNazione());
		inserisciAtleta.setString(4, atleta.getCodiceFiscale());
		inserisciAtleta.setString(5, atleta.getSport());
		inserisciAtleta.setString(6, atleta.getClubAttuale());
		inserisciAtleta.setString(7, atleta.getSerieClub());
		inserisciAtleta.setInt(8, CodAtleta);
		
		inserisciAtleta.executeUpdate();
	}

	public int getIdAtletaByCf (String CodiceFiscale) throws SQLException {
		  
		   getAtletaByCf.setString(1, CodiceFiscale);
		   ResultSet rs = getAtletaByCf.executeQuery();
		   int codatleti = 0;
		   
		   //Essendo il cf unico basta utilizzare solo una volta il next(), che punterà quindi all'unica tupla presente
		   while(rs.next()) {
			   codatleti = rs.getInt(8);
		   }
		   rs.close();
		   
		   return codatleti;
	   }
	
	public List<Atleti> getAtletiLiberi () throws SQLException{
		
		List<Atleti> lista = new ArrayList<Atleti>();

		ResultSet rs = getAtletiLiberi.executeQuery();
		while (rs.next()) {
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"));
			lista.add(a);
		
		}
		
		return lista;
	}

	public void setCodCollaborazione (int codCollaborazione, int codAtleta) throws SQLException {
		
		int row = 0;
		setCodCollaborazione.setInt(2, codAtleta);
		setCodCollaborazione.setInt(1, codCollaborazione);
		
	
		
//		setCodCollaborazione.setInt(1, codCollaborazione);
//		setCodCollaborazione.setInt(2, codAtleta);
//		
	row = setCodCollaborazione.executeUpdate();
		
	}

	public int getIDAtletiByIDCollaborazione (int codCollaborazione) throws SQLException {
		
		int codiceAtleta = 0;
		getIDAtletiByIDCollaborazione.setInt(1, codCollaborazione);
		ResultSet rs = getIDAtletiByIDCollaborazione.executeQuery();
		
		while (rs.next()) {
			codiceAtleta = rs.getInt(1);
		}
		
		return codiceAtleta;
	}
	
	public Atleti getAtletiByID (int codAtleta) throws SQLException {
		
		Atleti atleta = new Atleti();
		
		getAtletiByID.setInt(1, codAtleta);
		ResultSet rs = getAtletiByID.executeQuery();
		while (rs.next()) {
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"));
			atleta = a;
		}
		
		return atleta;
	}

	public List<GettoneNazionale> getGettoniNazionali(int codAtleta) throws SQLException {
		
		List<GettoneNazionale> gettoniNazionale = new ArrayList<GettoneNazionale>();
		
		getGettoniNazionali.setInt(1, codAtleta);
		ResultSet rs = getGettoniNazionali.executeQuery();
		while (rs.next()) {
			GettoneNazionale g = new GettoneNazionale (rs.getDate(1), rs.getDouble(2));
			gettoniNazionale.add(g);
		}
		
		
		return gettoniNazionale;
	}
	
	
	
	}

