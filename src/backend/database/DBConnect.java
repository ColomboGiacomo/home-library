package backend.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import utils.ResourcesAccessUtils;

/*
 * Classe per la richiesta della connessione al DB da parte dei dao. Nel dao, quando vado a chiamare getConnection()
 * faccio una richiesta del tipo "è già a perta una connessione?" se si allora ritorno connection, altrimenti
 * faccio il load properties e la apro.
 * Quando invece chiamo closeConnection(), chiudo la connessione.
 */

public class DBConnect {
	
	private static final String PROPERTIES_PATH = "config/database.properties";
	private static Connection connection;
	
    public static Connection getConnection() throws SQLException, IOException {
    	
    	if(connection == null || connection.isClosed()) {
            Properties properties = ResourcesAccessUtils.loadProperties(PROPERTIES_PATH);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, user, password);
    	}

        return connection;
    }
	
    public static void closeConnection() throws SQLException {
    	
    	if(connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
    	}
    }

	
}
