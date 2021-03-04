package Entità;

import java.sql.Date;

public class Collaborazione {

	private Date DataInizio;
	private Date DataFine;
	private double StipendioMensile;
	
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
