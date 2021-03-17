 package entita;

public class Atleti {

	private String Nome;
	private String Cognome;
	private String Nazione;
	private String CodiceFiscale;
	private String Sport;
	private String ClubAttuale;
	private String SerieClub;
	
	public Atleti(String nome, String cognome, String nazione, String codicefiscale, String sport, String clubattuale, String serieclub) {
		this.Nome = nome;
		this.Cognome = cognome;
		this.Nazione = nazione;
		this.CodiceFiscale = codicefiscale;
		this.Sport = sport;
		this.ClubAttuale = clubattuale;
		this.SerieClub = serieclub;
	}
	
	public Atleti() {
		
	}
	
	
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getCognome() {
		return Cognome;
	}
	
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	
	public String getNazione() {
		return Nazione;
	}
	
	public void setNazione(String nazione) {
		Nazione = nazione;
	}
	
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}
	
	public String getSport() {
		return Sport;
	}
	
	public void setSport(String sport) {
		Sport = sport;
	}
	
	public String getClubAttuale() {
		return ClubAttuale;
	}
	
	public void setClubAttuale(String clubAttuale) {
		ClubAttuale = clubAttuale;
	}
	
	public String getSerieClub() {
		return SerieClub;
	}
	
	public void setSerieClub(String serieClub) {
		SerieClub = serieClub;
	}
	
}
