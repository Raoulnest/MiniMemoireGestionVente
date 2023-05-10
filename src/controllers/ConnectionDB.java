package controllers;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static String HOST = "localhost";
	private static int PORT = 3306;
	private static String DB_NAME = "gestion_de_vente";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static java.sql.Connection connection;	
	public static java.sql.Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection(String.format("jdbc:mysql://%s/%s", HOST,DB_NAME),USERNAME,PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			 System.out.print("Probleme de Connection");
			 e.printStackTrace();
//			 Dialogue d = new Dialogue("Probleme de Connection",Color.RED);
//			 d.fermerFenetre(true);
		}
		return connection;
	}
	public static void main(String[] args) {
		getConnect();
	}
}
