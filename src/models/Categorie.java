package models;

import connection.ConnectionDB;
import uiApplication.produit.UI_pan_Liste_Produit;

public class Categorie {
	private int id;
	private String nom_categorie;
	
	public Categorie() {}
//	methode pour ajouter des produits dans la table produit
	public boolean ajoutCategorie(String nom_categorie) {
		String requete = "INSERT INTO categorie(nom_categorie)VALUES (?)";
		boolean est_ajoute = false;
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
         
	        insert.setString(1,nom_categorie);
	        insert.executeUpdate();
	        est_ajoute = true;	        
//            afficheListe(UI_pan_Liste_Produit.getTable(),"");
		} catch (Exception e) {
			est_ajoute = false;
			e.printStackTrace();
		}
		return est_ajoute;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_categorie() {
		return nom_categorie;
	}
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
}
