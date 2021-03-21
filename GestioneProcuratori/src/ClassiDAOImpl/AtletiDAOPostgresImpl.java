package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiDAO.AtletiDAO;
import entita.Atleti;
import entita.Procuratori;

public class AtletiDAOPostgresImpl implements AtletiDAO {
	
	private Connection connection;
	private PreparedStatement  getAllAtleti;
	private PreparedStatement  getAtletiByIDCollaborazione;
	private PreparedStatement  inserisciAtleta;
	private PreparedStatement  getMaxId;
	private PreparedStatement  getAtletaByCf;
	private PreparedStatement  getAtletiLiberi;
	
	public AtletiDAOPostgresImpl(Connection connection) throws SQLException {
		
		this.connection = connection;
		getMaxId = connection.prepareStatement("SELECT MAX(codatleti) FROM atleti");
		
		getAllAtleti = connection.prepareStatement("SELECT * from atleti");
		getAtletiByIDCollaborazione = connection.prepareStatement("SELECT * FROM atleti WHERE codcollaborazione = ?");
		inserisciAtleta = connection.prepareStatement("INSERT INTO atleti VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		getAtletaByCf = connection.prepareStatement("SELECT * FROM atleti WHERE codicefiscale = ?");
		getAtletiLiberi = connection.prepareStatement("SELECT * FROM atleti WHERE codcollaborazione = null");
		
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
	
	public Atleti getAtletaByCf (String CodiceFiscale) throws SQLException {
		  
		   Atleti atleta = new Atleti();
		   getAtletaByCf.setString(1, CodiceFiscale);
		   ResultSet rs = getAtletaByCf.executeQuery();
		   int codatleti =0;
		   
		   //Essendo il cf unico basta utilizzare solo una volta il next(), che punterà quindi all'unica tupla presente
		   while(rs.next()) {
		   Atleti a = new Atleti(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
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
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"), rs.getString("serieclub"));
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
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"), rs.getString("serieclub"));
			atleta = a;
		}
	    rs.close();
	    
		return atleta;
	}
	
	public void inserisciAtleta(Atleti atleta, int codcollaborazione) throws SQLException{
		
		int CodAtleta = getNextCod();
		
		inserisciAtleta.setString(1, atleta.getNome());
		inserisciAtleta.setString(2, atleta.getCognome());
		inserisciAtleta.setString(3, atleta.getNazione());
		inserisciAtleta.setString(4, atleta.getCodiceFiscale());
		inserisciAtleta.setString(5, atleta.getSport());
		inserisciAtleta.setString(6, atleta.getClubAttuale());
		inserisciAtleta.setString(7, atleta.getSerieClub());
		inserisciAtleta.setInt(8, CodAtleta);
		inserisciAtleta.setInt(9, codcollaborazione);
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
			Atleti a = new Atleti(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazione"), rs.getString("codicefiscale"), rs.getString("sport"), rs.getString("clubattuale"), rs.getString("serieclub"));
			lista.add(a);
		
		}
		
		return lista;
	}



	
	}

