package models;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import connection.ConnectionDB;

public class Commande {
	String idClient;
	double prixTotal;
	String etat;
	String reference;
	Date dateCommande;

	private static String select;
	private static ResultSet rs;
	private static Statement st;
	
	public Commande() {}
	
	public  Commande(String reference, String idClient, double prixTotal,Date dateCommande, String etat) {
		this.reference = reference;
		this.idClient = idClient;
		this.prixTotal = prixTotal;
		this.dateCommande = dateCommande;
		this.etat = etat;
	}
	
	public boolean ajoutCommande() {
		String requete = "INSERT INTO commande(prix_total)VALUES (0.0)";
		boolean est_ajoute = false;
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
	        insert.executeUpdate();
	        est_ajoute = true;
		} catch (Exception e) {
			est_ajoute=false;
			e.printStackTrace();
		}
		return est_ajoute;
	}
	public boolean ajoutCommande(String reference,String idClient, double prix_total) {
		String requete = "INSERT INTO commande(reference,idCli,prix_total)VALUES (?,?,?)";
		boolean est_ajoute = false;
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
			
			insert.setString(1, reference);
			insert.setString(2, idClient);
			insert.setDouble(1, prix_total);
			
	        insert.executeUpdate();
	        est_ajoute = true;
		} catch (Exception e) {
			est_ajoute=false;
			e.printStackTrace();
		}
		return est_ajoute;
	}
	public boolean modifierCommande(String reference, String idCli, double prix_total){
		String requete = "UPDATE commande SET reference=?,idCli=?,prix_total=? WHERE reference='"+reference+"'";
		String requete2 = "UPDATE commande SET idCli=?,prix_total=? WHERE reference='"+reference+"'";
		boolean est_modifie = false;
		String ref = "COM-0"+(Fournisseur.dernierId_plus_1("commande")-1);
		java.sql.PreparedStatement modifier = null;
		try {
	            if(reference.equals("COM-TEMP") ){
	            	 modifier = ConnectionDB.getConnect().prepareStatement(requete);
	            	 modifier.setString(1,ref);
					 modifier.setString(2,idCli);
					 modifier.setDouble(3,prix_total);
	            }else {
	            	 modifier = ConnectionDB.getConnect().prepareStatement(requete2);
	            	modifier.setString(1,idCli);
					 modifier.setDouble(2,prix_total);
	            }
				 modifier.executeUpdate();
				 est_modifie = true;
				 
		} catch (Exception e) {
			est_modifie = false;
			e.printStackTrace();
		}
		return est_modifie;
	}
	//methode pour supprimer les donnees dans la table produit
	public boolean supprimerCommande(String reference, boolean isSelected) {
		String requete = "DELETE FROM commande WHERE reference='"+reference+"'";
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
	
	//methode pour obtenir la liste des commandes
	public ArrayList<Commande> getListeCommande(String recherche) {
		ArrayList<Commande> ListeCommande = new ArrayList<Commande>();
	        String sql = "SELECT * FROM commande WHERE 1";
	        String sql1 = "SELECT * FROM commande WHERE reference LIKE '"+recherche+"%' or idCli  LIKE '"+recherche+"%' or dateCom  LIKE '"+recherche+"%' or etat  LIKE '"+recherche+"%'";
	        compteCommande = 0;
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            if(recherche.equals("")) {
	            	 rs = (ResultSet) st.executeQuery(sql);
	            }else {
	            	 rs = (ResultSet) st.executeQuery(sql1);
	            }
	            while(rs.next()){
	            	ListeCommande.add(new Commande(rs.getString("reference"),rs.getString("idCli"), rs.getDouble("prix_total"),rs.getDate("dateCom"), rs.getString("etat")));
	            	compteCommande++;
	            }
	        } catch (SQLException ex) {
	        }
			return ListeCommande;
	}
	//affiche tableau de fournisseur
	private String [] colonne = {" REFERENCE "," Reference CLIENT ",
			" MONTANT "," DATE DE COMMANDE ", " ETAT DU COMMANDE "};
	private Object [] liste = new Object[5];
	DefaultTableModel tableParDefaut;
	private static boolean elt_select = false;
	private static int compteCommande;
	
	public void afficheListe(JTable table, String recherche) {
		ArrayList<Commande> list = getListeCommande(recherche);
		tableParDefaut = new DefaultTableModel(null,colonne);
	        for(int i = 0 ; i < list.size() ; i++) {
	        	list.get(i);
	        	liste[0] = list.get(i).reference;
	        	liste[1] = list.get(i).idClient;
	        	liste[2] = list.get(i).prixTotal;
	        	liste[3] = list.get(i).dateCommande;
	        	liste[4] = list.get(i).etat;
	        	
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
	}
	
	public static String getSelect() {
		return select;
	}
	public static void setSelect(String select) {
		Commande.select = select;
	}
	public static boolean isElt_select() {
		return elt_select;
	}
	public static void setElt_select(boolean elt_select) {
		Commande.elt_select = elt_select;
	}
	public static int getCompteCommande() {
		return compteCommande;
	}
	public static void setCompteCommande(int compteCommande) {
		Commande.compteCommande = compteCommande;
	}

}
