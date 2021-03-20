package Starter;


import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
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
	      M_Benvenuto Benvenuto; 
	      M_GestioneProcuratore GestioneProcuratore;
	      M_NuovoProcuratore NuovoProcuratore;
	      M_ProcuratoreInseritoOk ProcuratoreInseritoOK;
	      M_CercaProcuratore CercaProcuratore;
	      M_DettagliAtleta DettagliAtleta;
	      
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
	      M_SelezionaAtletaContratto SelezionaAtletaContratto;
	      M_VisualizzaContrattiAtleta VisualizzaContrattiAtleta;
	      
	      //Finestre atleti
	      M_CercaAtletaDettagli CercaAtletaDettagli;
	      
		  
	      //Codice del procuratore selezionato dall'utente in precedenza 
	      public int codprocuratori;
	      public int codatleti;
	    

	      
   

	

	public Controller () throws SQLException {

     
    	 
    	  //Avvio dell'app
	      Benvenuto = new M_Benvenuto(this);
	      Benvenuto.setVisible(true);
	      
	      //Finestre Procuratori
	      GestioneProcuratore = new M_GestioneProcuratore(this);
	      NuovoProcuratore = new M_NuovoProcuratore(this);
	      ProcuratoreInseritoOK = new M_ProcuratoreInseritoOk(this);
	      CercaProcuratore = new M_CercaProcuratore(this);
	    
	      //Finestre Atleti
	      CercaAtletaDettagli = new M_CercaAtletaDettagli(this);
	      DettagliAtleta = new M_DettagliAtleta(this);
	      NuovoAtletaCollab = new M_NuovoAtletaCollab(this);
	      CercaAtletaDettagli = new M_CercaAtletaDettagli(this);
	      ListaCollaborazioni = new M_ListaCollaborazioni(this);
	      
	      //Finestre Contratti
	      AggiungiContrattoClub = new M_AggiungiContrattoClub(this);
	      AggiungiContrattoSponsor = new M_AggiungiContrattoSponsor(this);
	      ContrattoClubEsistente = new M_ContrattoClubEsistente(this);
	      ContrattoClubInserito = new M_ContrattoClubInserito(this);
	      ContrattoSponsorInserito = new M_ContrattoSponsorInserito(this);
	      SelezionaAtletaContratto = new M_SelezionaAtletaContratto(this);
	      VisualizzaContrattiAtleta = new M_VisualizzaContrattiAtleta(this);
     }
     
	 /**
  	 * JDIALOGS 
  	 */
	
     public void IniziaInserimentoContrattoClub() {
    	 AggiungiContrattoClub.setVisible(true);
     }
     
     public void ContrattoClubInseritoCorrettamente() {
    	 ContrattoClubInserito.setVisible(true);
     }
     
     public void ContrattoSponsorInseritoCorrettamente() {
    	 ContrattoSponsorInserito.setVisible(true);
     }
     

     
    
     
     /**
  	 * METODI PROCURATORI
  	 */
     
     public void IniziaInserimentoProcuratore () {
    	 
    	 Benvenuto.setVisible(false);
    	 NuovoProcuratore.setVisible(true);
    	 
     }
     
     public void TornaAGestioneProcuratore() {
    	 GestioneProcuratore.setVisible(true);
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
    		        InfoProcuratori.add(p.getCognome()+" "+p.getNome()+" "+p.getCodiceFiscale());
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
    	 
    	 //Split della stringa
    	 String[] cfs = CfProcuratore.split(" ");
    	 String CfProcuratoreSplit = cfs[2] ;
    	
    	 //lo passo al dao ottenendo tutte le info in un oggetto Procuratori grazie alla query
    	 procuratore = ProcuratoriDAOPostgresImpl.getProcuratoreByCf(CfProcuratoreSplit);
    	 
    	 
    	 //setto la scheda del procuratore
    	 GestioneProcuratore.setProcuratore(procuratore);
    	 
    	 //getidprocuratorebycf 
    	 //utilizziamo l id per le collaborazioni
    	 // utilizziamo l id per gli atleti
    	 // utilizziamo l id degli atleti per i contratti
    	 
    
    	 //visualizzio la finestra
    	 GestioneProcuratore.setVisible(true);
    	 //Prendo il codiceprocuratori dal codice fiscale del procuratore
          setCodprocuratori(ProcuratoriDAOPostgresImpl.getIDProcuratoreByCf(CfProcuratoreSplit));
          
          //stampe di prova
          System.out.println(codprocuratori);
    	  System.out.println(CfProcuratoreSplit);

     }
     
     
     
     /**
 	 * METODI ATLETI
 	 */
     
     public void iniziaRicercaDettagliAtleta() throws SQLException {
    	 GestioneProcuratore.setVisible(false);
    	 
         //Dichiarazioni
    	 List<Integer>listacollaborazioni;
         listacollaborazioni = CollaborazioneDAOPostgresImpl.getIDCollaborazioniByProcuratore(codprocuratori);
         List<Atleti> atleti = new ArrayList<Atleti>();
         List<String> ListaAtleti = new ArrayList<String>();
      
        
         

         //Prende gli atleti dalle collaborazioni del procuratore scelto in precedenza   
         Iterator<Integer> iCollab= listacollaborazioni.iterator();
             while(iCollab.hasNext()) {
    		 atleti.add(AtletiDAOPostgresImpl.getAtletiByIDCollaborazione(iCollab.next()));
    		 
    	 }
    	 
    	 //Prende le info degli atleti in stringhe da passare alla finestra CercaAtletiDettagli 
    	 Iterator<Atleti> iAtleti = atleti.iterator();
    	 while (iAtleti.hasNext()) {
    		 Atleti a = iAtleti.next();
    		 ListaAtleti.add(a.getNome()+" "+a.getCognome()+" "+a.getCodiceFiscale());
    	 }
    	 //Setto la combo box
    	 CercaAtletaDettagli.setAtletiComboBox(ListaAtleti);
    	 
    	 //Visualizzo la finestra
    	 CercaAtletaDettagli.setVisible(true);
     }
     
     public void CalcolaGuadagniProcuratore(int codprocuratori) {
    	
    	 
    	 
    	 // Mi prendo lo stipendio mensile
    	 // Moltiplico lo stipendio mensile per i mesi di collaborazione
    	 // Mi prendo i guadagni sponsor
    	 // Faccio il totale
     }
     
     
     
     
     public void InserisciAtletaDB(String nome, String cognome, String nazione, String codicefiscale, String sport, String clubattuale, String serieclub) throws SQLException {
        Atleti atleta = new Atleti(nome, cognome, nazione, codicefiscale, sport, clubattuale, serieclub);
    	 
    	int codcollaborazione = 0;
		int codatleti = 0;
		
		AtletiDAOPostgresImpl.inserisciAtleta(atleta, codcollaborazione, codatleti);
		
		//Se tutto va bene
        NuovaCollaborazione.setVisible(true);
     }
     
     public void VisualizzaInfoAtleta(String InfoAtleta) throws SQLException {
    	 CercaAtletaDettagli.setVisible(false);
    	 
    	 Atleti atleta = new Atleti();
    	 String CfAtleta = InfoAtleta;
    	 //Split della stringa
    	 String[] cfs = CfAtleta.split(" ");
    	 String CfAtletaSplit = cfs[2] ;
    	 //ottengo l'atleta usando il codice fiscale preso dalla stringa della combobox
    	 atleta = AtletiDAOPostgresImpl.getAtletaByCf(CfAtletaSplit);
    	 
    	 //setto l'atleta selezionato
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));
    	 //setto l'atleta nei textfield
    	 DettagliAtleta.setAtleta(atleta);
    	 //visualizzo la finestra successiva
    	 DettagliAtleta.setVisible(true);
    	 
 	}

    
     /**
 	 * METODI COLLABORAZIONI
 	 */
     
     public void iniziaInserimentoCollaborazione() {
    	 NuovaCollaborazione.setVisible(true);
     }
     
     public void prova() throws SQLException {
    	 
    	 System.out.println(CollaborazioneDAOPostgresImpl.getMesiCollaborazione(1));
     }
     
     public void InserisciCollaborazioneDB(String datainizio, String datafine, double stipendiomensile) throws ParseException, SQLException {
    	 
    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
  		Date dataInizio = format.parse(datainizio);
  		Date dataFine = format.parse(datafine);
  		
  		Collaborazione collaborazione = new Collaborazione(dataInizio, dataFine, stipendiomensile);
  		
  		
  		int codatleti = 0;
  		
  		//Setto il codatleti dalla scelta della combobox  
  		//Gli passo il codice atleta ed il codice procuratore
  		CollaborazioneDAOPostgresImpl.InserisciCollaborazione(collaborazione, codatleti, codprocuratori);
     }
     

     public void ApriListaCollaborazioni() throws SQLException {
    	
    	 
    	 GestioneProcuratore.setVisible(false);
    	 ListaCollaborazioni.setVisible(true);
    	 
    	 //Dichiarazioni

         
              
    	
    	 
    	 //Dobbiamo passargli prima i dati delle collaborazioni del procuratore scelto in precedenza
    	 ListaCollaborazioni.setVisible(true);
     }
     
     /**
  	 * METODI CONTRATTI
  	 */    
     public void InserisciContrattoClubDB(String datainizio, String datafine, double stipendioatletastagione, String bonusstagione, double guadagnobonus, String vincolicontrattuali ) throws ParseException, SQLException {
    	 
    	 SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
    	 Date dataInizio = format.parse(datainizio);
    	 Date dataFine = format.parse(datafine);
    	 
    	 ContrattoClub contrattoclub = new ContrattoClub(dataInizio, dataFine, stipendioatletastagione, bonusstagione, guadagnobonus, vincolicontrattuali);
    	 
    	
		
		 
		 ContrattiDAOPostgresImpl.inserisciContrattoClub(contrattoclub, getCodatleti());
		 
		 AggiungiContrattoClub.setVisible(false);
    	 
     }
     
     public void InserisciContrattoSponsorDB(String datainizio, String datafine, double guadagno, double percentualeprocuratore, String tipologiasponsor, String marcasponsor, String vincolicontrattuali) throws ParseException, SQLException {
    	 
    	 SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
    	 Date dataInizio = format.parse(datainizio);
    	 Date dataFine = format.parse(datafine);
    	 
    	 ContrattoSponsor contrattosponsor = new ContrattoSponsor(dataInizio, dataFine, guadagno, percentualeprocuratore,  tipologiasponsor, marcasponsor, vincolicontrattuali);
    	 
    	 ContrattiDAOPostgresImpl.inserisciContrattoSponsor(contrattosponsor, getCodatleti());
    	 
    	 AggiungiContrattoSponsor.setVisible(false);
    	 
    	 ContrattoClubInseritoCorrettamente();
     }
     
     public void InserisciContrattoClub(String InfoAtleta) throws SQLException {
    	 
    	 //ricavo il codice fiscale dalla stringa selezionata dalla combobox
    	 String CfAtleta = InfoAtleta;
    	 //Split della stringa
    	 String[] cfs = CfAtleta.split(" ");
    	 String CfAtletaSplit = cfs[2];
    	 
    	 //setto il codice atleta selezionato
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));   
    	 
    	 
    	 SelezionaAtletaContratto.setVisible(false);
    	 AggiungiContrattoClub.setVisible(true);
    	 
     }
     
     public void InserisciContrattoSponsor(String InfoAtleta) throws SQLException {
    	 
    	 //ricavo il codice fiscale dalla stringa selezionata dalla combobox
    	 String CfAtleta = InfoAtleta;
    	 //Split della stringa
    	 String[] cfs = CfAtleta.split(" ");
    	 String CfAtletaSplit = cfs[2];
    	 
    	 //setto il codice atleta selezionato
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));   
    	 
    	 SelezionaAtletaContratto.setVisible(false);
    	 AggiungiContrattoSponsor.setVisible(true);
     }
     
     public void VisualizzaInfoContratti() throws SQLException {

         GestioneProcuratore.setVisible(false);
         
         //Dichiarazioni
    	 List<Integer>listacollaborazioni;
         listacollaborazioni = CollaborazioneDAOPostgresImpl.getIDCollaborazioniByProcuratore(codprocuratori);
         List<Atleti> atleti = new ArrayList<Atleti>();
         List<String> ListaAtleti = new ArrayList<String>();
      
        
         //Prende gli atleti dalle collaborazioni del procuratore scelto in precedenza   
         Iterator<Integer> iCollab= listacollaborazioni.iterator();
             while(iCollab.hasNext()) {
    		 atleti.add(AtletiDAOPostgresImpl.getAtletiByIDCollaborazione(iCollab.next()));
    		 
    	 }
    	 
    	 //Prende le info degli atleti in stringhe da passare alla finestra CercaAtletiDettagli 
    	 Iterator<Atleti> iAtleti = atleti.iterator();
    	 while (iAtleti.hasNext()) {
    		 Atleti a = iAtleti.next();
    		 ListaAtleti.add(a.getNome()+" "+a.getCognome()+" "+a.getCodiceFiscale());
    	 }
    	 
    	 //Setto la combo box
    	 SelezionaAtletaContratto.setContrattiComboBox(ListaAtleti);
    	 
    	 //Visualizzo la finestra
    	 SelezionaAtletaContratto.setVisible(true);
     }
     
     public void iniziaRicercaContrattiAtleta(String InfoAtleta) throws SQLException {
    	 
    	 SelezionaAtletaContratto.setVisible(false);
    	 
    	 //Dichiarazioni
    	 List <ContrattoClub> ContrattiClub;
    	 List <ContrattoSponsor> ContrattiSponsor;
    	 
    	 //ricavo il codice fiscale dalla stringa selezionata dalla combobox
    	 String CfAtleta = InfoAtleta;
    	 //Split della stringa
    	 String[] cfs = CfAtleta.split(" ");
    	 String CfAtletaSplit = cfs[2];
    	 
    	 //setto il codice atleta selezionato
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));    
    	 
    	 //ricavo i contratti club e li metto in lista di stringhe
    	 ContrattiClub = ContrattiDAOPostgresImpl.getContrattiClubById(getCodatleti());
    	 List<String> Cclub = new ArrayList<String>();
    	 Iterator<ContrattoClub> iC = ContrattiClub.iterator();
    	 while (iC.hasNext()) {
    		 ContrattoClub c = iC.next();
    		 Cclub.add(c.getDataInizio()+" "+ c.getDataFine()+" "+ c.getStipendioAtletaStagione()+" "+c.getBonusStagione()+" "+c.getGuadagnoBonus()+" "+c.getVincoloContrattuale());
    	 }
    	 
    	 //ricavo i contratti sponsor e li metto in lista di stringhe
    	 ContrattiSponsor = ContrattiDAOPostgresImpl.getContrattiSponsorById(getCodatleti());
    	 List<String> CSponsor = new ArrayList<String>();
    	 Iterator<ContrattoSponsor> iS = ContrattiSponsor.iterator();
    	 while (iS.hasNext()) {
    		 ContrattoSponsor c = iS.next();
    		 CSponsor.add(c.getDataInizio()+" "+ c.getDataFine()+" "+ c.getGuadagno()+" "+c.getPercentualeProcuratore()+" "+c.getTipologiaSponsor()+" "+c.getMarcaSponsor()+" "+c.getVincoliContrattuali());
    	 }
    	 
    	 //setto le jlist
    	 VisualizzaContrattiAtleta.setListaContrattiClub(Cclub);
    	 
    	 //VisualizzaContrattiAtleta.setListaContrattiSponsor(CSponsor);
    	 
    	 //Visualizza la finestra con le info delle jlist
    	 VisualizzaContrattiAtleta.setVisible(true);
     }
     
     //Getter & Setter
     
     public CollaborazioneDAOPostgresImpl getCollaborazioneDAOPostgresImpl() {
			return CollaborazioneDAOPostgresImpl;
		}


		public void setCollaborazioneDAOPostgresImpl(CollaborazioneDAOPostgresImpl collaborazioneDAOPostgresImpl) {
			CollaborazioneDAOPostgresImpl = collaborazioneDAOPostgresImpl;
		}


		public AtletiDAOPostgresImpl getAtletiDAOPostgresImpl() {
			return AtletiDAOPostgresImpl;
		}


		public void setAtletiDAOPostgresImpl(AtletiDAOPostgresImpl atletiDAOPostgresImpl) {
			AtletiDAOPostgresImpl = atletiDAOPostgresImpl;
		}


		public ContrattiDAOPostgresImpl getContrattiDAOPostgresImpl() {
			return ContrattiDAOPostgresImpl;
		}


		public void setContrattiDAOPostgresImpl(ContrattiDAOPostgresImpl contrattiDAOPostgresImpl) {
			ContrattiDAOPostgresImpl = contrattiDAOPostgresImpl;
		}

     
		public void setProcuratoriDAO(ProcuratoriDAOPostgresImpl PD) {   	 
			ProcuratoriDAOPostgresImpl = PD;
		}
     
    
		public ProcuratoriDAOPostgresImpl getProcuratoriDAO() {	 
			return ProcuratoriDAOPostgresImpl; 	      
		}
     
     
		public int getCodprocuratori() {			
			return codprocuratori;		
		}

	 
		public void setCodprocuratori(int codprocuratori) {			
			this.codprocuratori = codprocuratori;		
		}

	
		public int getCodatleti() {
			return codatleti;
		}

		public void setCodatleti(int codatleti) {
			this.codatleti = codatleti;
		}
		
		

	public static void main(String[] args) throws SQLException, ParseException 
	{
	//	ProcuratoriDAOPostgresImpl procuratoriDAOpostgresImpl; 
		
		

		try {
 			Connection conn= null;
 			DBConnection dbc = DBConnection.getInstance();
 			conn = dbc.getConnection();
 			
 			ProcuratoriDAOPostgresImpl  procuratoriDAOpostgresImpl = new ProcuratoriDAOPostgresImpl(conn);
 			CollaborazioneDAOPostgresImpl collaborazioneDAOPostgresImpl = new CollaborazioneDAOPostgresImpl(conn);
 			AtletiDAOPostgresImpl atletiDAOPostgresImpl = new AtletiDAOPostgresImpl(conn);
 			ContrattiDAOPostgresImpl contrattiDAOPostgresImpl = new ContrattiDAOPostgresImpl(conn);
 			
 			Controller controller = new Controller();
 			
 			controller.setCollaborazioneDAOPostgresImpl(collaborazioneDAOPostgresImpl);
 			controller.setProcuratoriDAO(procuratoriDAOpostgresImpl);
 			controller.setAtletiDAOPostgresImpl(atletiDAOPostgresImpl); 
 			controller.setContrattiDAOPostgresImpl(contrattiDAOPostgresImpl);
 			
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