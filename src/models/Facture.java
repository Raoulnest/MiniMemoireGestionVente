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

public class Facture {
	String reference;
	String idCom;
	Date dateFacturation;

	private static String select;
	private static ResultSet rs;
	private static Statement st;
	
	public Facture() {}
	
	public  Facture(String reference, String idCom, Date dateFacture) {
		this.reference = reference;
		this.idCom = idCom;
		this.dateFacturation = dateFacture;
		
	}
	
//	Ajout dans la table facture
	
	public boolean ajoutFacture(String idCom, String etat, double mttPayer, double reste) {
		String requete = "INSERT INTO facture(reference,idCom, etat, mttPayer, reste)VALUES (?,?,?,?,?)";
		boolean est_ajoute = false;
		String ref = null;
			ref = "FACT_0"+Fournisseur.dernierId_plus_1("facture");
			try {
				java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
				
				insert.setString(1, ref);
				insert.setString(2, idCom);
				insert.setString(3, etat);
				insert.setDouble(4, mttPayer);
				insert.setDouble(5, reste);
				
		        insert.executeUpdate();
		        est_ajoute = true;
			} catch (Exception e) {
				est_ajoute=false;
				e.printStackTrace();
			}
		return est_ajoute;
	}
	
//	Modification des factures
	
	public boolean modifierFacture(String reference, String etat, int mttPayer, int reste){
			String requete = "UPDATE facture SET etat=?, mttPayer=?, reste=? WHERE reference='"+reference+"'";
			boolean est_modifie = false;
			java.sql.PreparedStatement modifier = null;
			try {
		            	modifier = ConnectionDB.getConnect().prepareStatement(requete);
		            	
		            	modifier.setString(1,etat);
		            	modifier.setInt(2,mttPayer);
		            	modifier.setInt(3,reste);
		            	
		            	modifier.executeUpdate();
		            	est_modifie = true;
			} catch (Exception e) {
				est_modifie = false;
				e.printStackTrace();
			}
		return est_modifie;
	}
	
	//methode pour supprimer les donnees dans la table facture
	
	public boolean supprimerFacture(String reference, boolean isSelected) {
		String requete = "DELETE FROM facture WHERE reference='"+reference+"'";
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
	
	//methode pour obtenir la liste des facture
	
	public ArrayList<Facture> getListeFacture(String recherche) {
		ArrayList<Facture> ListeFacture = new ArrayList<Facture>();
	        String sql = "SELECT * FROM facture WHERE 1";
	        String sql1 = "SELECT * FROM facture WHERE reference LIKE '"+recherche+"%' or idCom  LIKE '"+recherche+"%' or dateFact";
	        compteFacture = 0;
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            if(recherche.equals("")) {
	            	 rs = (ResultSet) st.executeQuery(sql);
	            }else {
	            	 rs = (ResultSet) st.executeQuery(sql1);
	            }
	            while(rs.next()){
	            	ListeFacture.add(new Facture(rs.getString("reference"),rs.getString("idCom"),rs.getDate("dateFact")));
	            	compteFacture++;
	            }
	        } catch (SQLException ex) {
	        }
			return ListeFacture;
	}
	
	//affichage tableau de fournisseur
	
	private String [] colonne = {" REFERENCE Facture"," REFERENCE COMMANDE ",
			" DATE DE FACTURE ", " ETAT DU FACTURE "};
	private Object [] liste = new Object[4];
	DefaultTableModel tableParDefaut;
	private static boolean elt_select = false;
	private static int compteFacture;
	
	public void afficheListe(JTable table, String recherche) {
		ArrayList<Facture> list = getListeFacture(recherche);
		tableParDefaut = new DefaultTableModel(null,colonne);
	        for(int i = 0 ; i < list.size() ; i++) {
	        	list.get(i);
	        	liste[0] = list.get(i).reference;
	        	liste[1] = list.get(i).idCom;
	        	liste[2] = list.get(i).dateFacturation;
	        	
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
	
//	Getters et Setters
	public static String getSelect() {
		return select;
	}
	public static void setSelect(String select) {
		Facture.select = select;
	}
	public static boolean isElt_select() {
		return elt_select;
	}
	public static void setElt_select(boolean elt_select) {
		Facture.elt_select = elt_select;
	}
	public static int getCompteFacture() {
		return compteFacture;
	}
	public static void setCompteFacture(int compteCommande) {
		Facture.compteFacture = compteCommande;
	}

}
