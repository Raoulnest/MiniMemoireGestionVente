package models;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import connection.ConnectionDB;
import uiApplication.produit.UI_pan_Liste_Produit;

public class Stock {
	static String select;
	String reference;
	String designation;
	String idCategorie;
	String idFournisseur;
	double prixUnitaire;
	double quantite;
	String unite;
	String image;
	private static ResultSet rs;
	private static Statement st;
	private static String sary;
	
	private static boolean pro_selected;
	private static String pro_reference;
	private static double lblStock;
	
	public static double getLblStock() {
		return lblStock;
	}

	public static void setLblStock(double lblStock) {
		Stock.lblStock = lblStock;
	}

	private String [] colonne = {" REFERENCES "," DESIGNATIONS ",
			" CATEGORIE "," FOURNISSEUR ","  PRIX UNITAIRE ", " QUANTITES "," UNITES ", "Images"};
	
	//Affichage du tableau dans la liste des commandes
		 String[] colonne2 = {	"ID Produit", "Designation", "P. Unitaire"};
		
	private Object [] liste = new Object[8];
	DefaultTableModel tableParDefaut;
	private static boolean elt_select = false;
	private static int compteProduit;
	
	public Stock() {}
	
	public Stock(String reference, String designation,  String idCategorie,  String idFournisseur, double prixUnitaire, double quantite, String unite,  String image) {
		this.reference = reference;
		this.designation = designation;
		this.idCategorie = idCategorie;
		this.idFournisseur = idFournisseur;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.unite = unite;
		this.image = image;
	}
	//Change le nom to reference
	
	public String changeNomtoId(String ref,String table, String nameBase, String nameSelected) {
        String sql = "SELECT "+ref+" FROM "+table+" WHERE "+nameBase+" = '"+nameSelected+"'";
        String reference = "";
        try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            rs = (ResultSet) st.executeQuery(sql);
            while(rs.next()){
            	reference =rs.getString(ref);
            }
        } catch (SQLException ex) {
            System.out.println(sql+" : Not OK");
        }
		return reference ;
	}
	
	public String[] afficheListe(String colone, String table, String condition) {
		String[] liste = new String[1000];
		int j = 0;
		String sql ="";
		if(condition.equals("")) {
			  sql = "SELECT "+colone+" from "+table+" GROUP BY reference DESC";
		}else {
			  sql = "SELECT "+colone+" from "+table+" WHERE type = '"+condition+"' GROUP BY reference DESC";
		}
            try {
				st=(Statement) ConnectionDB.getConnect().createStatement();
					rs = (ResultSet) st.executeQuery(sql);
		            while(rs.next()){
		               liste[j]=rs.getString(colone);
		               j++;
		       }
			} catch (SQLException e) {
				e.printStackTrace();
			}
            return liste;
	}
//	methode pour ajouter des produits dans la table produit
	public boolean ajoutProduit(String designation,  String idCategorie,  String idFournisseur, double prixUnitaire, double quantite, String unite, String image) {
		String requete = "INSERT INTO stock(reference, designation, idCategorie, idFournisseur, prixUnitaire, quantite, unite, image)VALUES (?,?,?,?,?,?,?,?)";
		boolean est_ajoute = false;
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
          
			insert.setString(1,"PROD_0"+Fournisseur.dernierId_plus_1("stock"));
	        insert.setString(2,designation);
	        insert.setString(3,idCategorie);
	        insert.setString(4,idFournisseur);
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
	public double quantiteStockee(String reference) {
		String requette1 =  "SELECT quantite FROM stock WHERE reference = '"+reference+"' ";
		double qttStock = 0;
        try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            rs = (ResultSet) st.executeQuery(requette1);
            while(rs.next()){
            	qttStock =rs.getDouble("quantite");
            }
        } catch (SQLException ex) {
        }
		return qttStock;
	}
	
	public double modifierQuantite(String idPro,double quantiteVendu, double quantiteModifie) {
		double qtt = quantiteStockee(idPro) + controlQuantity(quantiteVendu, quantiteModifie);
		
		String requette = "UPDATE stock SET quantite = '"+qtt+"' WHERE reference = '"+idPro+"'";
		 java.sql.PreparedStatement modifier;
		try {
			modifier = ConnectionDB.getConnect().prepareStatement(requette);  
			modifier.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtt;
	}
	//
	public static double lblResteStock(double newQuantity) {
		
		return 0;
	}
	//
	public double controlQuantity(double oldQuantity, double lastQuantity) {
		double somme = oldQuantity - lastQuantity;
		return somme;
	}
//	methode pour mettre a jour les produits dans le table produit
	public boolean modifierProduit(String reference, String designation,  String idCategorie,  String idFournisseur, double prixUnitaire, double quantite, String unite, String image) {
		String requete = "UPDATE stock SET designation=?,idCategorie=?,idFournisseur=?,prixUnitaire=?,quantite=?,unite=?,image=? WHERE reference='"+reference+"'";
		boolean est_modifie = false;
		try {
			 java.sql.PreparedStatement modifier = ConnectionDB.getConnect().prepareStatement(requete);
	            
				 modifier.setString(1,designation);
				 modifier.setString(2,idCategorie);
				 modifier.setString(3,idFournisseur);
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
	            	ListeProduit.add(new Stock(rs.getString("reference"), rs.getString("designation"), rs.getString("idCategorie"), rs.getString("idFournisseur"), rs.getDouble("prixUnitaire"), rs.getDouble("quantite"), rs.getString("unite"), rs.getString("image")));
	            	compteProduit++;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(UI_pan_Liste_Produit.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return ListeProduit;
	}

//	affiche tableau de produit
	public void afficheListe(JTable table,String recherche) 
	{	
			ArrayList<Stock> list = getListeProduit(recherche);
			tableParDefaut = new DefaultTableModel(null,colonne);
	        for(int i = 0 ; i < list.size() ; i++)
	        {
	        	liste[0] = list.get(i).reference;
	        	liste[1] = list.get(i).designation;
	        	liste[2] = list.get(i).idCategorie;
	        	liste[3] = list.get(i).idFournisseur;
	        	liste[4] = list.get(i).prixUnitaire;
	        	liste[5] = list.get(i).quantite;
	        	liste[6] = list.get(i).unite;
	        	liste[7] = list.get(i).image;
	        	tableParDefaut.addRow(liste);
	        }
	        table.addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent arg0) {
	            		tableParDefaut = (DefaultTableModel)table.getModel();
	            		int selectionne = table.getSelectedRow();
	            		select = table.getValueAt(selectionne, 0).toString();
	            		elt_select = true;
	            	}
	         });
	        table.setModel(tableParDefaut);
	        UI_pan_Liste_Produit.setLblPan_Liste_Produit("Liste des produits existants : "+Stock.getCompteProduit());
	}
//Affichage du tableau dans la liste des commandes
	public void afficheListeListeProduit(JTable table,String recherche) 
	{
			ArrayList<Stock> list = getListeProduit(recherche);
			tableParDefaut = new DefaultTableModel(null,colonne2);
	        for(int i = 0 ; i < list.size() ; i++)
	        {
	        	liste[0] = list.get(i).reference;
	        	liste[1] = list.get(i).designation;
	        	liste[2] = list.get(i).prixUnitaire;
	        	tableParDefaut.addRow(liste);
	        }
	        table.addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent arg0) {
	            		tableParDefaut = (DefaultTableModel) table.getModel();
	            		int select = table.getSelectedRow();
	            		pro_reference = table.getValueAt(select, 0).toString();
	            		pro_selected = true;
	            	}
	         });
	        table.setModel(tableParDefaut);	       
	}
	
//	Obtnenir l'element selectionné
public void getElement(JTextField designation, JComboBox<Integer> categorie, JComboBox<Integer> fournisseur, JTextField prixUnitaire, JTextField quantite, JComboBox<String> unite) {

		String requete = "SELECT * FROM stock, categorie, fournisseur WHERE stock.idCategorie = categorie.reference AND stock.idFournisseur = fournisseur.reference AND stock.reference = '"+getSelect()+"'";
       System.out.println(requete);
		try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            rs = (ResultSet) st.executeQuery(requete);
            while(rs.next()){
//            	reference.setText(rs.getString("stock.reference")); 
            	designation.setText(rs.getString("stock.designation")); 
            	categorie.setSelectedItem(rs.getString("categorie.nomCategorie"));
            	fournisseur.setSelectedItem(rs.getString("fournisseur.nom_et_prenom"));
            	prixUnitaire.setText(rs.getString("stock.prixUnitaire"));
            	quantite.setText(rs.getString("stock.quantite"));
            	unite.setSelectedItem(rs.getString("stock.unite"));
            	sary = rs.getString("stock.image");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	public static boolean isElt_select() {
		return elt_select;
	}
	public static void setElt_select(boolean elt_select) {
		Stock.elt_select = elt_select;
	}
	public static int getCompteProduit() {
		return compteProduit;
	}
	public static void setCompteProduit(int compteNbProduit) {
		compteProduit = compteNbProduit;
	}
	public static String getImage() {
		return sary;
	}
	public static void setImage(String src_image) {
		sary = src_image;
	}

	public static String getSelect() {
		return select;
	}

	public static void setSelect(String select) {
		Stock.select = select;
	}

	public static boolean isPro_selected() {
		return pro_selected;
	}

	public static void setPro_selected(boolean pro_selected) {
		Stock.pro_selected = pro_selected;
	}

	public static String getPro_reference() {
		return pro_reference;
	}

	public static void setPro_reference(String pro_reference) {
		Stock.pro_reference = pro_reference;
	}

}
