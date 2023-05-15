package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import models.Stock;
import uiApplication.produit.UI_modifierProduit;
import uiApplication.produit.UI_pan_Liste_Produit;

public class ControlleurProduit {
	private static ResultSet rs;
	private static Statement st;
	private static String sary;
	public ControlleurProduit() {
		
	}
	
//	methode pour ajouter des produits dans la table produit
	public boolean ajoutProduit(String reference, String designation,  int idCategorie,  int idFournisseur, double prixUnitaire, double quantite, String unite, String image) {
		String requete = "INSERT INTO stock(reference, designation, idCategorie, idFournisseur, prixUnitaire, quantite, unite, image)VALUES (?,?,?,?,?,?,?,?)";
		boolean est_ajoute = false;
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
//          
			insert.setString(1,reference);
	        insert.setString(2,designation);
	        insert.setInt(3,idCategorie);
	        insert.setInt(4,idFournisseur);
	        insert.setDouble(5,prixUnitaire);
	        insert.setDouble(6,quantite);
	        insert.setString(7,unite);
	        insert.setString(8, image);
	        
	        insert.executeUpdate();
	        est_ajoute = true;
	        
            afficheListe(UI_pan_Liste_Produit.getTable(),"");
		} catch (Exception e) {
			est_ajoute = false;
			e.printStackTrace();
		}
		return est_ajoute;
	}
	
//	methode pour mettre a jour les produits dans le table produit
	public boolean modifierProduit(String reference, String designation,  int idCategorie,  int idFournisseur, double prixUnitaire, double quantite, String unite, String image) {
		String requete = "UPDATE stock SET designation=?,idCategorie=?,idFournisseur=?,prixUnitaire=?,quantite=?,unite=?,image=? WHERE reference='"+reference+"'";
		boolean est_modifie = false;
		try {
			 java.sql.PreparedStatement modifier = ConnectionDB.getConnect().prepareStatement(requete);
	            
				 modifier.setString(1,designation);
				 modifier.setInt(2,idCategorie);
				 modifier.setInt(3,idFournisseur);
				 modifier.setDouble(4,prixUnitaire);
				 modifier.setDouble(5,quantite);
				 modifier.setString(6,unite);
				 modifier.setString(7, image);
			        
				 modifier.executeUpdate();
				 est_modifie = true;
				 
				 afficheListe(UI_pan_Liste_Produit.getTable(),"");
		} catch (Exception e) {
			est_modifie = false;
			e.printStackTrace();
		}
		return est_modifie;
	}
//	methode pour supprimer les donnees dans la table produit
	public boolean supprimerProduit(String reference, boolean isSelected) {
		String requete = "DELETE FROM stock WHERE reference='"+reference+"'";
		boolean est_sup = false;
		if(isSelected==false) {
			System.out.println("Veuillez selectionner l'element dans ce tableau : ");
		}else {
	        try {
	        	java.sql.PreparedStatement supprimer= (PreparedStatement) ConnectionDB.getConnect().prepareStatement(requete);
	        	supprimer.executeUpdate();
	            System.out.println("L'element qui porte l'identification '"+reference+"' a été supprimé définitivement : ");
	            est_sup = true;
	        } catch (SQLException e) {
	        	est_sup = false;
	            e.printStackTrace();
	        }
		}
		return est_sup;
	}
//	methode pour obtenir la liste des produits
	public ArrayList<Stock> getListeProduit(String recherche) {
		ArrayList<Stock> ListeProduit = new ArrayList<Stock>();
	        String sql = "SELECT * from stock where 1";
	        String sql1 = "SELECT * from stock where reference LIKE '"+recherche+"%' or idCategorie LIKE '"+recherche+"%' or idFournisseur LIKE '"+recherche+"%' or designation LIKE '"+recherche+"%' or unite LIKE '"+recherche+"%'";
	        compteProduit = 0;
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            if(recherche.equals("")) {
	            	 rs = (ResultSet) st.executeQuery(sql);
	            }else {
	            	 rs = (ResultSet) st.executeQuery(sql1);
	            }
	            while(rs.next()){
	            	ListeProduit.add(new Stock(rs.getString("reference"), rs.getString("designation"), rs.getInt("idCategorie"), rs.getInt("idFournisseur"), rs.getDouble("prixUnitaire"), rs.getDouble("quantite"), rs.getString("unite"), rs.getString("image")));
	            	compteProduit++;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(UI_pan_Liste_Produit.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return ListeProduit;
	}
//	affiche tableau de produit
	private String [] colonne = {" REFERENCES "," DESIGNATIONS ",
			" CATEGORIE "," FOURNISSEUR ","  PRIX UNITAIRE ", " QUANTITES "," UNITES ", "Images"};
	private Object [] liste = new Object[8];
	DefaultTableModel tableParDefaut;
	private static String reference;
	private static boolean elt_select = false;
	private static int compteProduit;
	
	public void afficheListe(JTable table,String recherche) 
	{	
			ArrayList<Stock> list = getListeProduit(recherche);
			tableParDefaut = new DefaultTableModel(null,colonne);
	        for(int i = 0 ; i < list.size() ; i++)
	        {
	        	liste[0] = list.get(i).getReference();
	        	liste[1] = list.get(i).getDesignation();
	        	liste[2] = list.get(i).getIdCategorie();
	        	liste[3] = list.get(i).getIdFournisseur();
	        	liste[4] = list.get(i).getPrixUnitaire();
	        	liste[5] = list.get(i).getQuantite();
	        	liste[6] = list.get(i).getUnite();
	        	liste[7] = list.get(i).getImage();

	        	tableParDefaut.addRow(liste);
	        }
	        table.addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent arg0) {
	            		tableParDefaut = (DefaultTableModel)table.getModel();
	            		int select = table.getSelectedRow();
	            		reference = table.getValueAt(select, 0).toString();
	            		
	            		elt_select = true;
	            	}
	         });
	        table.setModel(tableParDefaut);
	        UI_pan_Liste_Produit.setLblPan_Liste_Produit("Liste des produits existant : "+ControlleurProduit.getCompteProduit());
	}
//Affichage du tableau dans la liste des commandes
	 String[] colonne2 = {	"ID Produit", "Designation", "P. Unitaire"};
	
	public void afficheListeListeProduit(JTable table,String recherche) 
	{	
			ArrayList<Stock> list = getListeProduit(recherche);
			tableParDefaut = new DefaultTableModel(null,colonne2);
	        for(int i = 0 ; i < list.size() ; i++)
	        {
	        	liste[0] = list.get(i).getReference();
	        	liste[1] = list.get(i).getDesignation();
	        	liste[2] = list.get(i).getPrixUnitaire();

	        	tableParDefaut.addRow(liste);
	        }
	        table.addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent arg0) {
	            		tableParDefaut = (DefaultTableModel) table.getModel();
	            		int select = table.getSelectedRow();
	            		reference = table.getValueAt(select, 0).toString();
	            		
	            		elt_select = true;
	            	}
	         });
	        table.setModel(tableParDefaut);
	        UI_pan_Liste_Produit.setLblPan_Liste_Produit("Liste des produits existant : "+ControlleurProduit.getCompteProduit());
	}
//	Obtnenir l'element selectionné
public void getElement(JTextField reference, JTextField designation, JComboBox<Integer> categorie, JComboBox<Integer> fournisseur, JTextField prixUnitaire, JTextField quantite, JComboBox<String> unite) {

		String requete = "SELECT * FROM stock WHERE reference = '"+ControlleurProduit.getReference()+"'";
        try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            rs = (ResultSet) st.executeQuery(requete);
            while(rs.next()){
            	reference.setText(rs.getString("reference")); 
            	designation.setText(rs.getString("designation")); 
            	categorie.setSelectedItem(rs.getString("idCategorie"));
            	fournisseur.setSelectedItem(rs.getString("idFournisseur"));
            	prixUnitaire.setText(rs.getString("prixUnitaire"));
            	quantite.setText(rs.getString("quantite"));
            	unite.setSelectedItem(rs.getString("unite"));
            	sary = rs.getString("image");
            	
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
	}
	
	public static boolean isElt_select() {
		return elt_select;
	}
	public static void setElt_select(boolean elt_select) {
		ControlleurProduit.elt_select = elt_select;
	}
	public static int getCompteProduit() {
		return compteProduit;
	}
	public static void setCompteProduit(int compteProduit) {
		ControlleurProduit.compteProduit = compteProduit;
	}
	public static String getReference() {
		return reference;
	}
	public static void setReference(String reference) {
		ControlleurProduit.reference = reference;
	}

	public static String getImage() {
		return sary;
	}

	public static void setImage(String src_image) {
		ControlleurProduit.sary = src_image;
	}
	
}
