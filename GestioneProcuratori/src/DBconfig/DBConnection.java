package DBconfig;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DBConnection
{

	private static DBConnection instance;
	private Connection connection = null;
	private final String USERNAME = "dbproject";
	private final String PASSWORD = "dbprojectadmin";
	private final String IP = "dbprocuratori1.c1r3woxfz75h.us-east-2.rds.amazonaws.com";
	private final String PORT = "5432";
	private String url = "jdbc:postgresql://" + IP + ":" + PORT + "/dbprocuratori";

	private DBConnection() throws SQLException
	{
		
		connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
		if(connection != null) 
		{
			System.out.println("Connected to PostreSQL server successfully!");
		}
		else
			System.out.println("Failed to connect PostreSQL server!");
		

	}

	public Connection getConnection()
	{
		return connection;
	}

	public static DBConnection getInstance() throws SQLException
	{
		if (instance == null)
		{
			instance = new DBConnection();
		}

		else if (instance.getConnection().isClosed())
		{
			instance = new DBConnection();
		}

		return instance;
	}

	
}
