package models;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import connection.ConnectionDB;
import menu.Menu;
import uiApplication.fournisseurs.UI_pan_Liste_Fournisseur;

public class Fournisseur {
	
	private String nom_entreprise;
	private String adresseF;
	private String nom_et_prenom;
	private int telephone;
	private String emailF;
	private String reference;
	private static String select;
	
	private static ResultSet rs;
	private static Statement st;
	private static String sary;
	private static String typeCollaborateur;
	
	public Fournisseur() {}
	
	public Fournisseur(String reference, String nom_entreprise, String adresseF, String nom_et_prenom, int telephone, String emailF) {
		this.reference = reference;
		this.nom_entreprise = nom_entreprise;
		this.adresseF = adresseF;
		this.nom_et_prenom = nom_et_prenom;
		this.telephone = telephone;
		this.emailF = emailF;
	}
		
//		methode pour ajouter des fournisseurs dans la table fournisseur
		public boolean ajoutFournisseur(String nom_entreprise, String adresseF, String nom_et_prenom, int telephone, String emailF, boolean afficheTableau) {
			String requete = "INSERT INTO fournisseur(reference, nom_entreprise, adresseF, nom_et_prenom, telephone, emailF, type)VALUES (?,?,?,?,?,?,?)";
			boolean est_ajoute = false;
			try {
				java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
						if(Menu.getTypeCollaborateur().equals("Fournisseur")) {
						insert.setString(1,"FRS_0"+dernierId_plus_1("fournisseur"));
						}else {
							insert.setString(1,"CLI_0"+dernierId_plus_1("fournisseur"));
						}
				insert.setString(2,nom_entreprise);
		        insert.setString(3,adresseF);
		        insert.setString(4,nom_et_prenom);
		        insert.setInt(5,telephone);
		        insert.setString(6,emailF);
		        insert.setString(7, Menu.getTypeCollaborateur());
		        
		        insert.executeUpdate();
		        est_ajoute = true;
		        if(afficheTableau) {
		        	afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
		        }
			} catch (Exception e) {
				est_ajoute = false;
				e.printStackTrace();
			}
			return est_ajoute;
		}
//	
//		methode pour ajouter des fournisseurs dans la table fournisseur
		public boolean ajoutFournisseur() {
			String requete = "INSERT INTO fournisseur(reference, nom_entreprise, adresseF, nom_et_prenom, telephone, emailF, type)"
					+ "VALUES ('CLIENT-TEMP','Inconnus','Inconnus','Inconnus','0','Inconnus','"+Menu.getTypeCollaborateur()+"')";
			boolean est_ajoute = false;
			try {
				java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
				 insert.executeUpdate();
				 est_ajoute = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return est_ajoute;
		}
	
//		methode pour mettre a jour les fournisseurs dans le table fournisseur
		public boolean modifierFournisseur(String reference, String nom_entreprise, String adresseF, String nom_et_prenom, int telephone, String emailF, boolean temp) {
			String requete = "UPDATE fournisseur SET nom_entreprise=?,adresseF=?,nom_et_prenom=?,telephone=?,emailF=? WHERE reference='"+reference+"'";
			String requete2 ="UPDATE fournisseur SET reference = ?, nom_entreprise=?,adresseF=?,nom_et_prenom=?,telephone=?,emailF=? WHERE reference='\"+reference+\"'";
			boolean est_modifie = false;
			
			try {
				 java.sql.PreparedStatement modifier = null;
		           if(temp == true) {
		        	   modifier = ConnectionDB.getConnect().prepareStatement(requete2);
		        	   		
		        	   		modifier.setString(1,reference);
		        	   		modifier.setString(2,nom_entreprise);
		        	   		modifier.setString(3,adresseF);
		        	   		modifier.setString(4,nom_et_prenom);
		        	   		modifier.setInt(5,telephone);
		        	   		modifier.setString(6,emailF);
					        
		        	   		modifier.executeUpdate();
		        	   		est_modifie = true;
		           }else {
		        	  modifier = ConnectionDB.getConnect().prepareStatement(requete);
					 modifier.setString(1,nom_entreprise);
					 modifier.setString(2,adresseF);
					 modifier.setString(3,nom_et_prenom);
					 modifier.setInt(4,telephone);
					 modifier.setString(5,emailF);
				        
					 modifier.executeUpdate();
					 est_modifie = true;
					 
					 afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
		           }
			} catch (Exception e) {
				est_modifie = false;
				e.printStackTrace();
			}
			return est_modifie;
		}
//		methode pour supprimer les donnees dans la table fournisseur
		public boolean supprimerFournisseur(String reference, boolean isSelected) {
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
//		methode pour obtenir la liste des fournisseur
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
		            	ListeFournisseur.add(new Fournisseur(rs.getString("reference"),rs.getString("nom_entreprise"), rs.getString("adresseF"),  rs.getString("nom_et_prenom"),rs.getInt("telephone"), rs.getString("emailF")));
		            	compteFournisseur++;
		            }
		        } catch (SQLException ex) {
		        }
				return ListeFournisseur;
		}
//		affiche tableau de fournisseur
		private String [] colonne = {" REFERENCES "," NOM DE L'ENTREPRISE ",
				" ADRESSE "," NOM ET PRENOM ","  NUMERO TELEPHONE ", " E-MAIL "};
		private Object [] liste = new Object[6];
		DefaultTableModel tableParDefaut;
		private static boolean elt_select = false;
		private static int compteFournisseur;
		
		public void afficheListe(JTable table,String typeC, String recherche) {
			typeCollaborateur = typeC;
			ArrayList<Fournisseur> list = getListeFournisseur(typeC, recherche);
			tableParDefaut = new DefaultTableModel(null,colonne);
		        for(int i = 0 ; i < list.size() ; i++) {
		        	list.get(i);
		        	liste[0] = list.get(i).reference;
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
		            		int selectionne = table.getSelectedRow();
		            		select = table.getValueAt(selectionne, 0).toString();
		            		elt_select = true;
		            	}
		         });
		        table.setModel(tableParDefaut);
		        UI_pan_Liste_Fournisseur.setLblPan_Liste_Produit("Liste des "+typeC+" existant : "+Fournisseur.getCompteFournisseur());
		}
		
		public static int tabMax(int tab[]) {
			int max = 0;
			for(int i = 1 ; i <= tab.length-1 ; i++) {
				if(tab[i] > max) {
					max = tab[i];
				}
			}
			return max;
		}
		
		public static int dernierId_plus_1(String table) {	
			 String sql = "";
			if(table.equals("fournisseur")) {
				 sql = "SELECT COUNT(reference) AS compteur FROM "+table+" WHERE type = '"+Menu.getTypeCollaborateur()+"'";
			}else {
				 sql = "SELECT COUNT(reference) AS compteur FROM "+table+" WHERE 1";
			}
	        int[] id = new int[10000];
	        int i = 1;
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            rs = (ResultSet) st.executeQuery(sql);
	            while(rs.next()){
	            	id[i] = rs.getInt("compteur");
	            	i++;
	            }
	        } catch (SQLException ex) {
			}
			return tabMax(id)+1;
		}
		
//		Obtnenir l'element selectionné
	public void getElement(JTextField reference, JTextField nom_entreprise, JTextField adresseF, JTextField nom_et_prenom, JTextField telephone, JTextField emailF) 
	{
			String requete = "SELECT * FROM fournisseur WHERE reference = '"+getSelect()+"'";
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            rs = (ResultSet) st.executeQuery(requete);
	            while(rs.next()) {
	            	reference.setText(getSelect()); 
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
			Fournisseur.elt_select = elt_select;
		}
		
		public static int getCompteFournisseur() {
			return compteFournisseur;
		}
		
		public static void setCompteFournisseur(int compteFournisseur) {
			Fournisseur.compteFournisseur = compteFournisseur;
		}
		
		public static String getImage() {
			return sary;
		}
		
		public static void setImage(String src_image) {
			Fournisseur.sary = src_image;
		}
		
		public static String getTypeCollaborateur() {
			return typeCollaborateur;
		}
		
		public static void setTypeCollaborateur(String typeCollaborateur) {
			Fournisseur.typeCollaborateur = typeCollaborateur;
		}
		
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	
	public String getAdresseF() {
		return adresseF;
	}
	
	public void setAdresseF(String adresseF) {
		this.adresseF = adresseF;
	}
	
	public String getNom_et_prenom() {
		return nom_et_prenom;
	}
	
	public void setNom_et_prenom(String nom_et_prenom) {
		this.nom_et_prenom = nom_et_prenom;
	}
	
	public int getTelephone() {
		return telephone;
	}
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	public String getEmailF() {
		return emailF;
	}
	
	public void setEmailF(String emailF) {
		this.emailF = emailF;
	}
	
	public static String getSelect() {
		return select;
	}
	
	public static void setSelect(String select) {
		Fournisseur.select = select;
	}
}
