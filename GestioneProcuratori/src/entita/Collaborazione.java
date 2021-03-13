package entita;

import java.sql.Timestamp;
import java.util.Date;

public class Collaborazione {

	private Date DataInizio;
	private Date DataFine;
	private Timestamp StipendioMensile;
	
	public Collaborazione(Date parsedate1, Date parsedate2, Timestamp timestamp) {
		this.DataInizio = parsedate1;
		this.DataFine = parsedate2;
		this.StipendioMensile = timestamp;
	}
	
	
	
	



	public Date getDataFine() {
		return DataFine;
	}
	
	public void setDataFine(Date dataFine) {
		DataFine = dataFine;
	}
	
	public Timestamp getStipendioMensile() {
		return StipendioMensile;
	}
	
	public void setStipendioMensile(Timestamp stipendioMensile) {
		StipendioMensile = stipendioMensile;
	}
	
	public Date getDataInizio() {
		return DataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		DataInizio = dataInizio;
	}
}
