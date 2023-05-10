package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import menu.Menu;
import models.Fournisseur;
import uiApplication.fournisseurs.UI_pan_Liste_Fournisseur;

	public class ControlleurFournisseur {
	private static ResultSet rs;
	private static Statement st;
	private static String sary;
	private static String typeCollaborateur;
	public ControlleurFournisseur() {
	}
	
//	methode pour ajouter des fournisseurs dans la table fournisseur
	public boolean ajoutFournisseur(String nom_entreprise, String adresseF, String nom_et_prenom, int telephone, String emailF) {
		String requete = "INSERT INTO fournisseur(nom_entreprise, adresseF, nom_et_prenom, telephone, emailF, type)VALUES (?,?,?,?,?,?)";
		boolean est_ajoute = false;
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
          
			insert.setString(1,nom_entreprise);
	        insert.setString(2,adresseF);
	        insert.setString(3,nom_et_prenom);
	        insert.setInt(4,telephone);
	        insert.setString(5,emailF);
	        insert.setString(6, Menu.getTypeCollaborateur());
	        
	        insert.executeUpdate();
	        est_ajoute = true;
	        
            afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
		} catch (Exception e) {
			est_ajoute = false;
			e.printStackTrace();
		}
		return est_ajoute;
	}
	
//	methode pour mettre a jour les fournisseurs dans le table fournisseur
	public boolean modifierFournisseur(String reference, String nom_entreprise, String adresseF, String nom_et_prenom, int telephone, String emailF) {
		String requete = "UPDATE fournisseur SET nom_entreprise=?,adresseF=?,nom_et_prenom=?,telephone=?,emailF=? WHERE reference='"+reference+"'";
		boolean est_modifie = false;
		try {
			 java.sql.PreparedStatement modifier = ConnectionDB.getConnect().prepareStatement(requete);
	            
				 modifier.setString(1,nom_entreprise);
				 modifier.setString(2,adresseF);
				 modifier.setString(3,nom_et_prenom);
				 modifier.setInt(4,telephone);
				 modifier.setString(5,emailF);
			        
				 modifier.executeUpdate();
				 est_modifie = true;
				 
				 afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
		} catch (Exception e) {
			est_modifie = false;
			e.printStackTrace();
		}
		return est_modifie;
	}
//	methode pour supprimer les donnees dans la table fournisseur
	public boolean supprimerProduit(String reference, boolean isSelected) {
		String requete = "DELETE FROM fournisseur WHERE reference='"+reference+"'";
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
//	methode pour obtenir la liste des fournisseur
	public ArrayList<Fournisseur> getListeFournisseur(String typeC, String recherche) {
		ArrayList<Fournisseur> ListeFournisseur = new ArrayList<Fournisseur>();
	        String sql = "SELECT * FROM fournisseur WHERE type='"+typeC+"'";
	        String sql1 = "SELECT * FROM fournisseur WHERE type='"+typeC+"'AND (reference LIKE '"+recherche+"%' or nom_entreprise LIKE '"+recherche+"%' or adresseF LIKE '"+recherche+"%' or emailF LIKE '"+recherche+"' or nom_et_prenom LIKE '"+recherche+"%' )";
	        compteFournisseur = 0;
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            if(recherche.equals("")) {
	            	 rs = (ResultSet) st.executeQuery(sql);
	            }else {
	            	 rs = (ResultSet) st.executeQuery(sql1);
	            }
	            while(rs.next()){
	            	ListeFournisseur.add(new Fournisseur(rs.getInt("reference"),rs.getString("nom_entreprise"), rs.getString("adresseF"),  rs.getString("nom_et_prenom"),rs.getInt("telephone"), rs.getString("emailF")));
	            	compteFournisseur++;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(UI_pan_Liste_Fournisseur.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return ListeFournisseur;
	}
//	affiche tableau de fournisseur
	private String [] colonne = {" REFERENCES "," NOM DE L'ENTREPRISE ",
			" ADRESSE "," NOM ET PRENOM ","  NUMERO TELEPHONE ", " E-MAIL "};
	private Object [] liste = new Object[6];
	DefaultTableModel tableParDefaut;
	private static String reference;
	private static boolean elt_select = false;
	private static int compteFournisseur;
	
	public void afficheListe(JTable table,String typeC, String recherche) {
		typeCollaborateur = typeC;
		ArrayList<Fournisseur> list = getListeFournisseur(typeC, recherche);
		tableParDefaut = new DefaultTableModel(null,colonne);
	        for(int i = 0 ; i < list.size() ; i++) {
	        	liste[0] = list.get(i).getReference();
	        	liste[1] = list.get(i).getNom_entreprise();
	        	liste[2] = list.get(i).getAdresseF();
	        	liste[3] = list.get(i).getNom_et_prenom();
	        	liste[4] = list.get(i).getTelephone();
	        	liste[5] = list.get(i).getEmailF();
	        	
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
	        UI_pan_Liste_Fournisseur.setLblPan_Liste_Produit("Liste des "+typeC+" existant : "+ControlleurFournisseur.getCompteFournisseur());
	}
//	Obtnenir l'element selectionné
public void getElement(JTextField nom_entreprise, JTextField adresseF, JTextField nom_et_prenom, JTextField telephone, JTextField emailF) {

		String requete = "SELECT * FROM fournisseur WHERE reference = '"+ControlleurFournisseur.getReference()+"'";
        try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            rs = (ResultSet) st.executeQuery(requete);
            while(rs.next()){
            	nom_entreprise.setText(rs.getString("nom_entreprise")); 
            	adresseF.setText(rs.getString("adresseF")); 
            	nom_et_prenom.setText(rs.getString("nom_et_prenom"));
            	telephone.setText(rs.getString("telephone"));
            	emailF.setText(rs.getString("emailF"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	public static boolean isElt_select() {
		return elt_select;
	}
	public static void setElt_select(boolean elt_select) {
		ControlleurFournisseur.elt_select = elt_select;
	}
	public static int getCompteFournisseur() {
		return compteFournisseur;
	}
	public static void setCompteFournisseur(int compteFournisseur) {
		ControlleurFournisseur.compteFournisseur = compteFournisseur;
	}
	public static String getImage() {
		return sary;
	}
	public static String getReference() {
		return reference;
	}
	public static void setReference(String reference) {
		ControlleurFournisseur.reference = reference;
	}
	public static void setImage(String src_image) {
		ControlleurFournisseur.sary = src_image;
	}
	public static String getTypeCollaborateur() {
		return typeCollaborateur;
	}
	public static void setTypeCollaborateur(String typeCollaborateur) {
		ControlleurFournisseur.typeCollaborateur = typeCollaborateur;
	}
}
