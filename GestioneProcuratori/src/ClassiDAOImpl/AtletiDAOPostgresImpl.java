package ClassiDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiDAO.AtletiDAO;
import entita.Atleti;

public class AtletiDAOPostgresImpl implements AtletiDAO {
	private Connection connection;
	private PreparedStatement  getAllAtleti;
	private PreparedStatement  getAtletiByIDCollaborazione;
	private PreparedStatement  inserisciAtletaPS;

	
	public AtletiDAOPostgresImpl(Connection connection) throws SQLException {
		
		this.connection = connection;
		
		getAllAtleti = connection.prepareStatement("SELECT * from atleti");
		getAtletiByIDCollaborazione = connection.prepareStatement("SELECT * from atleti WHERE codcollaborazione= ?");
		inserisciAtletaPS = connection.prepareStatement("INSERT INTO atleti VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		
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
	
		return atleta;
	}
	
	public void inserisciAtleta(Atleti atleta, int codcollaborazione, int codatleti) throws SQLException{
		inserisciAtletaPS.setString(1, atleta.getNome());
		inserisciAtletaPS.setString(2, atleta.getCognome());
		inserisciAtletaPS.setString(3, atleta.getNazione());
		inserisciAtletaPS.setString(4, atleta.getCodiceFiscale());
		inserisciAtletaPS.setString(5, atleta.getSport());
		inserisciAtletaPS.setString(6, atleta.getClubAttuale());
		inserisciAtletaPS.setString(7, atleta.getSerieClub());
	}






	
	}

