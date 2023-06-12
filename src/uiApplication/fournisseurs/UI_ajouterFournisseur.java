package uiApplication.fournisseurs;

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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import models.Fournisseur;
import uiPersonalisee.ControlFenetre;
import uiPersonalisee.PanneauPersonalise;
public class UI_ajouterFournisseur extends JDialog {

	private final PanneauPersonalise contentPanel = new PanneauPersonalise(10,10,10,10,new Color(0, 0, 51));
	private static JDialog dialog ;
	Fournisseur collaborateur = new Fournisseur();
	public static JDialog getDialog() {
		return dialog;
	}
	public void fermerFenetre(boolean fen1) {
        dialog.setVisible(fen1);
	}
	public static void setDialog(JDialog dialog) {
		UI_ajouterFournisseur.dialog = dialog;
	}
	private JButton btnEnregistrer;
	private PanneauPersonalise buttonPane;
	private static String contenuMessage;
	private JButton btnRetour;
	File file = null;
	Image image = null;
	
	private JTable table;
	private static double X,Y,x,y;
	private JTextField nom_et_prenom;
	private JTextField nom_entreprise;
	private JTextField telephone;
	private JTextField emailF;
	private PanneauPersonalise panel;
	private JTextField adresseF;
	private JTextField txtReference;
	static boolean commande = false;
	
	public static boolean isCommande() {
		return commande;
	}
	public static void setCommande(boolean commande) {
		UI_ajouterFournisseur.commande = commande;
	}
	public static String getContenuMessage() {
		return contenuMessage;
	}
	public void setContenuMessage(String contenuMessage) {
		UI_ajouterFournisseur.contenuMessage = contenuMessage;
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
            java.util.logging.Logger.getLogger(UI_ajouterFournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterFournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterFournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_ajouterFournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	UI_ajouterFournisseur d = new UI_ajouterFournisseur();
                d.dialog.setVisible(true);
            }
        });
	}
	/**
	 * Create the dialog.
	 */
	public UI_ajouterFournisseur() {
		initialise();
	}
	public void initialise() {
		dialog = new JDialog();
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
						String nom = nom_et_prenom.getText();
						String nomE = nom_entreprise.getText();
						String adresse = adresseF.getText();
						String mail = emailF.getText();
						int phone = Integer.parseInt(telephone.getText());
						if(collaborateur.ajoutFournisseur(nomE, adresse, nom, phone, mail, true)) {
							if(commande == false) {
								System.out.println("collaborateur a  été ajouté avec succès! ");
							}else {
								fermerFenetre(false);
								System.out.println("collaborateur a  été ajouté avec succès! ");
							}
							
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
		
		JLabel lblNewLabel_1 = new JLabel("Nom et Prénoms");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		nom_et_prenom = new JTextField();
		nom_et_prenom.setFont(new Font("Cambria", Font.PLAIN, 22));
		nom_et_prenom.setBackground(new Color(0, 0, 51));
		nom_et_prenom.setForeground(Color.WHITE);
		nom_et_prenom.setSelectedTextColor(Color.red);
		nom_et_prenom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		lblNewLabel_1.setLabelFor(nom_et_prenom);
		nom_et_prenom.setColumns(10);
		
		nom_entreprise = new JTextField();
		nom_entreprise.setFont(new Font("Cambria", Font.PLAIN, 22));
		nom_entreprise.setBackground(new Color(0, 0, 51));
		nom_entreprise.setForeground(Color.WHITE);
		nom_entreprise.setSelectedTextColor(Color.red);
		nom_entreprise.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		nom_entreprise.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom d'Entreprise");
		lblNewLabel_1_1.setLabelFor(nom_entreprise);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panBtnExit.setLayout(new BorderLayout(0, 0));
		
		ControlFenetre panel_2 = new ControlFenetre(dialog);
		panBtnExit.add(panel_2, BorderLayout.CENTER);
		
		telephone = new JTextField();
		telephone.setFont(new Font("Cambria", Font.PLAIN, 22));
		telephone.setBackground(new Color(0, 0, 51));
		telephone.setForeground(Color.WHITE);
		telephone.setSelectedTextColor(Color.red);
		telephone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		telephone.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ligne Téléphonique");
		lblNewLabel_1_3.setLabelFor(telephone);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		emailF = new JTextField();
		emailF.setFont(new Font("Cambria", Font.PLAIN, 22));
		emailF.setBackground(new Color(0, 0, 51));
		emailF.setForeground(Color.WHITE);
		emailF.setSelectedTextColor(Color.red);
		emailF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		lblNewLabel_1_1_1.setLabelFor(emailF);
		emailF.setColumns(10);
		
		panel = new PanneauPersonalise(10,10,10,10,new Color(0, 102, 153));
		
		JLabel lblTitre = new JLabel("Ajouter nouveau "+Fournisseur.getTypeCollaborateur());
		panel.add(lblTitre);
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Adresse");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		adresseF = new JTextField();
		adresseF.setFont(new Font("Cambria", Font.PLAIN, 22));
		adresseF.setBackground(new Color(0, 0, 51));
		adresseF.setForeground(Color.WHITE);
		adresseF.setSelectedTextColor(Color.red);
		adresseF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		adresseF.setColumns(10);
		
		txtReference = new JTextField();
		txtReference.setSelectedTextColor(Color.RED);
		txtReference.setForeground(Color.WHITE);
		txtReference.setFont(new Font("Cambria", Font.PLAIN, 22));
		txtReference.setColumns(10);
		txtReference.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		txtReference.setBackground(new Color(0, 0, 51));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Reférence");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panBtnExit, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(14)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(110)
					.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(110)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtReference, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addComponent(nom_entreprise, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(110)
					.addComponent(nom_et_prenom, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(adresseF, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(110)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addComponent(telephone, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailF, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panBtnExit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtReference, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(nom_entreprise, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(nom_et_prenom, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(adresseF, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(24)
							.addComponent(telephone, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(24)
							.addComponent(emailF, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
		);
		contentPanel.setLayout(gl_contentPanel);
		dialog.getContentPane().setLayout(groupLayout);
		
	}
}
