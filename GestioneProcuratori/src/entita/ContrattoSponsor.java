package entita;

import java.util.Date;

public class ContrattoSponsor {

	private Date DataInizio;
	private Date DataFine;
	private double Guadagno;
	private double PercentualeProcuratore;
	private String TipologiaSponsor;
	private String MarcaSponsor;
	private String VincoliContrattuali;
	
	public ContrattoSponsor (Date datainizio, Date datafine, double guadagno, double percentualeprocuratore, String tipologiasponsor, String marcasponsor, String vincolicontrattuali) {
		this.DataInizio = datainizio;
		this.DataFine = datafine;
		this.Guadagno = guadagno;
		this.PercentualeProcuratore = percentualeprocuratore;
		this.TipologiaSponsor = tipologiasponsor;
		this.MarcaSponsor = marcasponsor;
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
	
	public double getGuadagno() {
		return Guadagno;
	}
	
	public void setGuadagno(double guadagno) {
		Guadagno = guadagno;
	}
	
	public double getPercentualeProcuratore() {
		return PercentualeProcuratore;
	}
	
	public void setPercentualeProcuratore(double percentualeProcuratore) {
		PercentualeProcuratore = percentualeProcuratore;
	}
	
	public String getTipologiaSponsor() {
		return TipologiaSponsor;
	}
	
	public void setTipologiaSponsor(String tipologiaSponsor) {
		TipologiaSponsor = tipologiaSponsor;
	}
	
	public String getMarcaSponsor() {
		return MarcaSponsor;
	}
	
	public void setMarcaSponsor(String marcaSponsor) {
		MarcaSponsor = marcaSponsor;
	}
	
	public String getVincoliContrattuali() {
		return VincoliContrattuali;
	}
	
	public void setVincoliContrattuali(String vincoliContrattuali) {
		VincoliContrattuali = vincoliContrattuali;
	}
}
