package uiApplication.commandes;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import uiApplication.fournisseurs.UI_pan_Liste_Fournisseur;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controllers.ControlleurFournisseur;
import controllers.ControlleurProduit;

public class UI_pan_Liste_Commande extends JPanel {
	private JTable tableProduit;
	private DefaultTableModel defaultTableModel;
	private JTextField txtRecherche;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtClient;
	private static JPanel panCommande;
	private JTextField textField;
	ControlleurProduit ctrlF = new ControlleurProduit();

	/**
	 * Create the panel.
	 */
	
	public static JPanel getPanel() {
		return panCommande;
	}
	public static void setPanel(JPanel panel) {
		UI_pan_Liste_Commande.panCommande = panel;
	}
	
	public UI_pan_Liste_Commande() {
		panCommande = new JPanel();
		panCommande.setBackground(new Color(0, 0, 102));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 102));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBorder(UIManager.getBorder("Table.cellNoFocusBorder"));
		
		JScrollPane scrollPane = new JScrollPane();
		tableProduit = new JTable();
		
		scrollPane.setViewportView(tableProduit);

		ctrlF.afficheListeListeProduit(tableProduit,"");
		
		txtRecherche = new JTextField();
		txtRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecherche.setText("Recherche produit");
		txtRecherche.setForeground(Color.WHITE);
		txtRecherche.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtRecherche.setBackground(new Color(0, 0, 51));
		txtRecherche.setSelectedTextColor(Color.ORANGE);
		txtRecherche.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtRecherche.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		
		JScrollPane scrollPane_1 = new JScrollPane();
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
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setBackground(new Color(0, 0, 51));
		textField_1.setSelectedTextColor(Color.ORANGE);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_2.setBackground(new Color(0, 0, 51));
		textField_2.setSelectedTextColor(Color.ORANGE);
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_3.setBackground(new Color(0, 0, 51));
		textField_3.setSelectedTextColor(Color.ORANGE);
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_4.setBackground(new Color(0, 0, 51));
		textField_4.setSelectedTextColor(Color.ORANGE);
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_5.setBackground(new Color(0, 0, 51));
		textField_5.setSelectedTextColor(Color.ORANGE);
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Produit :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID Produit :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("ID Produit :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID Produit :");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("ID Produit :");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ID Produit :");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setSelectedTextColor(Color.ORANGE);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField.setBackground(new Color(0, 0, 51));
		
		JButton btnNewButton_1_1 = new JButton("Ajouter");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1_1.setBackground(new Color(0, 51, 51));
		
		JButton btnNewButton_1_1_1 = new JButton("Supprimer");
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1_1_1.setBackground(new Color(204, 0, 0));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(69)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(69)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(69)
					.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 102));
		
		txtClient = new JTextField();
		txtClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtClient.setText("CLIENT_0001");
		txtClient.setForeground(Color.WHITE);
		txtClient.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtClient.setBackground(new Color(0, 0, 51));
		txtClient.setSelectedTextColor(Color.ORANGE);
		txtClient.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtClient.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Liste d'article choisis");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
					.addComponent(txtClient, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(0, 0, 255));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(204, 0, 0));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Liste des produits existant");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3_1 = new JLabel("Reste du stock : ");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtRecherche, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, 109, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRecherche, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
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
	}
}
