package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.Commande;
import models.Facture;
import models.Fournisseur;
import models.LigneCommande;
import models.Stock;
import uiApplication.UI_pan_Facture;
import uiApplication.commandes.UI_pan_Commande;
import uiApplication.commandes.UI_pan_Liste_Commande;
import uiApplication.fournisseurs.UI_pan_Liste_Fournisseur;
import uiApplication.produit.UI_pan_Liste_Produit;
import uiPersonalisee.ControlFenetre;
import uiPersonalisee.PanneauPersonalise;

public class Menu extends JFrame {
	private static JFrame fenMenu;
	private JPanel contentPane;
	Fournisseur co = new Fournisseur();
	Stock ctrlP = new Stock();
	LigneCommande com = new LigneCommande();
	Commande c = new Commande();
	UI_pan_Commande panC = new UI_pan_Commande();
	UI_pan_Facture p_fact = new UI_pan_Facture();
	Facture fact = new Facture();
	
	private static String click = "";
	private static boolean clicked = false;

	JButton btnCommande,btnClient,btnParametre,
	btnFournisseur,btnFacture,btnVente,
	btnCategorie,btnProduit,btnAccueil;
	static boolean []b = {false,false,false,false,false,false,false,false,false};

	UI_pan_Liste_Produit p = new UI_pan_Liste_Produit();
	Pan_dashboard dash = new Pan_dashboard();
	UI_pan_Liste_Commande panCom = new UI_pan_Liste_Commande();
	UI_pan_Liste_Fournisseur f = new UI_pan_Liste_Fournisseur(typeCollaborateur);
	static String typeCollaborateur;
	private static PanneauPersonalise pan_btn;
	private static int translateX = 200;
	static JPanel panel;
	static private double X =100;
	static private double Y =100;
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu();
				Menu.fenMenu.setVisible(true);
            }
        });
	}
    public static void addPanneau(Component comp){
    	panel.removeAll();
    	panel.add(comp);
    	panel.revalidate();
    	panel.repaint();
    }

	/**
	 * Create the frame.
	 */
	public Menu() {
		initialise();
		JPanel panSystem = new JPanel();
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(getPan_btn(), GroupLayout.PREFERRED_SIZE, getTranslateX(), GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
				.addComponent(panSystem, GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panSystem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
						.addComponent(getPan_btn(), GroupLayout.PREFERRED_SIZE, 519, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_pan_btn = new GroupLayout(getPan_btn());
		gl_pan_btn.setHorizontalGroup(
			gl_pan_btn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_btn.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAccueil, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnProduit, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnCategorie, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnVente, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnCommande, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnFacture, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnFournisseur, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnClient, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnParametre, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addGap(6))
		);
		gl_pan_btn.setVerticalGroup(
			gl_pan_btn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_btn.createSequentialGroup()
					.addGap(33)
					.addComponent(btnAccueil, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnProduit, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnCategorie, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnVente, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnCommande, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnFacture, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnFournisseur, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnClient, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(btnParametre, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addGap(6))
		);
		getPan_btn().setLayout(gl_pan_btn);
		panSystem.setLayout(new BorderLayout(0, 0));
		
		ControlFenetre panSyst = new ControlFenetre(fenMenu);
		panSystem.add(panSyst, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
		
		addPanneau(menu.Pan_dashboard.getPanel());	
	}
	double x,y;
	public void initialise() {
		
		fenMenu = new JFrame();
		fenMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/designs/images/ico_sysfolder (4).png")));
		fenMenu.setUndecorated(true);
		fenMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenMenu.setSize( 1038, 561);
		fenMenu.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				X = (int)e.getXOnScreen()-x;
				Y = (int)e.getYOnScreen()-y;
				fenMenu.setBounds((int)X, (int) Y, 1030, 640);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		fenMenu.setContentPane(contentPane);
		setPan_btn(new PanneauPersonalise(20,20,20,20,new Color(0,0,51)));
		
		btnAccueil = new JButton("Menu pricipale");
		btnAccueil.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
//		btnAccueil.setBorderPainted(false);
		btnAccueil.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAccueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccueil.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[1]) {
					btnAccueil.setBackground(new Color(0,51,153));
				}else {
					btnAccueil.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(1);
				btnAccueil.setBackground(new Color(0, 102, 255));
				b[1] = true;b[2] = false;b[3] = false;b[4] = false;b[5] = false;b[6] = false;b[7] = false;b[8] = false;
				
			}
		});
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Accueil";
				Pan_dashboard.getBtnProduit().setText(""+Stock.getCompteProduit());
				addPanneau(Pan_dashboard.getPanel());
			}
		});
		btnAccueil.setForeground(Color.WHITE);
		btnAccueil.setFont(new Font("Candara", Font.PLAIN, 16));
		btnAccueil.setBackground(new Color(0, 0, 71));
		
		btnProduit = new JButton("Produits");
		btnProduit.setHorizontalAlignment(SwingConstants.LEFT);
		btnProduit.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnProduit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProduit.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[2]) {
					btnProduit.setBackground(new Color(0,51,153));
				}else {
					btnProduit.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(2);
				btnProduit.setBackground(new Color(0,51,153));
				b[1] =false ;b[2] =true ;b[3] = false;b[4] = false;b[5] = false;b[6] = false;b[7] = false;b[8] = false;
			}
		});
		btnProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Produits";
				ctrlP.afficheListe(p.getTable(),"");
				addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnProduit.setForeground(Color.WHITE);
		btnProduit.setFont(new Font("Candara", Font.PLAIN, 16));
		btnProduit.setBackground(new Color(0, 0, 71));
		
		btnCategorie = new JButton("Catégorie");
		btnCategorie.setHorizontalAlignment(SwingConstants.LEFT);
		btnCategorie.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnCategorie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCategorie.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[3]) {
					btnCategorie.setBackground(new Color(0,51,153));
				} else {
					btnCategorie.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(3);
				btnCategorie.setBackground(new Color(0,51,153));
				b[1] =false ;b[2] = false;b[3] =true ;b[4] = false;b[5] = false;b[6] = false;b[7] = false;b[8] = false;
			}
		});
		btnCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click = "Categories";
				clicked=true;
			}
		});
		btnCategorie.setForeground(Color.WHITE);
		btnCategorie.setFont(new Font("Candara", Font.PLAIN, 16));
		btnCategorie.setBackground(new Color(0, 0, 71));
		
		btnVente = new JButton("Ventes");
		btnVente.setHorizontalAlignment(SwingConstants.LEFT);
		btnVente.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnVente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVente.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[4]) {
					btnVente.setBackground(new Color(0,51,153));
				}else {
					btnVente.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(4);
				btnVente.setBackground(new Color(0,51,153));
				b[1] = false;b[2] = false;b[3] = false;b[4] = true;b[5] = false;b[6] = false;b[7] = false;b[8] = false;
			}
		});
		btnVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Ventes";
				ctrlP.afficheListe(p.getTable(),"");
				addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnVente.setForeground(Color.WHITE);
		btnVente.setFont(new Font("Candara", Font.PLAIN, 16));
		btnVente.setBackground(new Color(0, 0, 71));
		
		btnFacture = new JButton("Factures");
		btnFacture.setHorizontalAlignment(SwingConstants.LEFT);
		btnFacture.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnFacture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFacture.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[5]) {
					btnFacture.setBackground(new Color(0,51,153));
				}else {
					btnFacture.setBackground(new Color(0, 0, 71));
					}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(5);
				btnFacture.setBackground(new Color(0,51,153));
				b[1] = false;b[2] = false;b[3] = false;b[4] = false;b[5] = true;b[6] = false;b[7] = false;b[8] = false;
			}
		});
		btnFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Factures";
				fact.afficheListe(UI_pan_Facture.getTable(),"");
				addPanneau(UI_pan_Facture.getPanel());
			}
		});
		btnFacture.setForeground(Color.WHITE);
		btnFacture.setFont(new Font("Candara", Font.PLAIN, 16));
		btnFacture.setBackground(new Color(0, 0, 71));
		
		btnFournisseur = new JButton("Fournisseurs");
		btnFournisseur.setHorizontalAlignment(SwingConstants.LEFT);
		btnFournisseur.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnFournisseur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFournisseur.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[6]) {
					btnFournisseur.setBackground(new Color(0,51,153));
				}else {
					btnFournisseur.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(6);
				btnFournisseur.setBackground(new Color(0,51,153));
				b[1] = false;b[2] = false;b[3] = false;b[4] = false;b[5] = false;b[6] = true;b[7] = false;b[8] = false;
			}
		});
		btnFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Fournisseurs";
				typeCollaborateur = "Fournisseur";				
				addPanneau(UI_pan_Liste_Fournisseur.getPanel());
				co.afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
			}
		});
		btnFournisseur.setForeground(Color.WHITE);
		btnFournisseur.setFont(new Font("Candara", Font.PLAIN, 16));
		btnFournisseur.setBackground(new Color(0, 0, 71));
		
		btnParametre = new JButton("Parametre");
		btnParametre.setHorizontalAlignment(SwingConstants.LEFT);
		btnParametre.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Drivers.png")));
		btnParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				isClicked();
				click = "Reinitialiser";
				Dialogue d = new Dialogue("Voulez-vous  reinitialiser ce table",Color.RED);
				Dialogue.fermerFenetre(true);
			}
		});
		btnParametre.setForeground(Color.WHITE);
		btnParametre.setFont(new Font("Candara", Font.PLAIN, 16));
		btnParametre.setBackground(new Color(0, 0, 71));
		
		btnClient = new JButton("Clients");
		btnClient.setHorizontalAlignment(SwingConstants.LEFT);
		btnClient.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClient.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[7]) {
					btnClient.setBackground(new Color(0,51,153));
				}else {
					btnClient.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(7);
				btnClient.setBackground(new Color(0,51,153));
				b[1] = false;b[2] = false;b[3] = false;b[4] = false;b[5] = false;b[6] = false;b[7] = true;b[8] = false;
			}
		});
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Clients";
				typeCollaborateur = "Client";
				addPanneau(UI_pan_Liste_Fournisseur.getPanel());
				co.afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
			}
		});
		
		btnClient.setForeground(Color.WHITE);
		btnClient.setFont(new Font("Candara", Font.PLAIN, 16));
		btnClient.setBackground(new Color(0, 0, 71));
		
		btnCommande = new JButton("Commandes");
		btnCommande.setHorizontalAlignment(SwingConstants.LEFT);
		btnCommande.setIcon(new ImageIcon(Menu.class.getResource("/designs/images/Backup.png")));
		btnCommande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCommande.setBackground(new Color(0,51,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(b[8]) {
					btnCommande.setBackground(new Color(0,51,153));
				}else {
					btnCommande.setBackground(new Color(0, 0, 71));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setTranslateX(80);
				btnCliquer(8);
				btnCommande.setBackground(new Color(0,51,153));
				b[1] = false;b[2] = false;b[3] = false;b[4] = false;b[5] = false;b[6] = false;b[7] = false;b[8] = true;
			}
		});
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Commandes";
				addPanneau(UI_pan_Commande.getPanel());
				c.afficheListe(UI_pan_Commande.getTable(),"");
			}
		});
		btnCommande.setForeground(Color.WHITE);
		btnCommande.setFont(new Font("Candara", Font.PLAIN, 16));
		btnCommande.setBackground(new Color(0, 0, 71));
	}
	public void btnCliquer(int nb) {
		switch(nb) {
		case 1:
			btnAccueil.setBackground(new Color(0,152, 255));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 2:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0,152, 255));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 3:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0,152, 255));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 4:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0,152, 255));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 5:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0,152, 255));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 6:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0,152, 255));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 7:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0,152, 255));
			btnCommande.setBackground(new Color(0, 0, 71));
			break;
		case 8:
			btnAccueil.setBackground(new Color(0, 0, 71));
			btnProduit.setBackground(new Color(0, 0, 71));
			btnCategorie.setBackground(new Color(0, 0, 71));
			btnVente.setBackground(new Color(0, 0, 71));
			btnFacture.setBackground(new Color(0, 0, 71));
			btnFournisseur.setBackground(new Color(0, 0, 71));
			btnClient.setBackground(new Color(0, 0, 71));
			btnCommande.setBackground(new Color(0,152, 255));
			break;
		}
	}
	public static JFrame getFenMenu() {
		return fenMenu;
	}
	public static void setFenMenu(JFrame fenMenu) {
		Menu.fenMenu = fenMenu;
	}
	public static boolean isClicked() {
		return clicked;
	}
	public static void setClicked(boolean clicked) {
		Menu.clicked = clicked;
	}
	public static String getClick() {
		return click;
	}
	public static void setClick(String click) {
		Menu.click = click;
	}
		
	public int getX() {
		return (int) X;
	}

	public static void setX(int x) {
		X = x;
	}

	public int getY() {
		return (int) Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public static String getTypeCollaborateur() {
		return typeCollaborateur;
	}
	public static void setTypeCollaborateur(String typeCollaborateur) {
		Menu.typeCollaborateur = typeCollaborateur;
	}

	public static int getTranslateX() {
		return translateX;
	}

	public static void setTranslateX(int translateX) {
		Menu.translateX = translateX;
	}
	public static PanneauPersonalise getPan_btn() {
		return pan_btn;
	}
	public static void setPan_btn(PanneauPersonalise pan_btn) {
		Menu.pan_btn = pan_btn;
	}
	
}
