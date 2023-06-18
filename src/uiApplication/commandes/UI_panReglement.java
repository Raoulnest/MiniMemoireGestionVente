package uiApplication.commandes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import models.Commande;
import models.Facture;
import models.Fournisseur;
import models.LigneCommande;
import models.Stock;
import uiPersonalisee.PanneauPersonalise;
import uiPersonalisee.ScrollPersonalise;
import uiPersonalisee.TableDark;

public class UI_panReglement extends JPanel {
	private static JTextField txt_prixTotal;
	private static JTextField txt_numFacture;
	private static JPanel panCommande;
	static LigneCommande produit = new LigneCommande();
	Stock stock = new Stock();
	private static TableDark tableLgCommande;
	static JLabel lblMessage;
	static double quantite;

	Commande com = new Commande();
	LigneCommande lgCom = new LigneCommande();
	Fournisseur f = new Fournisseur();
	Facture fact = new Facture();
	
	private static boolean etatModifie = false;
	private JTextField txtMontantApayer;
	private JTextField txtMontantArendre;
	private JTextField txtCommande;
	private JTextField txtClient;
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
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,51));
		
		JScrollPane scrlListeProdCommande = new JScrollPane();
		scrlListeProdCommande.setVerticalScrollBar(sb);
		
		txt_prixTotal = new JTextField();
		txt_prixTotal.setEditable(false);
		txt_prixTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txt_prixTotal.setForeground(Color.ORANGE);
		txt_prixTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_prixTotal.setBackground(new Color(0, 0, 51));
		txt_prixTotal.setSelectedTextColor(Color.ORANGE);
		txt_prixTotal.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_prixTotal.setColumns(10);
		
		txt_numFacture = new JTextField();
		txt_numFacture.setEditable(false);
		txt_numFacture.setHorizontalAlignment(SwingConstants.CENTER);
		txt_numFacture.setForeground(Color.WHITE);
		txt_numFacture.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_numFacture.setBackground(new Color(0, 0, 51));
		txt_numFacture.setSelectedTextColor(Color.ORANGE);
		txt_numFacture.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txt_numFacture.setColumns(10);
		txt_numFacture.setText("FACT_0"+Fournisseur.dernierId_plus_1("facture"));
		
		JLabel lblNewLabel_1 = new JLabel("Facture numéro :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix Total :");
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
							.addComponent(txt_numFacture, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_prixTotal, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addGap(174)))
					.addGap(6))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(15)
									.addComponent(lblNewLabel_1_1))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(17)
									.addComponent(lblNewLabel_1))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_prixTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_numFacture, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(81)
					.addComponent(lblMessage))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 102));

		txtCommande = new JTextField();
		txtCommande.setSelectedTextColor(Color.ORANGE);
		txtCommande.setHorizontalAlignment(SwingConstants.CENTER);
		txtCommande.setForeground(Color.WHITE);
		txtCommande.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCommande.setEditable(false);
		txtCommande.setColumns(10);
		txtCommande.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtCommande.setBackground(new Color(0, 0, 51));
		
		JLabel lblNewLabel_1_2 = new JLabel("Commande :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Client :");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		txtClient = new JTextField();
		txtClient.setSelectedTextColor(Color.ORANGE);
		txtClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtClient.setForeground(Color.WHITE);
		txtClient.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtClient.setEditable(false);
		txtClient.setColumns(10);
		txtClient.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtClient.setBackground(new Color(0, 0, 51));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 542, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCommande, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtClient, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrlListeProdCommande, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCommande, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addGap(9)
								.addComponent(txtClient, 0, 0, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1_2)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrlListeProdCommande, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
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
		scrlListeProdCommande.setViewportView(tableLgCommande);
		
		JButton btnRegler = new JButton("Regler");
		btnRegler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(txtMontantApayer.getText()) >= Double.parseDouble(txt_prixTotal.getText())) {
					if(fact.ajoutFacture(Commande.getSelect(), "Reglée", Double.parseDouble(txtMontantApayer.getText()), Double.parseDouble(txtMontantArendre.getText()))) {
						com.modifierCommande(Commande.getSelect(), "Traitée");
					}
				}else {
					if(fact.ajoutFacture(Commande.getSelect(), "Non Reglée", Double.parseDouble(txtMontantApayer.getText()), Double.parseDouble(txtMontantArendre.getText()))) {
						com.modifierCommande(Commande.getSelect(), "Non Reglée ");
					}
				}
			}
		});
		btnRegler.setForeground(Color.WHITE);
		btnRegler.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnRegler.setBackground(new Color(0, 0, 255));
		
		JButton btnAnnulerCmmande = new JButton("Annuler");
		btnAnnulerCmmande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAnnulerCmmande.setForeground(Color.WHITE);
		btnAnnulerCmmande.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAnnulerCmmande.setBackground(new Color(204, 0, 0));
		
		txtMontantApayer = new JTextField();
		txtMontantApayer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtMontantApayer.getText().equals("")) {
					System.out.println("Notre programme n'effectue pas des calculs avec le nombre null");
				}else {
					if(Double.parseDouble(txtMontantApayer.getText()) == Double.parseDouble(txt_prixTotal.getText())) {
						txtMontantApayer.setForeground(Color.GREEN);
						txtMontantArendre.setForeground(Color.GREEN);
						txtMontantArendre.setText(""+(Double.parseDouble(txt_prixTotal.getText()) - Double.parseDouble(txtMontantApayer.getText())));
					
					}else if(Double.parseDouble(txtMontantApayer.getText()) <= 0 || Double.parseDouble(txtMontantApayer.getText()) < Double.parseDouble(txt_prixTotal.getText()) ) {
						txtMontantApayer.setForeground(Color.RED);
						txtMontantArendre.setText(""+(Double.parseDouble(txt_prixTotal.getText()) - Double.parseDouble(txtMontantApayer.getText())));
						txtMontantArendre.setForeground(Color.RED);
						
					}else {
						txtMontantApayer.setForeground(Color.BLUE);
						txtMontantArendre.setText(""+(Double.parseDouble(txt_prixTotal.getText()) - Double.parseDouble(txtMontantApayer.getText())));
						txtMontantArendre.setForeground(Color.YELLOW);
						
					}
				}
			}
		});
		
		txtMontantApayer.setSelectedTextColor(Color.ORANGE);
		txtMontantApayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtMontantApayer.setForeground(Color.WHITE);
		txtMontantApayer.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtMontantApayer.setColumns(10);
		txtMontantApayer.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtMontantApayer.setBackground(new Color(0, 0, 51));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Montant  à payer :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Reste :");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		txtMontantArendre = new JTextField();
		txtMontantArendre.setSelectedTextColor(Color.ORANGE);
		txtMontantArendre.setHorizontalAlignment(SwingConstants.CENTER);
		txtMontantArendre.setForeground(new Color(204, 153, 0));
		txtMontantArendre.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtMontantArendre.setEditable(false);
		txtMontantArendre.setColumns(10);
		txtMontantArendre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtMontantArendre.setBackground(new Color(0, 0, 51));
		txtMontantApayer.setForeground(Color.GREEN);
	
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1)
							.addGap(7)
							.addComponent(txtMontantApayer, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnAnnulerCmmande, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)))
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel_1_1_1_1)
							.addGap(2)
							.addComponent(txtMontantArendre, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRegler, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtMontantApayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(6)
								.addComponent(lblNewLabel_1_1_1_1))
							.addComponent(txtMontantArendre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1_1))
					.addGap(27)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnulerCmmande, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegler, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
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
	public JTextField getTxtClient() {
		return txtClient;
	}
	public JTextField getTxtCommande() {
		return txtCommande;
	}
	public void setTxtCommande(JTextField txtCommande) {
		this.txtCommande = txtCommande;
	}
	public void setTxtClient(JTextField txtClient) {
		this.txtClient = txtClient;
	}
	public static JTextField getTxt_prixTotal() {
		return txt_prixTotal;
	}
	public static void setTxt_prixTotal(JTextField txt_prixTotal) {
		UI_panReglement.txt_prixTotal = txt_prixTotal;
	}
}
