package uiApplication.produit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

import controllers.ControlleurProduit;
import menu.Dialogue;
import uiPersonalisee.ScrollPersonalise;
import uiPersonalisee.TableDark;
import uiPersonalisee.Zonne_d_Image;

public class UI_pan_Liste_Produit extends JPanel {
	static JPanel panel = new JPanel();
	static JLabel lblPan_Liste_Produit;
	
	public static String getLblPan_Liste_Produit() {
		return lblPan_Liste_Produit.getText();
	}
	public static void setLblPan_Liste_Produit(String titre) {
		UI_pan_Liste_Produit.lblPan_Liste_Produit.setText(titre);
	}
	ControlleurProduit produit = new ControlleurProduit();
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		UI_pan_Liste_Produit.panel = panel;
	}
	/**
	 * Create the panel.
	 */
	private static TableDark table;
	private static JTextField txt_recherche;
	
	public static TableDark getTable() {
		return table;
	}
	public static void setTable(TableDark table) {
		UI_pan_Liste_Produit.table = table;
	}
	public UI_pan_Liste_Produit() {
		panel.setBackground(new Color(0, 0, 51));
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI_ajouterProduit d = new UI_ajouterProduit();
				UI_ajouterProduit.getDialog();
				d.fermerFenetre(true);
			
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 102, 204));
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI_modifierProduit modifier = new UI_modifierProduit();
				if(ControlleurProduit.isElt_select()) {
					modifier.fermerFenetre(true);
				}else {
					 Dialogue diag = new Dialogue("Veuillez selectionner d'abord un element ! ",Color.RED);
						diag.fermerFenetre(true);
				}
			}
		});
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setFont(new Font("Arial", Font.PLAIN, 14));
		btnModifier.setBackground(new Color(153, 0, 102));
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ControlleurProduit.isElt_select()) {
					if(produit.supprimerProduit(ControlleurProduit.getReference(),ControlleurProduit.isElt_select())) {
						produit.afficheListe(table,"");
					}else {
						System.out.println("Probleme de suppression");
					}
				}else {
					 Dialogue diag = new Dialogue("Veuillez selectionner d'abord un element ! ",Color.RED);
						diag.fermerFenetre(true);
				}
				
			}
		});
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSupprimer.setBackground(new Color(204, 0, 51));
		
		JButton btnNewButton_1_1 = new JButton("Details");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1_1.setBackground(new Color(0, 102, 51));
		
		JScrollPane scrollPane = new JScrollPane();
		ScrollPersonalise sb = new ScrollPersonalise();
		scrollPane.setVerticalScrollBar(sb);
		
		txt_recherche = new JTextField();
		txt_recherche.setSelectedTextColor(Color.red);
		txt_recherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				produit.afficheListe(table,txt_recherche.getText());
			}
		});

		txt_recherche.setFont(new Font("Cambria", Font.PLAIN, 22));
		txt_recherche.setBackground(new Color(0, 0, 51));
		txt_recherche.setForeground(Color.WHITE);
		txt_recherche.setSelectedTextColor(Color.red);
		txt_recherche.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_recherche.setHorizontalAlignment(SwingConstants.CENTER);
		txt_recherche.setColumns(2);
		
		JLabel lbl_recherche = new JLabel();
		Zonne_d_Image d = new Zonne_d_Image();
		lbl_recherche.setIcon(d.resizeImage("src/designs/images/icon (185).png", null, lbl_recherche, 30));
		lbl_recherche.setMaximumSize(getMaximumSize());
		lbl_recherche.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_recherche.setLabelFor(txt_recherche);
		
		lblPan_Liste_Produit = new JLabel();
		lblPan_Liste_Produit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPan_Liste_Produit.setForeground(Color.WHITE);
		lblPan_Liste_Produit.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(52)
							.addComponent(btnModifier, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(70)
							.addComponent(btnSupprimer, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(55)
							.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPan_Liste_Produit, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lbl_recherche, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_recherche, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txt_recherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbl_recherche, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addComponent(lblPan_Liste_Produit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnModifier, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(1))
		);
		
		table = new TableDark();
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		produit.afficheListe(table,"");
	}
}
