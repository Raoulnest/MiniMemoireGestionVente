package connection;

import java.sql.SQLException;

import models.LigneCommande;

public class Test {

	public static void main(String[] args) {
		try {
			System.out.println("Test : "+LigneCommande.getPrixTotal("COM_01"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
