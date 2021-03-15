package entita;

import java.util.Date;

public class ContrattoClub {

	private Date DataInizio;
	private Date DataFine;
	private double StipendioAtletaStagione;
	private String BonusStagione;
	private double GuadagnoBonus;
	private String VincoliContrattuali;
	
	public ContrattoClub(Date datainizio, Date datafine, double stipendioatletastagione, String bonusstagione, double guadagnobonus, String vincolicontrattuali) {
		this.DataInizio = datainizio; 
		this.DataFine = datafine;
		this.StipendioAtletaStagione = stipendioatletastagione;
		this.BonusStagione = bonusstagione;
		this.GuadagnoBonus = guadagnobonus;
		this.VincoliContrattuali = vincolicontrattuali; 
	}
	
	public Date getDataInizio() {
		return DataInizio;
	}
	
	public void setDataInizio(Date dataInizio) {
		DataInizio = dataInizio;
	}
	
	public Date getDataFine() {
		return DataFine;
	}
	
	public void setDataFine(Date dataFine) {
		DataFine = dataFine;
	}
	
	public double getStipendioAtletaStagione() {
		return StipendioAtletaStagione;
	}
	
	public void setStipendioAtletaStagione(double stipendioAtletaStagione) {
		StipendioAtletaStagione = stipendioAtletaStagione;
	}
	
	public String getBonusStagione() {
		return BonusStagione;
	}
	
	public void setBonusStagione(String bonusStagione) {
		BonusStagione = bonusStagione;
	}
	
	public double getGuadagnoBonus() {
		return GuadagnoBonus;
	}
	
	public void setGuadagnoBonus(double guadagnoBonus) {
		GuadagnoBonus = guadagnoBonus;
	}
	
	public String getVincoloContrattuale() {
		return VincoliContrattuali;
	}
	
	public void setVincoloContrattuale(String vincoloContrattuale) {
		VincoliContrattuali = vincoloContrattuale;
	}
	
	
}
