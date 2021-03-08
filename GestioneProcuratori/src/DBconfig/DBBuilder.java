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
                                + "(CodProcuratore CHAR(4) not NULL, "
                    		    + " Nome VARCHAR(20) not NULL, "
                                + " Cognome VARCHAR(20) not NULL, "
                    		    + " CodiceFiscale CHAR(16), "
                                + " NumeroTelefonico CHAR(10), "
                    		    + " NumeroTelefonico2 CHAR(10), "
                                + " Email VARCHAR(20) not NULL, "
                    		    + " DataN DATE, "
                                + " CONSTRAINT pkprocuratore PRIMARY KEY(CodProcuratore), "
                    		    + " CONSTRAINT uqprocuratore UNIQUE (CodiceFiscale), "
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

                if (!tableExists("esame")) {
                    String sql = "CREATE TABLE esame " +
                            "(cod_esame VARCHAR(9) not NULL, " +
                            " denominazione VARCHAR(255), " +
                            " docente VARCHAR(255), " +
                            " cfu int, " +
                            " PRIMARY KEY ( cod_esame ), " +
                            " CONSTRAINT  fk_docente " +
                            " FOREIGN KEY(docente) " +
                            " REFERENCES docente(cf));";

                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table esame already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table esame: "+ex);
            }
        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }

    public int createTableDocente() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("docente")) {
                    String sql = "CREATE TABLE docente " +
                            "(cf VARCHAR(16) not NULL, " +
                            " nome VARCHAR(255), " +
                            " cognome VARCHAR(255), " +
                            " email VARCHAR(255), " +
                            " PRIMARY KEY ( cf ));";

                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table docente already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table docente: "+ex);
            }

        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }
}

