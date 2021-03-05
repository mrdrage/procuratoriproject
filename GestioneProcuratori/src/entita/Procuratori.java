package entita;

import java.util.Date;

public class Procuratori {
//N.B. Non ci sono REGEX nei setter poichè sono già presenti lato DB(CodiceFiscale, NumeroTelefonico, email, NumeroTelefonico2)
	private String Nome;
	private String Cognome;
	private String CodiceFiscale;
	private String NumeroTelefonico;
	private String NumeroTelefonico2;
	private String Email;
	private Date DataN;
	
	
	
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
	
	public Date getDataN () {
		return DataN;
	}
	public void setDataN(Date data) {
		DataN = data;
	}
	
	
	
	
	
}
