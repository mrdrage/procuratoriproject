package entita;

import java.sql.Date;

public class GettoneNazionale {


	private Date Data;
	private double Gudagno;	
	
	
	
	public GettoneNazionale(Date data, double gudagno) {
		super();
		Data = data;
		Gudagno = gudagno;
	}

	public GettoneNazionale() {
		
	}
	
	public Date getData() {
		return Data;
	}
	
	public void setData(Date data) {
		Data = data;
	}
	
	public double getGudagno() {
		return Gudagno;
	}
	
	public void setGudagno(double gudagno) {
		Gudagno = gudagno;
	}
}
