package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static String HOST = "localhost";
	private static int PORT = 3306;
	private static String DB_NAME = "g-stocks";
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
	static int[] tab = {0,3,4,6,67,9,455};
	public int tabMin(int tab[]) {
		int min = 0;
		for(int i = 1 ; i <= tab.length-1 ; i++) {
			if(tab[i] < min) {
				min = tab[i];
			}
		}
		return min;
	}
	public int tabMax(int tab[]) {
		int max = 0;
		for(int i = 1 ; i <= tab.length-1 ; i++) {
			if(tab[i] > max) {
				max = tab[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		getConnect();
		ConnectionDB c = new  ConnectionDB();
		System.out.println();
		System.out.println("Maximum "+c.tabMax(tab));
	}
}
