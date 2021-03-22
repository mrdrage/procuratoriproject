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
import entita.GettoneNazionale;
import entita.Procuratori;



public class Controller {
	
          //Daos usate
	      ProcuratoriDAOPostgresImpl ProcuratoriDAOPostgresImpl;
	      CollaborazioneDAOPostgresImpl CollaborazioneDAOPostgresImpl;
	      AtletiDAOPostgresImpl AtletiDAOPostgresImpl;
	      ContrattiDAOPostgresImpl ContrattiDAOPostgresImpl;
	      
	      //Finestre procuratori
	      M_Benvenuto benvenuto; 
	      M_GestioneProcuratore GestioneProcuratore;
	      M_NuovoProcuratore nuovoProcuratore;
	      M_ProcuratoreInseritoOk procuratoreInseritoOK;
	      M_CercaProcuratore CercaProcuratore;
	      M_DettagliAtleta DettagliAtleta;
	      M_ErroreDatabase erroreDatabase;
	      M_VisualizzaIntroitiProcuratore visualizzaIntroitiProcuratore;
	      
	      //Finestre collaborazioni
	      M_NuovoAtletaCollab NuovoAtletaCollab;
	      M_NuovaCollaborazione nuovaCollaborazione;
	      M_ListaCollaborazioni ListaCollaborazioni;
	      
	      //Finestre contratti
	      M_AggiungiContrattoClub AggiungiContrattoClub;
	      M_AggiungiContrattoSponsor AggiungiContrattoSponsor;
	      M_ContrattoClubEsistente ContrattoClubEsistente;
	      M_ContrattoClubInserito contrattoClubInserito;
	      M_ContrattoSponsorInserito ContrattoSponsorInserito;
	      M_SelezionaAtletaContratto SelezionaAtletaContratto;
	      M_VisualizzaContrattiAtleta VisualizzaContrattiAtleta;
	      M_ErroreDataClub erroreDataClub;
	      M_ListaIntroitiProcuratore ListaIntroitiProcuratore;
	      
	      //Finestre atleti
	      M_CercaAtletaDettagli CercaAtletaDettagli;
	      M_GestioneGettoneNazionale GestioneGettoneNazionale;
	      
	     
	      
		  
	      //Codice del procuratore selezionato dall'utente in precedenza 
	      public int codprocuratori;
	      public int codatleti;
	    

	      
   

	

	public Controller () throws SQLException {

     
    	 
    	  //Avvio dell'app
	      benvenuto = new M_Benvenuto(this);
	      benvenuto.setVisible(true);
	      
	      //Finestre Procuratori
	      GestioneProcuratore = new M_GestioneProcuratore(this);
	      nuovoProcuratore = new M_NuovoProcuratore(this);
	      procuratoreInseritoOK = new M_ProcuratoreInseritoOk(this);
	      CercaProcuratore = new M_CercaProcuratore(this);
	      erroreDatabase = new M_ErroreDatabase(this);
	      visualizzaIntroitiProcuratore = new M_VisualizzaIntroitiProcuratore(this);
	    
	      //Finestre Atleti
	      CercaAtletaDettagli = new M_CercaAtletaDettagli(this);
	      DettagliAtleta = new M_DettagliAtleta(this);
	      NuovoAtletaCollab = new M_NuovoAtletaCollab(this);
	      CercaAtletaDettagli = new M_CercaAtletaDettagli(this);
	      ListaCollaborazioni = new M_ListaCollaborazioni(this);
	      
	      GestioneGettoneNazionale = new M_GestioneGettoneNazionale(this);
	      
	      //Finestre Collaborazioni
	      nuovaCollaborazione = new M_NuovaCollaborazione(this);
	      
	      //Finestre Contratti
	      AggiungiContrattoClub = new M_AggiungiContrattoClub(this);
	      AggiungiContrattoSponsor = new M_AggiungiContrattoSponsor(this);
	      ContrattoClubEsistente = new M_ContrattoClubEsistente(this);
	      contrattoClubInserito = new M_ContrattoClubInserito(this);
	      ContrattoSponsorInserito = new M_ContrattoSponsorInserito(this);
	      SelezionaAtletaContratto = new M_SelezionaAtletaContratto(this);
	      VisualizzaContrattiAtleta = new M_VisualizzaContrattiAtleta(this);
	      erroreDataClub = new M_ErroreDataClub(this);
	      ListaIntroitiProcuratore = new M_ListaIntroitiProcuratore(this);
     }
     
	 /**
  	 * JDIALOGS 
  	 */
	
    
     
     public void ContrattoClubInseritoCorrettamente() {
    	 contrattoClubInserito.setVisible(true);
     }
     
     public void ContrattoSponsorInseritoCorrettamente() {
    	 ContrattoSponsorInserito.setVisible(true);
     }
     
     public void ErroreInserimentoDatabase() {
    	 erroreDatabase.setVisible(true);
     }
     
     public void ProcuratoreInseritoCorrettamente() {
    	 procuratoreInseritoOK.setVisible(true);
    	 nuovoProcuratore.setVisible(false);
     }
     
     public void ErroreInserimentoDataContratto() {
    	 erroreDataClub.setVisible(true);
     }
     
     
    
     
     /**
  	 * METODI PROCURATORI
  	 */
     
     public void IniziaInserimentoProcuratore () {
    	 
    	 benvenuto.setVisible(false);
    	 nuovoProcuratore.setVisible(true);
    	 
     }
     
     public void TornaAGestioneProcuratore() {
    	 
    	 ListaCollaborazioni.setVisible(false);
    	
    	 //pulisco la lista 
    	 ListaCollaborazioni.clearListCollaborazioni();
    	 
    	 GestioneProcuratore.setVisible(true);
    	 
     }
     
     public void TornaAllaHome() {
    	 benvenuto.setVisible(true);
     }
      
     public void InserisciProcuratoreDB (String nome, String cognome, String CF, String Ntel, String Ntel2, String email, String dataN) throws SQLException, ParseException {
    	
    	//Conversione da String a Date della dataN
    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
 		Date parsedate = format.parse(dataN);
    	 
        Procuratori procuratore = new Procuratori(nome, cognome, CF, Ntel, Ntel2, email, parsedate);
    	 
        ProcuratoriDAOPostgresImpl.InserisciProcuratore(procuratore);
        
        //Se tutto va bene
      
        
      
     }
     

     public void RicercaProcuratori () throws SQLException {
    	 
    	 benvenuto.setVisible(false);
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
  	 * METODI GUADAGNI
  	 */
     
     public void TornaGestioneProcuratore() {
    	 
    	 ListaIntroitiProcuratore.setVisible(false);
    	 //pulisco la lista
    	 ListaIntroitiProcuratore.clearListIntroiti();
    	 
    	 GestioneProcuratore.setVisible(true);
     }

     public double CalcolaGuadagniCollaborazioneProcuratore(int codprocuratori) throws SQLException {
    	
    	// Prendo lo stipendio mensile
    	 double StipendioMensile = ProcuratoriDAOPostgresImpl.getStipendioMensileProcuratore(getCodprocuratori());
    	 // Prendo i mesi della collaborazione
    	 long mesiCollab = CollaborazioneDAOPostgresImpl.getMesiCollaborazione(getCodatleti());
    	 // Calcolo il guadagno finale della collaborazione
    	 double GuadagnoFinale = StipendioMensile * mesiCollab;
    	 
    	 return GuadagnoFinale;
    	
     }
  
 


  

     public double CalcolaGuadagniSponsorProcuratore(int codprocuratori) throws SQLException {
	   
    	 //Prendo i guadagni sponsor  
    	 double GuadagnoFinaleSponsor = ProcuratoriDAOPostgresImpl.getGuadagnoSponsorProcuratore(getCodatleti());
	  
    	 return GuadagnoFinaleSponsor;
  }
 
  
 
     public void VisualizzaIntroitiProcuratore(String InfoAtleta) throws SQLException {
	  
	  
    	 double GuadagnoCollaborazione = 0;	  
    	 double GuadagnoSponsor = 0;	  
    	 double Totale = 0;
	  	 
    	 VisualizzaContrattiAtleta.setVisible(false);	  
	  
    	 String CfAtleta = InfoAtleta;
 	 
 	
    	 //Split della stringa 	 
    	 String[] cfs = CfAtleta.split(" "); 	  
    	 String CfAtletaSplit = cfs[2] ;
 	 
 	
 	 
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));
 	 
    	 GuadagnoCollaborazione = CalcolaGuadagniCollaborazioneProcuratore(getCodprocuratori());	
    	 GuadagnoSponsor = CalcolaGuadagniSponsorProcuratore(getCodprocuratori());	 
    	 Totale = GuadagnoCollaborazione + GuadagnoSponsor;

    	 visualizzaIntroitiProcuratore.inserisciCampi(ProcuratoriDAOPostgresImpl.getProcuratoriByID(getCodprocuratori()), GuadagnoCollaborazione, GuadagnoSponsor, Totale);
 	  
    	 visualizzaIntroitiProcuratore.setVisible(true);
 	
  }
  
  
  
     public void CalcolaListaIntroitiProcuratore() throws SQLException {
	  
	  
    	 GestioneProcuratore.setVisible(false);  
	  
    	 double GuadagnoCollaborazione = 0;	  
    	 double GuadagnoSponsor = 0;	  
    	 double Totale = 0;	  
    	 Atleti atleta = new Atleti();	  
	 
    	 List<String> listaResoconto = new ArrayList<String>();  
    	 List<Integer> listaCollaborazioni;
	  	 
    	 //Prendiamo una lista di collaborazioni in base al codprocuratore	 
    	 listaCollaborazioni = CollaborazioneDAOPostgresImpl.getIDCollaborazioniByProcuratore(getCodprocuratori());
	  
	 
    	 // Dalla lista di collaborazioni, ci ricaviamo i codatleti singolarmente	 
    	 Iterator<Integer> iCollab = listaCollaborazioni.iterator(); 
    	 while (iCollab.hasNext()) {
		  
    		 //setto l'atleta che ha collaborazione col procuratore selezionato in precedenza, in modo che sia impostato su codatleti locale		 
    		 setCodatleti(AtletiDAOPostgresImpl.getIDAtletiByIDCollaborazione(iCollab.next()));	
		 
    		 // Per ogni codatleta, ci calcoliamo guadagni collaborazione, sponsor e totale del procuratore	 
    		 GuadagnoCollaborazione = CalcolaGuadagniCollaborazioneProcuratore(getCodprocuratori());    
    		 GuadagnoSponsor = CalcolaGuadagniSponsorProcuratore(getCodprocuratori());		 
    		 Totale = GuadagnoCollaborazione + GuadagnoSponsor;
		  
		  
		
    		 atleta = AtletiDAOPostgresImpl.getAtletiByID(getCodatleti());		
    		 // Aggiungiamo i risultati ad una lista	   
    		 // Alla fine otteniamo una lista di atleti con i relativi guadagni del procuratore e la passiamo al la jlist		  		 
    		 listaResoconto.add(atleta.getNome()+" "+atleta.getCognome()+" "+ GuadagnoCollaborazione +" "+ GuadagnoSponsor +" "+ Totale);	  
	  
    	 } 
	
    	 ListaIntroitiProcuratore.setListaIntroiti(listaResoconto);
  
    	 ListaIntroitiProcuratore.setVisible(true);

  }
  

     
     
    
     
     /**
 	 * METODI ATLETI
 	 */
  
  
  
     public void TornagestioneProcuratore() {
    	 
    	 CercaAtletaDettagli.setVisible(false);
    	 //ripulisco la combobox
    	 CercaAtletaDettagli.clearAtletiComboBox();
    	 
    	 GestioneProcuratore.setVisible(true);
     }
     
     public void TornaAllaGestioneProcuratore() {
    	 
    	 DettagliAtleta.setVisible(false);
    	 //ripulisco combobox
    	 CercaAtletaDettagli.clearAtletiComboBox();
    	 
    	 GestioneProcuratore.setVisible(true);
     }

     public void TornaASelezionaAtletaContratto() {
	  
    	 VisualizzaContrattiAtleta.setVisible(false);	
    	 
    	 //pulisco le liste dai risultati precedenti	 
    	 VisualizzaContrattiAtleta.clearListContrattiClub();	 
    	 VisualizzaContrattiAtleta.clearListContrattiSponsor();
	 
    	 //apro la selezione atleti	
    	 SelezionaAtletaContratto.setVisible(true);
  }
     
     public void iniziaRicercaDettagliAtleta() throws SQLException {
    	 
    	 GestioneProcuratore.setVisible(false);
    	 
         //Dichiarazioni
    	 List<Integer>listacollaborazioni;
         listacollaborazioni = CollaborazioneDAOPostgresImpl.getIDCollaborazioniByProcuratore(codprocuratori);
         List<Atleti> atleti = new ArrayList<Atleti>();
         List<String> ListaAtleti = new ArrayList<String>();
       
         //Prende gli atleti dalle collaborazioni del procuratore scelto in precedenza   
         Iterator<Integer> iCollab = listacollaborazioni.iterator();
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
     
   
     
     
     
     public void InserisciAtletaDB(String nome, String cognome, String nazione, String codicefiscale, String sport, String clubattuale, String serieclub) throws SQLException {
    	 
        Atleti atleta = new Atleti(nome, cognome, nazione, codicefiscale, sport, clubattuale, serieclub);
    	
		//setto il codice atleta localmente		
    	setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(codicefiscale));
    	
    	//Lo inserisco nel db
		AtletiDAOPostgresImpl.inserisciAtleta(atleta);
		
		//Se tutto va bene
        nuovaCollaborazione.setVisible(true);
        
     }
     
     public void VisualizzaInfoAtleta(String InfoAtleta) throws SQLException {
    	 
    	 CercaAtletaDettagli.setVisible(false);
    	 
    	 Atleti atleta = new Atleti();
    	 String CfAtleta = InfoAtleta;
    	 //Split della stringa
    	 String[] cfs = CfAtleta.split(" ");
    	 String CfAtletaSplit = cfs[2];
    	 
    	 //ottengo l'atleta usando il codice fiscale preso dalla stringa della combobox
    	 atleta = AtletiDAOPostgresImpl.getAtletaByCf(CfAtletaSplit);
    	 
    	 //setto l'atleta selezionato
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));
    	 //setto l'atleta nei textfield
    	 DettagliAtleta.setAtleta(atleta);
    	 //visualizzo la finestra successiva
    	 DettagliAtleta.setVisible(true);
    	 
 	}

     
     public void VisualizzaGettoniNazionale() throws SQLException {
    	 
    	 DettagliAtleta.setVisible(false);
    	 
    	 List<String> gettoni = new ArrayList<String>();
    	 List<GettoneNazionale> gettoniN;
    	 gettoniN = AtletiDAOPostgresImpl.getGettoniNazionali(getCodatleti());
    	 
    	 Iterator<GettoneNazionale> iG = gettoniN.iterator();
    	 while (iG.hasNext()) {
    		 GettoneNazionale g = iG.next();
    		 //convertire date e double in string
    		 gettoni.add(g.getData()+" "+g.getGudagno());
    		 //!!
    	 }
    	
    	 //popolo la Jlist dei gettoni
    	 GestioneGettoneNazionale.setListaGettoniNazionale(gettoni);
    	 
    	 //visualizzo la finestra
    	 GestioneGettoneNazionale.setVisible(true);
     }
     
     public void TornaADettagliAtleta() {
    	 
    	 GestioneGettoneNazionale.setVisible(false);
    	 //pulisco la lista
    	 GestioneGettoneNazionale.clearListGettoniNazionale();
    	 
    	 DettagliAtleta.setVisible(true);
    	 
     }
    
     
     /**
 	 * METODI COLLABORAZIONI
 	 */
     
//     public void iniziaInserimentoCollaborazione() {
//    	 nuovaCollaborazione.setVisible(true);
//     }
     
     public void TornaAlistaCollaborazioni() {
    
    	 nuovaCollaborazione.setVisible(false);
    	 //pulisco la combobox
    	 nuovaCollaborazione.clearAtletiLiberiComboBox();
    	 
    	 ListaCollaborazioni.setVisible(true);
     }
     
     public void TornaAListaCollaborazioni() {
    	 
    	 NuovoAtletaCollab.setVisible(false);
    	 
    	 ListaCollaborazioni.setVisible(true);
    	 
     }
     
     public void tornaAllaListaCollaborazioni () {
    	 ListaCollaborazioni.setVisible(true);
     }
     
     public void prova() throws SQLException {
    	 
    	 System.out.println(CollaborazioneDAOPostgresImpl.getMesiCollaborazione(1));
     }
       
     public void InserisciCollaborazione(String datainizio, String datafine, double stipendiomensile, String InfoAtleta) throws ParseException, SQLException {
    	
    	 String CfAtleta = InfoAtleta;
    	 //Split della stringa
    	 String[] cfs = CfAtleta.split(" ");
    	 String CfAtletaSplit = cfs[2];
    	 
    	 //setto l'atleta selezionato dalla combo box
    	 setCodatleti(AtletiDAOPostgresImpl.getIdAtletaByCf(CfAtletaSplit));
    	 
    	 //richiamo il metodo per inseriro sul db
    	int CodiceCollaborazione; 
    	 
     	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
   		Date dataInizio = format.parse(datainizio);
   		Date dataFine = format.parse(datafine);
   		
   		Collaborazione collaborazione = new Collaborazione(dataInizio, dataFine, stipendiomensile);
   		
   		
   		//Gli passo il codice atleta ed il codice procuratore
   		CollaborazioneDAOPostgresImpl.InserisciCollaborazione(collaborazione,getCodprocuratori(), getCodatleti());
   		//ricavo il codice della collaborazione che sto inserendo
   		CodiceCollaborazione = CollaborazioneDAOPostgresImpl.getCodiceCollaborazione();
   		//e lo setto sull'atleta inserito 
   		AtletiDAOPostgresImpl.setCodCollaborazione(CodiceCollaborazione, getCodatleti());
    	 
    	 
    	 nuovaCollaborazione.setVisible(false);
     }
     
//     public void InserisciCollaborazioneDB(String datainizio, String datafine, double stipendiomensile) throws ParseException, SQLException {
//    	 
//    	int CodiceCollaborazione; 
//    	 
//    	SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
//  		Date dataInizio = format.parse(datainizio);
//  		Date dataFine = format.parse(datafine);
//  		
//  		Collaborazione collaborazione = new Collaborazione(dataInizio, dataFine, stipendiomensile);
//  		
//  		
//  		//Gli passo il codice atleta ed il codice procuratore
//  		CollaborazioneDAOPostgresImpl.InserisciCollaborazione(collaborazione, getCodatleti(), codprocuratori);
//  		//ricavo il codice della collaborazione che sto inserendo
//  		CodiceCollaborazione = CollaborazioneDAOPostgresImpl.getCodiceCollaborazione();
//  		//e lo setto sull'atleta inserito 
//  		AtletiDAOPostgresImpl.setCodCollaborazione(CodiceCollaborazione, getCodatleti());
//  		
//     }
     
   
     

     public void ApriListaCollaborazioni() throws SQLException {
    	
    	 
    	 GestioneProcuratore.setVisible(false);
    	 
    	 //Dichiarazioni
    	 List<Collaborazione> collaborazioni = CollaborazioneDAOPostgresImpl.getAllCollaborazioniByProcuratore(getCodprocuratori());
    	 List<String> listCollaborazioni = new ArrayList<String>();
    	 Iterator<Collaborazione> iC = collaborazioni.iterator();
    	 
    	 while(iC.hasNext()) {
    		 Collaborazione c = iC.next();
    		 listCollaborazioni.add(c.getDataInizio()+"  "+c.getDataFine()+"  "+c.getStipendioMensile());
    		 
    	 }
          
         //setto la jlist 
    	 ListaCollaborazioni.setListaCollaborazioni(listCollaborazioni);
    	
    	 
    	 //visualizzo la jlist
    	 ListaCollaborazioni.setVisible(true);
     }
     
     
     public void aggiungiAtletaCollab() throws SQLException {
    	 
    	 ListaCollaborazioni.setVisible(false);
    	 
    	 //visualizzo la finestra per inserire un atleta
    	 NuovoAtletaCollab.setVisible(true);  
    	 
    	 
     }
     
     public void aggiungiCollaborazione() throws SQLException {
    	 
    	 NuovoAtletaCollab.setVisible(false);
    	 
    	 //dichiarazioni
    	 List<Atleti> listaAtleti;
    	 List<String> InfoAtleti = new ArrayList<String>();
    	 
    	 //ottengo gli atleti senza collaborazioni
    	 listaAtleti = AtletiDAOPostgresImpl.getAtletiLiberi();
    	 
    	 //ricavo le info dagli atleti
    	 Iterator<Atleti> iA = listaAtleti.iterator();
    	 while (iA.hasNext()) {
    		 Atleti a = iA.next();
    		 InfoAtleti.add(a.getNome()+" "+ a.getCognome()+" "+ a.getCodiceFiscale());
    	 }
    	 
    	 //passo le info alla combobox
    	 nuovaCollaborazione.setAtletiLiberiComboBox(InfoAtleti);
    	 
    	 
    	 
    	 //visualizzo la finestra per aggiungere la collaborazione
    	 nuovaCollaborazione.setVisible(true);
     }
     
    
     public void InserisciAtleta (String Nome,String Cognome,String Nazione, String CodiceFiscale,String Sport,String ClubAttuale,String SerieClub) throws SQLException {
    	 
    	  
    	 //aggiungo nel db l'atleta
    	 Atleti atleta = new Atleti(Nome, Cognome, Nazione, CodiceFiscale, Sport, ClubAttuale, SerieClub);
    	 AtletiDAOPostgresImpl.inserisciAtleta(atleta);
    	  
    	 aggiungiCollaborazione();
    	 
    	 
     }
     
     /**
  	 * METODI CONTRATTI
  	 */   
     
     public void tornaAGestioneProcuratore() {
    	 
    	 SelezionaAtletaContratto.setVisible(false);
    	 //pulisco combobox
    	 SelezionaAtletaContratto.clearContrattiComboBox();
    	 
    	 GestioneProcuratore.setVisible(true);
     }
     
   
     public void IniziaInserimentoContrattoClub() {
    	 AggiungiContrattoClub.setVisible(true);
     }
     
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
    		 Cclub.add(c.getDataInizio()+"            "+ c.getDataFine()+"            "+ c.getStipendioAtletaStagione()+"            "+c.getBonusStagione()+"             "+c.getGuadagnoBonus()+"             "+c.getVincoloContrattuale());
    	 }
    	 
    	 //ricavo i contratti sponsor e li metto in lista di stringhe
    	 ContrattiSponsor = ContrattiDAOPostgresImpl.getContrattiSponsorById(getCodatleti());
    	 List<String> CSponsor = new ArrayList<String>();
    	 Iterator<ContrattoSponsor> iS = ContrattiSponsor.iterator();
    	 while (iS.hasNext()) {
    		 ContrattoSponsor c = iS.next();
    		 CSponsor.add(c.getDataInizio()+"             "+ c.getDataFine()+"             "+ c.getGuadagno()+"             "+c.getPercentualeProcuratore()+"             "+c.getTipologiaSponsor()+"             "+c.getMarcaSponsor()+"             "+c.getVincoliContrattuali());
    	 }
    	 
    	 //setto le jlist
    	 VisualizzaContrattiAtleta.setListaContrattiClub(Cclub);  	 
    	 VisualizzaContrattiAtleta.setListaContrattiSponsor(CSponsor);
    	 
    	 //Visualizza la finestra con le info delle jlist
    	 VisualizzaContrattiAtleta.setVisible(true);
     }
     
     
    
     /**
   	 * GETTER & SETTER
   	 */   
     
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