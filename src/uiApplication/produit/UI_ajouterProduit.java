package uiApplication.produit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import menu.Menu;
import models.Fournisseur;
import models.Stock;
import uiApplication.fournisseurs.UI_ajouterFournisseur;
import uiPersonalisee.ControlFenetre;
import uiPersonalisee.ControlImageChooser;
import uiPersonalisee.PanneauPersonalise;
public class UI_ajouterProduit extends JDialog {

	private final PanneauPersonalise contentPanel = new PanneauPersonalise(10,10,10,10,new Color(0, 0, 51));
	private static JDialog dialog ;
	Stock produit = new Stock();
	public static JDialog getDialog() {
		return dialog;
	}
	public void fermerFenetre(boolean fen1) {
        dialog.setVisible(fen1);
	}
	public static void setDialog(JDialog dialog) {
		UI_ajouterProduit.dialog = dialog;
	}
	private JButton btnEnregistrer;
	private PanneauPersonalise buttonPane;
	private static String contenuMessage;
	private JButton btnRetour;
	File file = null;
	Image image = null;
	JLabel lbl_sary;
	
	private JTable table;
	private static double X,Y,x,y;
	private JTextField designation;
	static JComboBox categorie;
	static JComboBox cbxfournisseur;
	private JTextField prixUnitaire;
	private JTextField quantite;
	private JComboBox unite;
	private PanneauPersonalise panel;
	private PanneauPersonalise panImageView;
	private JTextField textField;
	
	public static String getContenuMessage() {
		return contenuMessage;
	}
	public void setContenuMessage(String contenuMessage) {
		UI_ajouterProduit.contenuMessage = contenuMessage;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	UI_ajouterProduit d = new UI_ajouterProduit();
                d.dialog.setVisible(true);
            }
        });
	}
	/**
	 * Create the dialog.
	 */
	public UI_ajouterProduit() {
		initialise();
	}
	public void initialise() {
		dialog = new JDialog();
		dialog.setModal(true);
		dialog.setUndecorated(true);
		dialog.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.getContentPane().setBackground(new Color(0, 102, 153));
		dialog.setSize(  756, 413);
		dialog.setLocationRelativeTo(null);
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				X = (int)e.getXOnScreen()-x;
				Y = (int)e.getYOnScreen()-y;
				dialog.setBounds((int)X, (int) Y, 756, 413);
			}
		});
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		contentPanel.setBorder(null);
		{
			buttonPane = new PanneauPersonalise(10,10,10,10,new Color(0, 0, 51));
			buttonPane.setBackground(new Color(0, 0, 51));
			{
				btnEnregistrer = new JButton("Enregistrer");
				btnEnregistrer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						String ref = reference.getText();
						String des = designation.getText();
						String idCategorie = produit.changeNomtoId("reference", "categorie","nomCategorie", categorie.getSelectedItem().toString());
						String idFournisseur = produit.changeNomtoId("reference", "fournisseur","nom_et_prenom", cbxfournisseur.getSelectedItem().toString());
						double pUnitaire = Double.parseDouble(prixUnitaire.getText());
						double quant = Double.parseDouble(quantite.getText());
						String unit = unite.getSelectedItem().toString();
						String image = "src/uiApplication/pictures/produits/"+ControlImageChooser.getFileName()+"".replace('\\', '/');
						if(produit.ajoutProduit(des, idCategorie, idFournisseur, pUnitaire, quant, unit, image)) {
							System.out.println("Produit a  été ajouté avec succès! ");
						}else {
							System.out.println("Erreur lors de l'ajout dans la  table ");
						}
					}
				});
				btnEnregistrer.setForeground(Color.WHITE);
				btnEnregistrer.setFont(new Font("Arial", Font.PLAIN, 14));
				btnEnregistrer.setBackground(new Color(0, 102, 204));
				btnEnregistrer.setActionCommand("OK");
				getRootPane().setDefaultButton(btnEnregistrer);
			}
			btnRetour = new JButton("Annuler");
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fermerFenetre(false);
				}
			});
			btnRetour.setForeground(Color.WHITE);
			btnRetour.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRetour.setBackground(new Color(204, 0, 0));
			btnRetour.setActionCommand("OK");
		}
		
		JLabel message = new JLabel("");
		message.setForeground(Color.WHITE);
		message.setFont(new Font("Tahoma", Font.PLAIN, 14));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(dialog.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contentPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 757, Short.MAX_VALUE)
						.addComponent(buttonPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
						.addComponent(message, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(message, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGap(6)
					.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(411)
					.addComponent(btnEnregistrer, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRetour)
						.addComponent(btnEnregistrer)))
		);
		buttonPane.setLayout(gl_buttonPane);;
		
		JPanel panBtnExit = new JPanel();
		panBtnExit.setBounds(0, 0, 757, 25);
		
		designation = new JTextField();
		designation.setBounds(14, 109, 241, 31);
		designation.setFont(new Font("Cambria", Font.PLAIN, 22));
		designation.setBackground(new Color(0, 0, 51));
		designation.setForeground(Color.WHITE);
		designation.setSelectedTextColor(Color.red);
		designation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		designation.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Désignation");
		lblNewLabel_1_1.setBounds(14, 83, 241, 25);
		lblNewLabel_1_1.setLabelFor(designation);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("Catégorie");
		lblNewLabel_1_2.setBounds(291, 84, 231, 25);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panBtnExit.setLayout(new BorderLayout(0, 0));
		
		ControlFenetre panel_2 = new ControlFenetre(dialog);
		panBtnExit.add(panel_2, BorderLayout.CENTER);
		
		categorie = new JComboBox();
		categorie.setBounds(291, 115, 231, 27);
		Stock st = new Stock();
		String listeCategorie[] = st.afficheListe("nomCategorie", "categorie","");
		categorie.setModel(new DefaultComboBoxModel<String>(listeCategorie));
		categorie.setForeground(Color.BLUE);
		categorie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setLabelFor(categorie);
		
		cbxfournisseur = new JComboBox();
		cbxfournisseur.setBounds(291, 178, 231, 27);
		String listeFournisseur[] = st.afficheListe("nom_et_prenom", "fournisseur","fournisseur");
		cbxfournisseur.setModel(new DefaultComboBoxModel(listeFournisseur));
		cbxfournisseur.setForeground(Color.BLUE);
		cbxfournisseur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fournisseur");
		lblNewLabel_1_2_1.setBounds(291, 147, 241, 34);
		lblNewLabel_1_2_1.setLabelFor(cbxfournisseur);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		prixUnitaire = new JTextField();
		prixUnitaire.setBounds(14, 241, 241, 31);
		prixUnitaire.setFont(new Font("Cambria", Font.PLAIN, 22));
		prixUnitaire.setBackground(new Color(0, 0, 51));
		prixUnitaire.setForeground(Color.WHITE);
		prixUnitaire.setSelectedTextColor(Color.red);
		prixUnitaire.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		prixUnitaire.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prix Unitaire");
		lblNewLabel_1_3.setBounds(14, 211, 241, 31);
		lblNewLabel_1_3.setLabelFor(prixUnitaire);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantité");
		lblNewLabel_1_1_1.setBounds(291, 211, 109, 31);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		quantite = new JTextField();
		quantite.setBounds(291, 241, 109, 31);
		quantite.setFont(new Font("Cambria", Font.PLAIN, 22));
		quantite.setBackground(new Color(0, 0, 51));
		quantite.setForeground(Color.WHITE);
		quantite.setSelectedTextColor(Color.red);
		quantite.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		lblNewLabel_1_1_1.setLabelFor(quantite);
		quantite.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Unité");
		lblNewLabel_1_1_1_1.setBounds(423, 211, 109, 31);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		unite = new JComboBox();
		unite.setBounds(423, 241, 109, 29);
		unite.setModel(new DefaultComboBoxModel(new String[] {"", "KG", "T", "Sacs", "Carton(s)", "Paquet(s)", "Bal(s)"}));
		
		panel = new PanneauPersonalise(10,10,10,10,new Color(0, 102, 153));
		panel.setBounds(14, 31, 729, 31);
		
		JLabel lblTitre = new JLabel("Ajouter nouveau produit");
		panel.add(lblTitre);
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		panImageView = new PanneauPersonalise(10,10,10,10,new Color(0, 0, 51));
		panImageView.setBounds(573, 110, 170, 162);
		
		JButton btnImage = new JButton("Image du produit");
		btnImage.setBounds(573, 291, 171, 29);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlImageChooser ctrl = new ControlImageChooser();
				try {
					ctrl.OuvrirImage(panImageView,lbl_sary,file,image);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnImage.setBackground(new Color(0, 102, 102));
		btnImage.setForeground(Color.WHITE);
		btnImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panImageView.setLayout(new BorderLayout(0, 0));
		
		lbl_sary = new JLabel("");
		lbl_sary.setIcon(new ImageIcon(UI_ajouterProduit.class.getResource("/designs/images/icon (188).png")));
		lbl_sary.setHorizontalAlignment(SwingConstants.CENTER);
		panImageView.add(lbl_sary, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(panBtnExit);
		contentPanel.add(panel);
		contentPanel.add(lblNewLabel_1_1);
		contentPanel.add(lblNewLabel_1_2);
		contentPanel.add(categorie);
		contentPanel.add(prixUnitaire);
		contentPanel.add(lblNewLabel_1_3);
		contentPanel.add(designation);
		contentPanel.add(lblNewLabel_1_2_1);
		contentPanel.add(cbxfournisseur);
		contentPanel.add(quantite);
		contentPanel.add(lblNewLabel_1_1_1);
		contentPanel.add(unite);
		contentPanel.add(lblNewLabel_1_1_1_1);
		contentPanel.add(panImageView);
		contentPanel.add(btnImage);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.setBounds(526, 111, 35, 31);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UI_ajouterFournisseur d = new UI_ajouterFournisseur();
				Menu.setTypeCollaborateur("Fournisseur");
				d.setCommande(true);
				UI_ajouterFournisseur.getDialog();
				d.fermerFenetre(true);
				String listeFournisseur[] = produit.afficheListe("nom_et_prenom", "fournisseur","fournisseur");
				cbxfournisseur.setModel(new DefaultComboBoxModel(listeFournisseur));
				
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(0, 102, 204));
		btnNewButton_1.setBounds(526, 176, 35, 31);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Prix ");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(14, 141, 241, 34);
		contentPanel.add(lblNewLabel_1_3_1);
		
		textField = new JTextField();
		textField.setSelectedTextColor(Color.RED);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Cambria", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField.setBackground(new Color(0, 0, 51));
		textField.setBounds(14, 174, 241, 31);
		contentPanel.add(textField);
		dialog.getContentPane().setLayout(groupLayout);
		
	}
}
