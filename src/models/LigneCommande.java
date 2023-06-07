package models;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import connection.ConnectionDB;
import uiApplication.commandes.UI_pan_Liste_Commande;
import uiApplication.produit.UI_pan_Liste_Produit;

public class LigneCommande {
//	private static String select;
	private static String reference;
	private String commande;
	private String idProd;
	private  String designation;
	private double prixUnitaire;
	private double prixT;
	private double quantite;
	private String unite;
	private static ResultSet rs;
	private static Statement st;
	private static String sary;
	private  static String operation;
	
	private String [] colonne = {" Produit n° "," DESIGNATIONS "," PRIX UNITAIRE ", " QUANTITES "," UNITES ", "TOTAL"};
	
	//Affichage du tableau dans la liste des commandes
	String[] colonne2 = {	"ID Produit", "Designation", "P. Unitaire"};
		
	private Object [] liste = new Object[8];
	DefaultTableModel tableParDefaut;
	private static boolean elt_select = false;
	private static int compteProduit;
	Stock stock = new Stock();
	
	public LigneCommande() {}
	
	public LigneCommande(String idCom, String idProd, String designation, double prixT, double quantite, String unite) {
		this.commande = idCom;
		this.idProd = idProd;
		this.designation = designation;
		this.prixT = prixT;
		this.quantite = quantite;
		this.unite = unite;
	}
	
//	methode pour ajouter des lignes commandes
	public boolean ajoutLigneCommande(String idPro,String idCom,  double prixUnitaire,double quantite,  String unite) {
		String requete = "INSERT INTO ligne_commande(idProd, idCom, qttCommande, prixT, unite)VALUES (?,?,?,?,?)";
		String requete1 = "INSERT INTO stock(quantite)VALUE(?) WHERE reference = '"+idPro+"'";
		String requete2 = "SELECT * FROM ligne_commande  WHERE idProd='"+idPro+"' AND  idCom = '"+idCom+"'";
		String verifyRefPro = "";
		String verifyRefCom = "";
		boolean est_ajoute = false;
		 try {
			st=(Statement) ConnectionDB.getConnect().createStatement();
			rs = (ResultSet) st.executeQuery(requete2);
         	while(rs.next()){
         		verifyRefPro = rs.getString("ligne_commande.idProd");
         		verifyRefCom = rs.getString("ligne_commande.idCom");
            }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 if(verifyRefPro.equals(idPro) && verifyRefCom.equals(idCom)) {
			 modifieLigneCommande(idPro,idCom,prixUnitaire,quantite,unite);
		 }else {
			   
		try {
			java.sql.PreparedStatement insert = ConnectionDB.getConnect().prepareStatement(requete);
          
			insert.setString(1,idPro);
	        insert.setString(2,idCom);
	        insert.setDouble(3,quantite);
	        insert.setDouble(4,prixUnitaire*quantite);
	        insert.setString(5,unite);
	        insert.executeUpdate();
	        
//			 stock.modifierQuantite( idPro,0, quantite);
	        
	        UI_pan_Liste_Commande.getLblMessage().setText("<html>Produit  a ete ajoute <br>dans la liste de commande</html>");
			UI_pan_Liste_Commande.getLblMessage().setForeground(Color.YELLOW);
//			try {
//				UI_pan_Liste_Commande.getLblTotal().setText("<html>Somme d\'article :  <b style = \"color: Orange;\">"+LigneCommande.getPrixTotal(Commande.getSelect())+"</b> Ar.</html>");
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
	        est_ajoute = true;
            afficheListe(UI_pan_Liste_Commande.getTableLgCommande(),idCom,"");
	        
		} catch (Exception e) {
			est_ajoute = false;
			e.printStackTrace();
		}
		 }   
		return est_ajoute;
	}

	public double quantiteCommandee(String reference) {
		String requette1 =  "SELECT qttCommande FROM ligne_commande WHERE idCom = '"+reference+"' ";
		double qttCommande = 0;
        try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            rs = (ResultSet) st.executeQuery(requette1);
            while(rs.next()){
            	qttCommande =rs.getDouble("qttCommande");
            }
        } catch (SQLException ex) {
        }
		return qttCommande;
	}
	
//	methode pour ajouter des lignes commandes
	public boolean modifieLigneCommande(String idPro,String idCom,  double prixUnitaire,double quantite,  String unite) {
		String requete = "UPDATE ligne_commande SET qttCommande=?, prixT = ?, unite = ? WHERE idProd='"+idPro+"' AND  idCom = '"+idCom+"'";
//		stock.modifierQuantite(idPro, quantiteCommandee(idCom), quantite);

		boolean est_modifie = false;
		try {
			java.sql.PreparedStatement modifie = ConnectionDB.getConnect().prepareStatement(requete);
			modifie.setDouble(1,quantite);
			modifie.setDouble(2,prixUnitaire*quantite);
			modifie.setString(3,unite);
			modifie.executeUpdate();
	        UI_pan_Liste_Commande.getLblMessage().setText("<html>Modification du quantite de ligne commande</html>");
			UI_pan_Liste_Commande.getLblMessage().setForeground(Color.YELLOW);
//			try {
//				UI_pan_Liste_Commande.getLblTotal().setText("<html>Somme d\'article :  <b style = \"color: Orange;\">"+LigneCommande.getPrixTotal(Commande.getSelect())+"</b> Ar.</html>");
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
	       est_modifie = true;
			 afficheListe(UI_pan_Liste_Commande.getTableLgCommande(), idCom, "");
	        
		} catch (Exception e) {
			est_modifie = false;
			e.printStackTrace();
		}
		return est_modifie;
	}
//	methode pour ajouter des lignes commandes
	public boolean modifieLigneCommande(String idComOld,String idCom) {
		String requete = "UPDATE ligne_commande SET idCom=? WHERE  idCom = '"+idComOld+"'";
		
		boolean est_modifie = false;
		try {
			java.sql.PreparedStatement modifie = ConnectionDB.getConnect().prepareStatement(requete);
			modifie.setString(1,idCom);
			modifie.executeUpdate();

	       est_modifie = true;
	        
		} catch (Exception e) {
			est_modifie = false;
			e.printStackTrace();
		}
		return est_modifie;
	}
//	methode pour obtenir la liste des produits
	public ArrayList<LigneCommande> getLigneCommande(String idCom, String recherche) {
		ArrayList<LigneCommande> ligneCommande = new ArrayList<LigneCommande>();
	        String sql = "SELECT * FROM stock,commande,ligne_commande WHERE stock.reference = ligne_commande.idProd AND commande.reference = ligne_commande.idCom AND ligne_commande.idCom = '"+idCom+"'";
	        String sql1 = "SELECT * FROM ligne_commande WHERE reference LIKE '"+recherche+"%' or idCategorie LIKE '"+recherche+"%' or idFournisseur LIKE '"+recherche+"%' or designation LIKE '"+recherche+"%' or unite LIKE '"+recherche+"%'";
	        compteProduit = 0;
	        try {
	            st=(Statement) ConnectionDB.getConnect().createStatement();
	            if(recherche.equals("")) {
	            	 rs = (ResultSet) st.executeQuery(sql);
	            }else {
	            	 rs = (ResultSet) st.executeQuery(sql1);
	            }
	            while(rs.next()){
	            	ligneCommande.add(new LigneCommande( rs.getString("commande.reference"),rs.getString("stock.reference"), rs.getString("stock.designation"),rs.getDouble("ligne_commande.prixT"), rs.getDouble("ligne_commande.qttCommande"), rs.getString("stock.unite")));
	            	compteProduit++;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(UI_pan_Liste_Produit.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return ligneCommande;
	}

//	affiche tableau de LigneCommande
	public void afficheListe(JTable table,String idCom,String recherche) 
	{
			ArrayList<LigneCommande> list = getLigneCommande(idCom,recherche);
			tableParDefaut = new DefaultTableModel(null,colonne);
	        for(int i = 0 ; i < list.size() ; i++)
	        {
	        	liste[0] = list.get(i).idProd; 
	        	liste[1] = list.get(i).designation;
	        	liste[2] = list.get(i).prixT / list.get(i).quantite;
	        	liste[3] = list.get(i).quantite;
	        	liste[4] = list.get(i).unite;
	        	liste[5] = list.get(i).prixT;
	        	
	        	tableParDefaut.addRow(liste);
	        }
	        table.addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent arg0) {
	            		tableParDefaut = (DefaultTableModel)table.getModel();
	            		int selectionne = table.getSelectedRow();
	            		reference = table.getValueAt(selectionne, 0).toString();
	            		operation = "Modifier";
	            		elt_select = true;
							UI_pan_Liste_Commande.refresh();
	            	}
	         });
	        table.setModel(tableParDefaut);
	}
	//methode pour supprimer les donnees dans la table produit
		public boolean supprimerLigneCommande(String reference,String idCom ,boolean isSelected) {
			String  requete2 = "DELETE FROM ligne_commande WHERE idCom = '"+idCom+"'";
			String requete = "DELETE FROM ligne_commande WHERE idProd='"+reference+"' AND  idCom = '"+idCom+"'";
			
			boolean est_sup = false;
			if(isSelected==false) {
				System.out.println("Veuillez selectionner l'element dans ce tableau : ");
			}else {
		        try {
		        	if(reference.equals("tout")) {
		        		java.sql.PreparedStatement supprimer= (PreparedStatement) ConnectionDB.getConnect().prepareStatement(requete2);
			        	supprimer.executeUpdate();
					}else {
						java.sql.PreparedStatement supprimer= (PreparedStatement) ConnectionDB.getConnect().prepareStatement(requete);
			        	supprimer.executeUpdate();
			        	UI_pan_Liste_Commande.getLblMessage().setText("<html>Suppression d'un produit <br>dans la liste de commande.!</html>");
			        	UI_pan_Liste_Commande.getLblMessage().setForeground(Color.RED);
//			        	try {
//			        		UI_pan_Liste_Commande.getLblTotal().setText("<html>Somme d\'article :  <b style = \"color: Orange;\">"+LigneCommande.getPrixTotal(Commande.getSelect())+"</b> Ar.</html>");
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
			        	System.out.println("L'element qui porte l'identification '"+reference+"' a été supprimé définitivement : ");
			            est_sup = true;
					}
		        } catch (SQLException e) {
		        	est_sup = false;
		            e.printStackTrace();
		        }
			}
			return est_sup;
		}
		
	//Affichage du tableau de la liste des produits dans UI_pan_commande
		public void afficheListeProduit(JTable table,String recherche) 
		{
				ArrayList<Stock> list = stock.getListeProduit(recherche);
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
		            		reference = table.getValueAt(select, 0).toString();
		            		operation = "Ajouter";
		            		elt_select = true;
								UI_pan_Liste_Commande.refresh();
		            	}
		         });
		        table.setModel(tableParDefaut);
		}
		
//	Obtnenir l'element selectionné
		static int quantite_reste;
		 static double prixTotal ;
	public static  int getQuantite_reste() {
				return quantite_reste;
	}
	
	public  void setQuantite_reste(double quantite_reste) {
	quantite_reste = quantite_reste;
}
public static  double getPrixTotal(String idCom) throws SQLException {
	String requete2 = "SELECT SUM(prixT) AS somme FROM ligne_commande WHERE idCom='"+idCom+"'";
	  st=(Statement) ConnectionDB.getConnect().createStatement();
	  rs = (ResultSet) st.executeQuery(requete2);
      while(rs.next()){
      	prixTotal = rs.getDouble("somme");
      }
      System.out.println("La somme est :"+prixTotal);
	return prixTotal;	
}
public void getElement(JButton operation, JTextField reference, JComboBox<String> categorie, JTextField designation,  JTextField prixUnitaire, JTextField quantite, JComboBox<String> unite) 
{
		String requete = "SELECT * FROM stock, fournisseur, categorie WHERE stock.idCategorie = categorie.reference AND stock.reference = '"+getReference()+"'";
		String requete2 = "SELECT * FROM ligne_commande, fournisseur, stock WHERE ligne_commande.idProd = stock.reference AND stock.reference = '"+getReference()+"'";
		try {
            st=(Statement) ConnectionDB.getConnect().createStatement();
            if(operation.getText()=="Modifier") {
                rs = (ResultSet) st.executeQuery(requete2);
                while(rs.next()){
                	operation.setText(getOperation());
                	reference.setText(rs.getString("ligne_commande.idProd"));
                	designation.setText(rs.getString("stock.designation")); 
                	prixUnitaire.setText(rs.getString("stock.prixUnitaire"));
                	quantite.setText(rs.getString("ligne_commande.qttCommande"));
                	unite.setSelectedItem(rs.getString("ligne_commande.unite"));
                }
            }else {
                rs = (ResultSet) st.executeQuery(requete);
                while(rs.next()){
                	operation.setText(getOperation());
                	reference.setText(rs.getString("stock.reference"));
                	designation.setText(rs.getString("stock.designation")); 
                	categorie.setSelectedItem(rs.getString("categorie.nomCategorie"));
                	prixUnitaire.setText(rs.getString("stock.prixUnitaire"));
                	quantite.setText("1");
                	quantite_reste = rs.getInt("stock.quantite");
                	unite.setSelectedItem(rs.getString("stock.unite"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	public static boolean isElt_select() {
		return elt_select;
	}
	public static void setElt_select(boolean elt_select) {
		LigneCommande.elt_select = elt_select;
	}
	public static int getCompteProduit() {
		return compteProduit;
	}
	public static void setCompteProduit(int compteNbProduit) {
		compteProduit = compteNbProduit;
	}

	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	public  String getOperation() {
		return operation;
	}
}
