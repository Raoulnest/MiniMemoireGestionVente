package uiApplication.commandes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import menu.Menu;
import models.Commande;
import models.Fournisseur;
import models.LigneCommande;
import models.Stock;
import uiApplication.fournisseurs.UI_ajouterFournisseur;
import uiPersonalisee.PanneauPersonalise;
import uiPersonalisee.ScrollPersonalise;
import uiPersonalisee.TableDark;

public class UI_pan_Liste_Commande extends JPanel {
	private static TableDark tableProduit;
	private JTextField txtRecherche;
	private static JTextField txt_prixUnitaire;
	private static JTextField txt_designation;
	private static JTextField txt_quantite;
	private static JTextField txt_reference;
	static JComboBox cbx_categorie;
	static JComboBox  cbx_unite;
	private JTextField txt_TVA;
	private static JPanel panCommande;
	private static JTextField txt_prixTotal;
	static LigneCommande produit = new LigneCommande();
	Stock stock = new Stock();
	static JButton btn_ajout_modif;
	static JButton btn_sup_lg_com;
	private static TableDark tableLgCommande;
	static JLabel lblResteStock;
	static JLabel lblTotal;
	static JLabel lblMessage;
	static double quantite;

	Commande com = new Commande();
	LigneCommande lgCom = new LigneCommande();
	Fournisseur f = new Fournisseur();
	private static boolean etatModifie = false;
	
	static JComboBox cbxClient;

	public static JComboBox getCbxClient() {
		return cbxClient;
	}
	public static void setCbxClient(JComboBox cbxClient) {
		UI_pan_Liste_Commande.cbxClient = cbxClient;
	}
	/**
	 * Create the panel.
	 */
	public static JPanel getPanel() {
		return panCommande;
	}
	public static TableDark getTableProduit() {
		return tableProduit;
	}
	public static void setTableProduit(TableDark tableProduit) {
		UI_pan_Liste_Commande.tableProduit = tableProduit;
	}
	public static TableDark getTableLgCommande() {
		return tableLgCommande;
	}
	public void setTableLgCommande(TableDark tableLgCommande) {
		UI_pan_Liste_Commande.tableLgCommande = tableLgCommande;
	}
	public static JLabel getLblMessage() {
		return lblMessage;
	}
	public static void setLblMessage(JLabel lblMessage) {
		UI_pan_Liste_Commande.lblMessage = lblMessage;
	}
	public static void setPanel(JPanel panel) {
		UI_pan_Liste_Commande.panCommande = panel;
	}
	@SuppressWarnings("unchecked")
	public UI_pan_Liste_Commande() {
		panCommande = new JPanel();
		panCommande.setBackground(new Color(0, 0, 102));
		PanneauPersonalise panel_3 = new PanneauPersonalise(20,20,20,20,new Color(0,0,51));
		PanneauPersonalise panel = new PanneauPersonalise(20,20,20,20,new Color(0,0,51));
		
		panel.setBorder(UIManager.getBorder("Table.cellNoFocusBorder"));
		JScrollPane scrollPane = new JScrollPane();
		ScrollPersonalise sb = new ScrollPersonalise();
		scrollPane.setVerticalScrollBar(sb);
		tableProduit = new TableDark();;
		tableProduit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_ajout_modif.setText("Ajouter");
				lblMessage.setText("");
			}
		});
		scrollPane.setViewportView(tableProduit);

		produit.afficheListeProduit(tableProduit,"");
		
		txtRecherche = new JTextField();
		txtRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecherche.setForeground(Color.WHITE);
		txtRecherche.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtRecherche.setBackground(new Color(0, 0, 51));
		txtRecherche.setSelectedTextColor(Color.ORANGE);
		txtRecherche.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtRecherche.setColumns(10);
		
		cbx_categorie = new JComboBox();

		
		String listeCategorie[] = stock.afficheListe("nomCategorie", "categorie","");
		cbx_categorie.setModel(new DefaultComboBoxModel<String>(listeCategorie));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,51));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBar(sb);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
		);
		
		txt_prixUnitaire = new JTextField();
		txt_prixUnitaire.setEditable(false);
		txt_prixUnitaire.setHorizontalAlignment(SwingConstants.CENTER);
		txt_prixUnitaire.setForeground(Color.WHITE);
		txt_prixUnitaire.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_prixUnitaire.setBackground(new Color(0, 0, 51));
		txt_prixUnitaire.setSelectedTextColor(Color.ORANGE);
		txt_prixUnitaire.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_prixUnitaire.setColumns(10);
		
		txt_designation = new JTextField();
		txt_designation.setEditable(false);
		txt_designation.setHorizontalAlignment(SwingConstants.CENTER);
		txt_designation.setForeground(Color.WHITE);
		txt_designation.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_designation.setBackground(new Color(0, 0, 51));
		txt_designation.setSelectedTextColor(Color.ORANGE);
		txt_designation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_designation.setColumns(10);
		
		txt_quantite = new JTextField();
		txt_quantite.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txt_quantite.getText().equals("")) {
					System.out.println("Notre programme n'effectue pas des calculs avec le nombre null");
				}else {
					if(Double.parseDouble(txt_quantite.getText()) > LigneCommande.getQuantite_reste()) {
						
						txt_quantite.setForeground(Color.RED);
						lblMessage.setText("<html>Notre stock est insuffusant.<br> Veuillez diminuer la quantite<html>");
						lblMessage.setForeground(Color.RED);
						txt_prixTotal.setText(""+Double.parseDouble(txt_prixUnitaire.getText())*Double.parseDouble(txt_quantite.getText())+" Ar");
					
					}else if(Double.parseDouble(txt_quantite.getText()) <= 0) {
						txt_quantite.setForeground(Color.RED);
						lblMessage.setText("Valeur invalidee!");
						lblMessage.setForeground(Color.RED);
						txt_prixTotal.setText(""+Double.parseDouble(txt_prixUnitaire.getText())*Double.parseDouble(txt_quantite.getText())+" Ar");
					
					}else {
						lblMessage.setText("");
						txt_quantite.setForeground(Color.WHITE);
						txt_prixTotal.setText(""+Double.parseDouble(txt_prixUnitaire.getText())*Double.parseDouble(txt_quantite.getText())+" Ar");
					}
				}
			}
		});
		txt_quantite.setHorizontalAlignment(SwingConstants.CENTER);
		txt_quantite.setForeground(Color.WHITE);
		txt_quantite.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_quantite.setBackground(new Color(0, 0, 51));
		txt_quantite.setSelectedTextColor(Color.ORANGE);
		txt_quantite.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_quantite.setColumns(10);
		
		txt_reference = new JTextField();
		txt_reference.setEditable(false);
		txt_reference.setHorizontalAlignment(SwingConstants.CENTER);
		txt_reference.setForeground(Color.WHITE);
		txt_reference.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_reference.setBackground(new Color(0, 0, 51));
		txt_reference.setSelectedTextColor(Color.ORANGE);
		txt_reference.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_reference.setColumns(10);
		
		txt_TVA = new JTextField();
		txt_TVA.setEditable(false);
		txt_TVA.setHorizontalAlignment(SwingConstants.CENTER);
		txt_TVA.setForeground(Color.WHITE);
		txt_TVA.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_TVA.setBackground(new Color(0, 0, 51));
		txt_TVA.setSelectedTextColor(Color.ORANGE);
		txt_TVA.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_TVA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Produit :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix Unitaire :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("Designation :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("T.V.A :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Quantité :");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("prix Total :");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		txt_prixTotal = new JTextField();
		txt_prixTotal.setEditable(false);
		txt_prixTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txt_prixTotal.setSelectedTextColor(Color.ORANGE);
		txt_prixTotal.setForeground(Color.WHITE);
		txt_prixTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_prixTotal.setColumns(10);
		txt_prixTotal.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_prixTotal.setBackground(new Color(0, 0, 51));
		
		btn_ajout_modif = new JButton("Ajouter");
		btn_ajout_modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_quantite.getForeground()==Color.RED) {
					System.out.println("Notre produit est insuffisant !");
					lblMessage.setText("<html>Notre stock est insuffusant. <br>On ne  peut pas ajouter ce derinier!</html>");
					lblMessage.setForeground(Color.RED);
				}else {
							if(produit.ajoutLigneCommande(txt_reference.getText(), Commande.getSelect(), Double.parseDouble(txt_prixUnitaire.getText()), Double.parseDouble(txt_quantite.getText()), cbx_unite.getSelectedItem().toString())) {
								produit.afficheListe(tableLgCommande, Commande.getSelect(), "");
						}
					}
				}
		});
		btn_ajout_modif.setForeground(Color.WHITE);
		btn_ajout_modif.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_ajout_modif.setBackground(new Color(0, 153, 102));
		
		btn_sup_lg_com = new JButton("Supprimer");
		btn_sup_lg_com.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(produit.supprimerLigneCommande(txt_reference.getText(), Commande.getSelect(),LigneCommande.isElt_select())) {
					produit.afficheListe(tableLgCommande, Commande.getSelect(),"");
				}
			}
		});
		btn_sup_lg_com.setForeground(Color.WHITE);
		btn_sup_lg_com.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_sup_lg_com.setBackground(new Color(204, 0, 0));
		btn_sup_lg_com.setVisible(false);
		
		cbx_unite= new JComboBox();
		cbx_unite.setModel(new DefaultComboBoxModel(new String[] {"KG", "L", "Sacs", "Carton(s)", "Paquet(s)"}));
		
		lblMessage = new JLabel();
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Calibri", Font.BOLD, 14));
		lblMessage.setText("");
		lblMessage.setForeground(Color.WHITE);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(txt_reference, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addGap(62)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_prixUnitaire, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(btn_ajout_modif, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(6)
											.addComponent(txt_designation, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(7)
											.addComponent(txt_quantite, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbx_unite, 0, 44, Short.MAX_VALUE)))
									.addGap(62)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_prixTotal, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
										.addComponent(txt_TVA, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(44)
									.addComponent(btn_sup_lg_com, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))))
					.addGap(6))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_reference, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_prixUnitaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txt_designation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_TVA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_prixTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
									.addGap(12)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btn_sup_lg_com, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_ajout_modif, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
										.addComponent(lblMessage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(cbx_unite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(7)
							.addComponent(txt_quantite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 102));
		
		JLabel lblNewLabel_2 = new JLabel("Liste d'article choisis");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JButton btnNewClient = new JButton("+");
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				UI_ajouterFournisseur d = new UI_ajouterFournisseur();
				UI_ajouterFournisseur.getDialog();
				d.setCommande(true);
				d.fermerFenetre(true);
				String listeFournisseur[] = stock.afficheListe("nom_et_prenom", "fournisseur","client");
				cbxClient.setModel(new DefaultComboBoxModel(listeFournisseur));
			}
		});
		btnNewClient.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewClient.setBackground(new Color(0, 153, 51));
		btnNewClient.setForeground(Color.WHITE);
		String listeFournisseur[] = stock.afficheListe("nom_et_prenom", "fournisseur","client");
		cbxClient = new JComboBox();
		cbxClient.setModel(new DefaultComboBoxModel(listeFournisseur));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(cbxClient, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewClient)
					.addContainerGap())
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewClient)
							.addComponent(cbxClient, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableLgCommande = new TableDark();
		tableLgCommande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMessage.setText("");
			}
		});
		scrollPane_1.setViewportView(tableLgCommande);
		
		lblTotal = new JLabel();
		lblTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.WHITE);
		
		JButton btnSave = new JButton("Enregistrer");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String client = stock.changeNomtoId("reference","fournisseur", "nom_et_prenom", cbxClient.getSelectedItem().toString());					
				try {
					if(com.modifierCommande(Commande.getSelect(), client, LigneCommande.getPrixTotal(Commande.getSelect()))) {
						f.supprimerFournisseur("CLIENT-TEMP", true);
						Menu.getPan_btn().setVisible(true);
						Menu.addPanneau(UI_pan_Commande.getPanel());
						com.afficheListe(UI_pan_Commande.getTable(),"");
						System.out.println((Fournisseur.dernierId_plus_1("commande")-1));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSave.setBackground(new Color(0, 0, 255));
		
		JButton btnAnnulerCmmande = new JButton("Annuler");
		btnAnnulerCmmande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(UI_pan_Liste_Commande.isEtatModifie() == false) {
							
							if(lgCom.supprimerLigneCommande("tout",Commande.getSelect() ,true)) {
							com.supprimerCommande(Commande.getSelect(), true);
							f.supprimerFournisseur("CLIENT-TEMP", true);
							Menu.getPan_btn().setVisible(true);
							Menu.addPanneau(UI_pan_Commande.getPanel());
							com.afficheListe(UI_pan_Commande.getTable(),"");
						}else {
							System.out.println("Une Erreur se produite lors de la suppression");
						}
				}else {
					Menu.getPan_btn().setVisible(true);
					Menu.addPanneau(UI_pan_Commande.getPanel());
					com.afficheListe(UI_pan_Commande.getTable(),"");
				}
				
			}
		});
		btnAnnulerCmmande.setForeground(Color.WHITE);
		btnAnnulerCmmande.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAnnulerCmmande.setBackground(new Color(204, 0, 0));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(btnAnnulerCmmande, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAnnulerCmmande, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		lblResteStock = new JLabel();
		lblResteStock.setForeground(Color.WHITE);
		lblResteStock.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel_3.setLayout(gl_panel_3);
		GroupLayout groupLayout = new GroupLayout(this.panCommande);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
		);
		this.panCommande.setLayout(groupLayout);
		produit.afficheListeProduit(tableProduit,"");
		
		JLabel lblNewLabel = new JLabel("Liste des produits");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
				.addComponent(cbx_categorie, 0, 244, Short.MAX_VALUE)
				.addComponent(txtRecherche, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblResteStock, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbx_categorie, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtRecherche, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResteStock, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
	public static JLabel getLblTotal() {
		return lblTotal;
	}
	public static void setLblTotal(JLabel lblTotal) {
		UI_pan_Liste_Commande.lblTotal = lblTotal;
	}
	public static void refresh() {
		produit.getElement(btn_ajout_modif, txt_reference, Commande.getSelect() ,cbx_categorie, txt_designation, txt_prixUnitaire, txt_quantite, cbx_unite);
		quantite = Double.parseDouble(txt_quantite.getText());
		lblResteStock.setText("<html>Reste du stock selectionnee:<br><p style=\"color:Orange;text-alignement:center\">"+LigneCommande.getQuantite_reste()+"</p> </html");
		txt_prixTotal.setText(""+Double.parseDouble(txt_prixUnitaire.getText())*Double.parseDouble(txt_quantite.getText())+" Ar.");
		if(btn_ajout_modif.getText().equals("Ajouter")) {
				btn_sup_lg_com.setVisible(false);
		}else {
				btn_sup_lg_com.setVisible(true);
		}
	}
	public static boolean isEtatModifie() {
		return etatModifie;
	}
	public static void setEtatModifie(boolean etatModifie) {
		UI_pan_Liste_Commande.etatModifie = etatModifie;
	}
}
