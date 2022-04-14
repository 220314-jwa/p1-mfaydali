package dev.mfaydali.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

// a factory is responsible for generating an object and returning it
// singleton is a design pattern where we only create one instance of a class, saves memory so we're not re-instantiating it every time
//a factory is responsible for generating an object and returning it
//singleton is a design pattern where we only create one instance of a class, saves memory so we're not re-instantiating it every time
public class ConnectionFactory {

	// private - only this class can directly access
	// static - it belongs to the class, rather than a specific instance (singleton
	// design pattern)
	private static Connection connection = null;
	private static Properties properties;

	// return our connection to the database:
	public static Connection getConnection() {
		// if no connection yet:
		if (connection == null) {
			// set up credentials (url, username, password)
			// pull these from dbConfig file:
			ResourceBundle bundle = ResourceBundle.getBundle("dbConfig.properties");
			String url = bundle.getString("url");
			String username = bundle.getString("postgres");
			String password = bundle.getString("12345");

			// try connecting to the database:
			try {
				// get connection
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// if something goes wrong, view the stack trace
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		ConnectionFactory.properties = properties;
	}
}
