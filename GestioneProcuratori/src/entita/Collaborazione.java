package entita;


import java.util.Date;

public class Collaborazione {

	private Date DataInizio;
	private Date DataFine;
	private double StipendioMensile;
	
	public Collaborazione(Date parsedate1, Date parsedate2, double stipendiomensile) {
		this.DataInizio = parsedate1;
		this.DataFine = parsedate2;
		this.StipendioMensile = stipendiomensile;
	}
	
	
	// mi prendo tutti gli stipendi e li metto in una variabile
	// lista di contratto sponsor degli atleti per procuratore
	// mi prendo una lista di guadagni e percentuali di tutti gli atleti per un procuratore
	
	



	public Date getDataFine() {
		return DataFine;
	}
	
	public void setDataFine(Date dataFine) {
		DataFine = dataFine;
	}
	
	public double getStipendioMensile() {
		return StipendioMensile;
	}
	
	public void setStipendioMensile(double stipendioMensile) {
		StipendioMensile = stipendioMensile;
	}
	
	public Date getDataInizio() {
		return DataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		DataInizio = dataInizio;
	}
	
	
}
