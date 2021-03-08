package DBconfig;

import exceptions.ConnectionException;
import java.sql.*;

public class DBBuilder
{
    private Connection connection;

    
    
    public DBBuilder(Connection connection)
    {
        this.connection = connection;
    }

    
    
    public DBBuilder()
    {
        connection = null;
    }

    private boolean connectionExists() {
        return !(connection == null);
    }

    
    
    private boolean tableExists(String tbl_name) throws SQLException
    {
        DatabaseMetaData metadata = connection.getMetaData();
        ResultSet tables = metadata.getTables(null, null, tbl_name, null);
        if (tables.next())
            return true;
        return false;

    }

    public int createTableProcuratori() throws ConnectionException
    {
        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("procuratori")) {
                    String sql = "CREATE TABLE procuratori "
                                + "(Nome VARCHAR(20) not NULL, "
                                + " Cognome VARCHAR(20) not NULL, "
                    		    + " CodiceFiscale CHAR(16), "
                                + " NumeroTelefonico CHAR(10), "
                    		    + " NumeroTelefonico2 CHAR(10), "
                                + " Email VARCHAR(20) not NULL, "
                    		    + " DataN DATE, "
                                + " CodProcuratore int not NULL, "
                                + " CONSTRAINT pkprocuratore PRIMARY KEY(CodProcuratore), "
                    		    + " CONSTRAINT uqprocuratore UNIQUE (CodiceFiscale) "
                                + ");";
                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table procuratori already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table procuratori: "+ex);
            }
        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }

    public int createTableAtleti() throws ConnectionException
    {

        int result = -1;
        

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("atleti")) {
                    String sql = "CREATE TABLE atleti "
                                
                    		    +  " (Nome VARCHAR(20) not NULL, "
                                +  " Cognome VARCHAR(20) not NULL, "
                    		    +  " Nazione VARCHAR(20) not NULL, "
                                +  " CodiceFiscale CHAR(16) not NULL, "
                    		    +  " Sport VARCHAR(20) not NULL,  "
                                +  " ClubAttuale VARCHAR(20) not NULL,  "
                    		    +  " SerieClub VARCHAR(20) not NULL, "
                                +  " CodCollaborazione int, "
                    		    +  " CodAtleti int, "
                                +  " CONSTRAINT pkatleti PRIMARY KEY(CodAtleta), "
                    		    +  " CONSTRAINT uqatleti UNIQUE (CodiceFiscale) "
                                +  ");";

                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table atleti already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table atleti: "+ex);
            }
        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }
    
    public int createTableCollaborazione() throws ConnectionException{
    	
    	int result = -1;
         

         if(connectionExists())
         {
             try {
                 Statement st = connection.createStatement();

                 if (!tableExists("collaborazione")) {
                     String sql = "CREATE TABLE collaborazione "
                    		       + "DataInizio DATE not NULL, "
                    		       + "DataFine DATE not NULL, "
                    		       + "StipendioMensileProcuratore Float not NULL, "
                    		       + "CodCollaborazione int, "
                    		       + "CodAtleti int not NULL, "
                    		       + "CodProcuratori int not NULL, "
                    		       + "CONSTRAINT pkcollab PRIMARY KEY (CodCollaborazione), "
                    		       + "CONSTRAINT fkcollab1 FOREIGN KEY (CodProcuratori) REFERENCES PROCURATORI (CodProcuratori), "
                    		       + "CONSTRAINT fkcollab2 FOREIGN KEY (CodAtleti) REFERENCES ATLETI (CodAtleti) "
                    		       + ");";
                     
                     result = st.executeUpdate(sql);
                     st.close();

                 } else
                     System.out.println("Table collaborazione already exists!");
             }
             catch(SQLException ex)
             {
                 System.out.println("SQL Exception in creation table collaborazione: "+ex);
             }
         }
         else
             throw new ConnectionException("A connection must exist!");

         return result;
     }

    public int createTableContrattoClub() throws ConnectionException{

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("contrattoclub")) {
                    String sql = "CREATE TABLE contrattoclub "
                                    + "(DataInizio DATE not NULL, "
                    		        + " DataFine DATE not NULL, "
                                    + "StipendioAtleta Float not NULL, "
                    		        + " BonusStagione VARCHAR(200), "
                                    + " GuadagnoBonus Float, "
                    		        + " VincoloContrattuale VARCHAR(200), "
                                    + " CodTransazioneClub int, "
                    		        + " CodAtleti int not NULL, "
                                    + " CONSTRAINT pkclub PRIMARY KEY (CodTransazioneClub), "
                    		        + " CONSTRAINT fkclub FOREIGN KEY (CodAtleti) REFERENCES ATLETI (CodAtleti) "
                                    + " );";
                    
                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table contrattoclub already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table contrattoclub: "+ex);
            }

        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }


    public int createTableContrattoSponsor() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("contrattosponsor")) {
                    String sql = "CREATE TABLE contrattosponsor "
                                    + "(DataInizio DATE not NULL, "
                    		        + " DataFine DATE not NULL, "
                                    + " GuadagnoAtleta Float not NULL, "
                    		        + " TipologiaSponsor VARCHAR(40), "
                                    + " MarcaSponsor VARCHAR(40) not NULL, "
                                    + " VincoliContrattuali VARCHAR(200) not NULL,"
                                    + " CodTransazioneSponsor int,"
                                    + " CodAtleti int not NULL, "
                                    + " CONSTRAINT pksponsor PRIMARY KEY (CodTransazioneSponsor), "
                                    + " CONSTRAINT fksponsor  FOREIGN KEY (CodAtleti) REFERENCES ATLETI (CodAtleti) "
                                    + " );";
                    
                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table contrattosponsor already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table contrattosponsor: "+ex);
            }

        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }

    public int createTableGettoneNazionale() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("gettonenazionale")) {
                    String sql = "CREATE TABLE gettonenazionale "
                                    + "(Data DATE not NULL, "
                    		        + " Presenza boolean not NULL, "
                    		        + " Guadagno Float not NULL, "
                    		        + " CodAtleti int, "
                    		        + " CONSTRAINT pkgettone PRIMARY KEY (CodAtleti, Data), "
                    		        + " CONSTRAINT fkgettone FOREIGN KEY (CodAtleti) REFERENCES ATLETI (CodAtleti) "
                    		        + ");"; 
                    
                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table gettonenazionale already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table gettonenazionale: "+ex);
            }

        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }

    public int createTablenazionale() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("nazionale")) {
                    String sql = "CREATE TABLE nazionale "
                                    + "(Data DATE not NULL, "
                                    + "CodAtleti int not NULL, "
                                    + "CONSTRAINT fknazionale1 FOREIGN KEY (CodAtleti) REFERENCES ATLETI (CodAtleti), "
                                    + "CONSTRAINT fknazionale2 FOREIGN KEY (Date) REFERENCES GETTONENAZIONALE(Date)"
                    		        + " );";
                    
                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table nazionale already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table nazionale: "+ex);
            }

        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }
    
    
}




