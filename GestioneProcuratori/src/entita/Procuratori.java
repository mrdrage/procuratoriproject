package entita;

import java.sql.Timestamp;
import java.util.Date;

public class Procuratori {

	private String Nome;
	private String Cognome;
	private String CodiceFiscale;
	private String NumeroTelefonico;
	private String NumeroTelefonico2;
	private String Email;
	private Timestamp DataN;
	
	public Procuratori(String nome, String cognome, String codicefiscale, String numerotelefonico, String numerotelefonico2, String email, Timestamp datan)
	{
		this.Nome  = nome;
		this.Cognome = cognome;
		this.CodiceFiscale = codicefiscale;
		this.NumeroTelefonico = numerotelefonico;
		this.NumeroTelefonico2 = numerotelefonico2;
		this.Email = email;
		this.DataN = datan;
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
	
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}
	
	public String getNumeroTelefonico() {
		return NumeroTelefonico;
	}
	
	public void setNumeroTelefonico(String numeroTelefonico) {
		NumeroTelefonico = numeroTelefonico;
	}
	
	public String getNumeroTelefonico2() {
		return NumeroTelefonico2;
	}

	public void setNumeroTelefonico2(String numeroTelefonico2) {
		NumeroTelefonico2 = numeroTelefonico2;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public Timestamp getDataN () {
		return DataN;
	}
	public void setDataN(Timestamp datan) {
		DataN = datan;
	}
	
	
	
	
	
}
