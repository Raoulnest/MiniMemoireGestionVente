package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controllers.ControlleurFournisseur;
import controllers.ControlleurProduit;
import uiApplication.fournisseurs.UI_pan_Liste_Fournisseur;
import uiApplication.produit.UI_pan_Liste_Produit;
import uiPersonalisee.PanneauPersonalise;

public class Pan_dashboard extends JPanel {
	/**
	 * Create the panel.
	 */
	static JPanel panel = new JPanel();
	
ControlleurFournisseur co =new ControlleurFournisseur();
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		Pan_dashboard.panel = panel;
	}
	public Pan_dashboard() {
		initialise();
	}
	private static JButton btnProduit;
	private JLabel pan_facture;
	public static JButton getBtnProduit() {
		return btnProduit;
	}
	public static void setBtnProduit(JButton btnProduit) {
		Pan_dashboard.btnProduit = btnProduit;
	}
	public void initialise() {
		panel.setBackground(new Color(0, 0, 41));
		JLabel lblApkGest = new JLabel("Application GESTION DES STOCKS");
		lblApkGest.setHorizontalAlignment(SwingConstants.CENTER);
		lblApkGest.setForeground(Color.WHITE);
		lblApkGest.setFont(new Font("Tahoma", Font.PLAIN, 28));

		PanneauPersonalise pan_statistique = new PanneauPersonalise(10,10,10,10,new Color(0,51,110));
		pan_statistique.setForeground(Color.WHITE);
		pan_statistique.setBorder(new TitledBorder(null, "Statistique", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		pan_statistique.setBackground(new Color(0,51,100));
		
		PanneauPersonalise panMembre = new PanneauPersonalise(50,10,10,50,new Color(0,51,110));
		
		panMembre.setForeground(Color.WHITE);
		panMembre.setBorder(null);
		panMembre.setBackground(new Color(0,51,110));
		
		JLabel pan_produit = new JLabel("PRODUITS");
		pan_produit.setHorizontalAlignment(SwingConstants.CENTER);
		pan_produit.setForeground(Color.WHITE);
		pan_produit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnProduit = new JButton();
		
		btnProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnProduit.setForeground(Color.WHITE);
		btnProduit.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnProduit.setBackground(new Color(0,51,100));
		GroupLayout gl_panMembre = new GroupLayout(panMembre);
		gl_panMembre.setHorizontalGroup(
			gl_panMembre.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre.createSequentialGroup()
					.addContainerGap()
					.addComponent(pan_produit, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnProduit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
		);
		gl_panMembre.setVerticalGroup(
			gl_panMembre.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre.createSequentialGroup()
					.addComponent(pan_produit, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnProduit, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		panMembre.setLayout(gl_panMembre);
		
		PanneauPersonalise panMembre_1 = new PanneauPersonalise(50, 10, 10, 50, new Color(0,51,110));
		
		JLabel pan_categorie = new JLabel("CATEGORIES");
		pan_categorie.setHorizontalAlignment(SwingConstants.CENTER);
		pan_categorie.setForeground(Color.WHITE);
		pan_categorie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnCategorie = new JButton();
		btnCategorie.setText("0");
		btnCategorie.setForeground(Color.WHITE);
		btnCategorie.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnCategorie.setBackground(new Color(0,51,100));
		GroupLayout gl_panMembre_1 = new GroupLayout(panMembre_1);
		gl_panMembre_1.setHorizontalGroup(
			gl_panMembre_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(pan_categorie, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnCategorie, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
		);
		gl_panMembre_1.setVerticalGroup(
			gl_panMembre_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre_1.createSequentialGroup()
					.addComponent(pan_categorie, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCategorie, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		panMembre_1.setLayout(gl_panMembre_1);
		
		PanneauPersonalise panMembre_2 = new PanneauPersonalise(50, 10, 10, 50, new Color(0,51,110));
		
		JLabel pan_vente = new JLabel("VENTES");
		pan_vente.setHorizontalAlignment(SwingConstants.CENTER);
		pan_vente.setForeground(Color.WHITE);
		pan_vente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnVente = new JButton();
		btnVente.setText("0");
		btnVente.setForeground(Color.WHITE);
		btnVente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnVente.setBackground(new Color(0,51,100));
		GroupLayout gl_panMembre_2 = new GroupLayout(panMembre_2);
		gl_panMembre_2.setHorizontalGroup(
			gl_panMembre_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(pan_vente, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnVente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
		);
		gl_panMembre_2.setVerticalGroup(
			gl_panMembre_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre_2.createSequentialGroup()
					.addComponent(pan_vente, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVente, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		panMembre_2.setLayout(gl_panMembre_2);
		
		PanneauPersonalise panMembre_4 = new PanneauPersonalise(50, 10, 10, 50, new Color(0,51,110));
		
		pan_facture = new JLabel("FACTURES");
		pan_facture.setHorizontalAlignment(SwingConstants.CENTER);
		pan_facture.setForeground(Color.WHITE);
		pan_facture.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnFacture = new JButton();
		btnFacture.setText("0");
		btnFacture.setForeground(Color.WHITE);
		btnFacture.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnFacture.setBackground(new Color(0,51,100));
		GroupLayout gl_panMembre_4 = new GroupLayout(panMembre_4);
		gl_panMembre_4.setHorizontalGroup(
			gl_panMembre_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(pan_facture, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnFacture, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
		);
		gl_panMembre_4.setVerticalGroup(
			gl_panMembre_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMembre_4.createSequentialGroup()
					.addComponent(pan_facture, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFacture, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		panMembre_4.setLayout(gl_panMembre_4);
		
		PanneauPersonalise panMembre_4_1 = new PanneauPersonalise(50, 10, 10, 50, new Color(0,51,110));
		
		JLabel pan_fournisseur = new JLabel("FOURNISSEURS");
		pan_fournisseur.setHorizontalAlignment(SwingConstants.CENTER);
		pan_fournisseur.setForeground(Color.WHITE);
		pan_fournisseur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnFournisseur = new JButton();
		btnFournisseur.setText("0");
		btnFournisseur.setForeground(Color.WHITE);
		btnFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnFournisseur.setBackground(new Color(0,51,100));
		GroupLayout gl_panMembre_4_1 = new GroupLayout(panMembre_4_1);
		gl_panMembre_4_1.setHorizontalGroup(
			gl_panMembre_4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 224, Short.MAX_VALUE)
				.addGroup(gl_panMembre_4_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(pan_fournisseur, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnFournisseur, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
		);
		gl_panMembre_4_1.setVerticalGroup(
			gl_panMembre_4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 121, Short.MAX_VALUE)
				.addGroup(gl_panMembre_4_1.createSequentialGroup()
					.addComponent(pan_fournisseur, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFournisseur, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		panMembre_4_1.setLayout(gl_panMembre_4_1);
		
		PanneauPersonalise panMembre_4_2 = new PanneauPersonalise(50, 10, 10, 50, new Color(0,51,110));
		
		JLabel pan_commande = new JLabel("COMMANDES");
		pan_commande.setHorizontalAlignment(SwingConstants.CENTER);
		pan_commande.setForeground(Color.WHITE);
		pan_commande.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnCommande = new JButton();
		btnCommande.setText("0");
		btnCommande.setForeground(Color.WHITE);
		btnCommande.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnCommande.setBackground(new Color(0,51,100));
		GroupLayout gl_panMembre_4_2 = new GroupLayout(panMembre_4_2);
		gl_panMembre_4_2.setHorizontalGroup(
			gl_panMembre_4_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 224, Short.MAX_VALUE)
				.addGroup(gl_panMembre_4_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(pan_commande, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnCommande, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
		);
		gl_panMembre_4_2.setVerticalGroup(
			gl_panMembre_4_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 121, Short.MAX_VALUE)
				.addGroup(gl_panMembre_4_2.createSequentialGroup()
					.addComponent(pan_commande, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCommande, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		panMembre_4_2.setLayout(gl_panMembre_4_2);
		GroupLayout gl_pan_dashboard = new GroupLayout(panel);
		gl_pan_dashboard.setHorizontalGroup(
			gl_pan_dashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_dashboard.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pan_dashboard.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pan_dashboard.createSequentialGroup()
							.addGroup(gl_pan_dashboard.createParallelGroup(Alignment.TRAILING)
								.addComponent(pan_statistique, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
								.addComponent(lblApkGest, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_pan_dashboard.createSequentialGroup()
							.addComponent(panMembre_4, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panMembre_4_1, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panMembre_4_2, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_pan_dashboard.createSequentialGroup()
							.addComponent(panMembre, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(panMembre_1, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panMembre_2, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
							.addGap(8))))
		);
		gl_pan_dashboard.setVerticalGroup(
			gl_pan_dashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_dashboard.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblApkGest)
					.addGap(24)
					.addGroup(gl_pan_dashboard.createParallelGroup(Alignment.LEADING)
						.addComponent(panMembre_2, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
						.addComponent(panMembre, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
						.addComponent(panMembre_1, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_pan_dashboard.createParallelGroup(Alignment.LEADING)
						.addComponent(panMembre_4_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panMembre_4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panMembre_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(pan_statistique, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
		);
		panel.setLayout(gl_pan_dashboard);
		btnProduit.setText(""+(ControlleurProduit.getCompteProduit()));
	}
}
