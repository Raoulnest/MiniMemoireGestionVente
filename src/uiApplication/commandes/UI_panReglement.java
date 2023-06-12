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

public class UI_panReglement extends JPanel {
	private static JTextField txt_prixUnitaire;
	private static JTextField txt_reference;
	private static JPanel panCommande;
	static LigneCommande produit = new LigneCommande();
	Stock stock = new Stock();
	private static TableDark tableLgCommande;
	static JLabel lblMessage;
	static double quantite;

	Commande com = new Commande();
	LigneCommande lgCom = new LigneCommande();
	Fournisseur f = new Fournisseur();
	private static boolean etatModifie = false;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public static JPanel getPanel() {
		return panCommande;
	}
	public static TableDark getTableLgCommande() {
		return tableLgCommande;
	}
	public void setTableLgCommande(TableDark tableLgCommande) {
		UI_panReglement.tableLgCommande = tableLgCommande;
	}
	public static JLabel getLblMessage() {
		return lblMessage;
	}
	public static void setLblMessage(JLabel lblMessage) {
		UI_panReglement.lblMessage = lblMessage;
	}
	public static void setPanel(JPanel panel) {
		UI_panReglement.panCommande = panel;
	}
	@SuppressWarnings("unchecked")
	public UI_panReglement() {
		panCommande = new JPanel();
		panCommande.setBackground(new Color(0, 0, 102));
		PanneauPersonalise panel_3 = new PanneauPersonalise(20,20,20,20,new Color(0,0,51));
		ScrollPersonalise sb = new ScrollPersonalise();;

		
		String listeCategorie[] = stock.afficheListe("nomCategorie", "categorie","");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,51));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBar(sb);
		
		txt_prixUnitaire = new JTextField();
		txt_prixUnitaire.setEditable(false);
		txt_prixUnitaire.setHorizontalAlignment(SwingConstants.CENTER);
		txt_prixUnitaire.setForeground(Color.WHITE);
		txt_prixUnitaire.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_prixUnitaire.setBackground(new Color(0, 0, 51));
		txt_prixUnitaire.setSelectedTextColor(Color.ORANGE);
		txt_prixUnitaire.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_prixUnitaire.setColumns(10);
		
		txt_reference = new JTextField();
		txt_reference.setEditable(false);
		txt_reference.setHorizontalAlignment(SwingConstants.CENTER);
		txt_reference.setForeground(Color.WHITE);
		txt_reference.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_reference.setBackground(new Color(0, 0, 51));
		txt_reference.setSelectedTextColor(Color.ORANGE);
		txt_reference.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_reference.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Facture numéro :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date de facturation :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
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
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_reference, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_prixUnitaire, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addGap(174)))
					.addGap(6))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_reference, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
									.addComponent(txt_prixUnitaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1_1))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(17)
							.addComponent(lblNewLabel_1)))
					.addGap(81)
					.addComponent(lblMessage))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 102));
		
		JLabel lblNewLabel_2 = new JLabel("Liste d'article choisis");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		String listeFournisseur[] = stock.afficheListe("nom_et_prenom", "fournisseur","client");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(381, Short.MAX_VALUE))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 542, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
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
		
		JButton btnSave = new JButton("Regler");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSave.setBackground(new Color(0, 0, 255));
		
		JButton btnAnnulerCmmande = new JButton("Annuler");
		btnAnnulerCmmande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(UI_panReglement.isEtatModifie() == false) {
							
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
		
		textField = new JTextField();
		textField.setSelectedTextColor(Color.ORANGE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField.setBackground(new Color(0, 0, 51));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Montant  à rendre :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Reste à payer :");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setSelectedTextColor(Color.ORANGE);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_1.setBackground(new Color(0, 0, 51));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1)
							.addGap(7)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnAnnulerCmmande, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addGap(177)))
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel_1_1_1_1)
							.addGap(2)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(6)
								.addComponent(lblNewLabel_1_1_1_1))
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1_1))
					.addGap(27)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnulerCmmande, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addGap(7))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_panCommande = new GroupLayout(panCommande);
		gl_panCommande.setHorizontalGroup(
			gl_panCommande.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_panCommande.setVerticalGroup(
			gl_panCommande.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		panCommande.setLayout(gl_panCommande);
	}
	public static boolean isEtatModifie() {
		return etatModifie;
	}
	public static void setEtatModifie(boolean etatModifie) {
		UI_panReglement.etatModifie = etatModifie;
	}
}
