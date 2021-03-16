package Starter;


import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ClassiDAO.ProcuratoriDAO;
import ClassiDAOImpl.AtletiDAOPostgresImpl;
import ClassiDAOImpl.ProcuratoriDAOPostgresImpl;
import ClassiDAOImpl.CollaborazioneDAOPostgresImpl;
import ClassiDAOImpl.ContrattiDAOPostgresImpl;
import DBconfig.DBConnection;
import GUI.*;
import entita.Atleti;
import entita.Collaborazione;
import entita.ContrattoClub;
import entita.ContrattoSponsor;
import entita.Procuratori;




public class Controller {
          //Daos usate
	      ProcuratoriDAOPostgresImpl ProcuratoriDAOPostgresImpl;
	      CollaborazioneDAOPostgresImpl CollaborazioneDAOPostgresImpl;
	      AtletiDAOPostgresImpl AtletiDAOPostgresImpl;
	      ContrattiDAOPostgresImpl ContrattiDAOPostgresImpl;
	      //Finestre procuratori
	      M_Benvenuto Benvenuto = null; 
	      M_GestioneProcuratore GestioneProcuratore = null;
	      M_NuovoProcuratore NuovoProcuratore = null;
	      M_ProcuratoreInseritoOk ProcuratoreInseritoOK;
	      M_CercaProcuratore CercaProcuratore;
	    
	      //Finestre collaborazioni
	      M_NuovoAtletaCollab NuovoAtletaCollab;
	      M_NuovaCollaborazione NuovaCollaborazione;
	      M_ListaCollaborazioni ListaCollaborazioni;
	      //Finestre contratti
	      M_AggiungiContrattoClub AggiungiContrattoClub;
	      M_AggiungiContrattoSponsor AggiungiContrattoSponsor;
	      M_ContrattoClubEsistente ContrattoClubEsistente;
	      M_ContrattoClubInserito ContrattoClubInserito;
	      M_ContrattoSponsorInserito ContrattoSponsorInserito;
	      
	      
     public Controller (Connection connection) throws SQLException {

     
    	  //Avvio dell'app
	      Benvenuto = new M_Benvenuto(this);
	      Benvenuto.setVisible(true);
	      
	      GestioneProcuratore = new M_GestioneProcuratore(this);
	      NuovoProcuratore = new M_NuovoProcuratore(this);
	      ProcuratoreInseritoOK = new M_ProcuratoreInseritoOk(this);
	      CercaProcuratore = new M_CercaProcuratore(this);

	      
	      NuovoAtletaCollab = new M_NuovoAtletaCollab(this);
	      ListaCollaborazioni = new M_ListaCollaborazioni(this);
	      
	      AggiungiContrattoClub = new M_AggiungiContrattoClub(this);
	      AggiungiContrattoSponsor = new M_AggiungiContrattoSponsor(this);
	      ContrattoClubEsistente = new M_ContrattoClubEsistente(this);
	      ContrattoClubInserito = new M_ContrattoClubInserito(this);
	      ContrattoSponsorInserito = new M_ContrattoSponsorInserito(this);
     

     }
     
     public void IniziaInserimentoProcuratore () {
    	 
    	 Benvenuto.setVisible(false);
    	 NuovoProcuratore.setVisible(true);
    	 
     }
     
     public void IniziaInserimentoContrattoClub() {
    	 AggiungiContrattoClub.setVisible(true);
     }
     
     public void ContrattoClubInseritoCorrettamente() {
    	 ContrattoClubInserito.setVisible(true);
     }
     
     public void ContrattoSponsorInseritoCorrettamente() {
    	 ContrattoSponsorInserito.setVisible(true);
     }
     
//     public void ApriGestioneProcuratore() {
//    	 //Dobbiamo passargli prima i dati del procuratore scelto in precedenza
//    	 GestioneProcuratore.setVisible(true);
//     }
     
     public void ApriListaCollaborazioni() {
    	 
    	 //Dobbiamo passargli prima i dati delle collaborazioni del procuratore scelto in precedenza
    	 ListaCollaborazioni.setVisible(true);
     }
     
     public void InserisciProcuratoreDB (String nome, String cognome, String CF, String Ntel, String Ntel2, String email, String dataN) throws SQLException, ParseException {
    	
    	//Conversione da String a Date della dataN
    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
 		Date parsedate = format.parse(dataN);
    	 
        Procuratori procuratore = new Procuratori(nome, cognome, CF, Ntel, Ntel2, email, parsedate);
    	 
        ProcuratoriDAOPostgresImpl.InserisciProcuratore(procuratore);
        
        //Se tutto va bene
        ProcuratoreInseritoOK.setVisible(true);
        
      
        
     }
     

     public void RicercaProcuratori () throws SQLException {
    	 
    	 Benvenuto.setVisible(false);
    	 List<Procuratori> procuratori = new ArrayList<Procuratori>();
    	 List<String> InfoProcuratori = new ArrayList<String>();
    	 
    	 //prelevo dal DB i procuratori	 
    	 procuratori = ProcuratoriDAOPostgresImpl.getAllProcuratori();
    	 
    	 //estrapolo le info dai procuratori 
         Iterator<Procuratori> i = procuratori.iterator();
    	 
    	       while (i.hasNext()) {  
    		        Procuratori p = i.next();
    		        InfoProcuratori.add(p.getNome()+" "+p.getCognome()+" "+p.getCodiceFiscale());
    	       }
    	       
    	 //li imposto sulla combobox
         CercaProcuratore.setProcuratoriComboBox(InfoProcuratori);
         
    	 //visualizzo la  finestra 
   	     CercaProcuratore.setVisible(true);
    		 
    	
    		 
    	 
    	 
     }
     
     public void VisualizzaInfoProcuratore (String InfoProcuratore) throws SQLException {
    	 Procuratori procuratore = new Procuratori();
    	 
    	 CercaProcuratore.setVisible(false);
    	 //Ricavo il codice fiscale
    	 String CfProcuratore = InfoProcuratore;
    	 CfProcuratore.substring(InfoProcuratore.length()-16);
    	 //lo passo al dao ottenendo tutte le info in un ogetto Procuratori
    	 procuratore = ProcuratoriDAOPostgresImpl.getProcuratoreByCf(CfProcuratore);
    	 //setto la scheda del procuratore
    	 GestioneProcuratore.setProcuratore(procuratore);
    	 
    	 
    	 //visualizzio la finestra
    	 GestioneProcuratore.setVisible(true);
    	 
     }
     

     
     public void InserisciAtletaDB(String nome, String cognome, String nazione, String codicefiscale, String sport, String clubattuale, String serieclub) throws SQLException {
        Atleti atleta = new Atleti(nome, cognome, nazione, codicefiscale, sport, clubattuale, serieclub);
    	 
    	int codcollaborazione = 0;
		int codatleti = 0;
		
		AtletiDAOPostgresImpl.inserisciAtleta(atleta, codcollaborazione, codatleti);
		
		//Se tutto va bene
        NuovaCollaborazione.setVisible(true);
     }

    
     
     public void InserisciCollaborazioneDB(String datainizio, String datafine, double stipendiomensile) throws ParseException, SQLException {
    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
  		Date dataInizio = format.parse(datainizio);
  		Date dataFine = format.parse(datafine);
  		
  		Collaborazione collaborazione = new Collaborazione(dataInizio, dataFine, stipendiomensile);
  		
  		int codprocuratori = 0;
  		int codatleti = 0;
  		
  		CollaborazioneDAOPostgresImpl.InserisciCollaborazione(collaborazione, codprocuratori, codatleti);
     }
     
     public void InserisciContrattoClubDB(String datainizio, String datafine, double stipendioatletastagione, String bonusstagione, double guadagnobonus, String vincolicontrattuali ) throws ParseException, SQLException {
    	 SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
    	 Date dataInizio = format.parse(datainizio);
    	 Date dataFine = format.parse(datafine);
    	 
    	 ContrattoClub contrattoclub = new ContrattoClub(dataInizio, dataFine, stipendioatletastagione, bonusstagione, guadagnobonus, vincolicontrattuali);
    	 
    	 int codtransazioneclub = 0;
		 int codatleti = 1;
		
		 
		 ContrattiDAOPostgresImpl.inserisciContrattoClub(contrattoclub, codtransazioneclub, codatleti);
    	 
     }
     
     public void InserisciContrattoSponsorDB(String datainizio, String datafine, double guadagno, double percentualeprocuratore, String tipologiasponsor, String marcasponsor, String vincolicontrattuali) throws ParseException, SQLException {
    	 SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
    	 Date dataInizio = format.parse(datainizio);
    	 Date dataFine = format.parse(datafine);
    	 
    	 ContrattoSponsor contrattosponsor = new ContrattoSponsor(dataInizio, dataFine, guadagno, percentualeprocuratore,  tipologiasponsor, marcasponsor, vincolicontrattuali);
    	 
    	 int codtransazionesponsor = 0;
    	 int codatleti = 0;
    	 
    	 ContrattiDAOPostgresImpl.inserisciContrattoSponsor(contrattosponsor, codtransazionesponsor, codatleti);
     }
     
     
     
    
     
     public void setProcuratoriDAO(ProcuratoriDAOPostgresImpl PD) {
    	 ProcuratoriDAOPostgresImpl = PD;
     }
     
     public ProcuratoriDAOPostgresImpl getProcuratoriDAO() {
    	 return ProcuratoriDAOPostgresImpl; 	  
     }
     

	public static void main(String[] args) throws SQLException, ParseException 
	{
	//	ProcuratoriDAOPostgresImpl procuratoriDAOpostgresImpl; 

		try {
 			Connection conn= null;
 			DBConnection dbc = DBConnection.getInstance();
 			conn = dbc.getConnection();
 			
 			ProcuratoriDAOPostgresImpl  procuratoriDAOpostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
 		    
 			Controller controller = new Controller(conn);
 			
 			controller.setProcuratoriDAO(procuratoriDAOpostgresImpl);
 			
 			}catch (SQLException e) {
 				e.printStackTrace();
 				System.out.println ("errore�? " + e.getMessage());
 				return;
 			}
    	  
		
 			
		
	   
		
//		
//		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
//		Date parsedate = format.parse("2000-01-01");
//		java.sql.Date sqlDate = new java.sql.Date(parsedate.getTime());
//		
//
//		Procuratori procuratore = new Procuratori("sevio","mast","CF1234569890edfg","9911088189","1234567890","sani@mail.it",parsedate);
//		
//		try {
//			Connection conn= null;
//			DBConnection dbc = DBConnection.getInstance();
//			conn = dbc.getConnection();
//			
////			ProcuratoriDAOPostgresImpl procuaratoriDAOPostgresImpl  = new ProcuratoriDAOPostgresImpl(conn);
//			ProcuratoriDAOPostgresImpl procuratoriDAOPostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
//			
//			procuratoriDAOPostgresImpl.InserisciProcuratore(procuratore);
//			
//			}catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println ("errore�? " + e.getMessage());
//				return;
//			}
		
		
		
	}
}