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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controllers.ControlleurFournisseur;
import controllers.ControlleurProduit;
import uiApplication.fournisseurs.UI_pan_Liste_Fournisseur;
import uiApplication.produit.UI_pan_Liste_Produit;
import uiPersonalisee.ControlFenetre;
import uiPersonalisee.PanneauPersonalise;

public class Menu extends JFrame {
	private static JFrame fenMenu;
	private JPanel contentPane;
	ControlleurFournisseur co = new ControlleurFournisseur();
	private static String click = "";
	private static boolean clicked = false;

	JButton btnCommande,btnClient,btnParametre,btnNewButton_2_6,
	btnFournisseur,btnFacture,btnVente,
	btnCategorie,btnProduit,btnAccueil;
	static boolean []b = {false,false,false,false,false,false,false,false,false};

	UI_pan_Liste_Produit p = new UI_pan_Liste_Produit();
	Pan_dashboard dash = new Pan_dashboard();
	UI_pan_Liste_Fournisseur f = new UI_pan_Liste_Fournisseur(typeCollaborateur);
	static String typeCollaborateur;
	private PanneauPersonalise pan_btn;
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
					.addComponent(pan_btn, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panSystem, GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panSystem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addComponent(pan_btn, GroupLayout.PREFERRED_SIZE, 519, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_pan_btn = new GroupLayout(pan_btn);
		gl_pan_btn.setHorizontalGroup(
			gl_pan_btn.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pan_btn.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pan_btn.createSequentialGroup()
							.addComponent(btnCommande, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_pan_btn.createSequentialGroup()
							.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAccueil, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pan_btn.createSequentialGroup()
									.addComponent(btnProduit, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnCategorie, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pan_btn.createSequentialGroup()
									.addComponent(btnVente, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnFacture, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pan_btn.createSequentialGroup()
									.addComponent(btnFournisseur, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnClient, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pan_btn.createSequentialGroup()
									.addComponent(btnParametre, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
									.addGap(12)
									.addComponent(btnNewButton_2_6, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(6))))
		);
		gl_pan_btn.setVerticalGroup(
			gl_pan_btn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_btn.createSequentialGroup()
					.addGap(23)
					.addComponent(btnAccueil, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProduit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pan_btn.createSequentialGroup()
							.addGap(2)
							.addComponent(btnCategorie, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFacture, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFournisseur, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClient, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCommande, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_pan_btn.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnParametre, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addGap(6))
		);
		pan_btn.setLayout(gl_pan_btn);
		panSystem.setLayout(new BorderLayout(0, 0));
		
		ControlFenetre panSyst = new ControlFenetre(fenMenu);
		panSystem.add(panSyst, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
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
		pan_btn = new PanneauPersonalise(20,20,20,20,new Color(0,0,51));
		
		btnAccueil = new JButton("Accueil");
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
					btnAccueil.setBackground(new Color(0,51,110));
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
				Pan_dashboard.getBtnProduit().setText(""+ControlleurProduit.getCompteProduit());
//				scrollPane.setViewportView(Pan_dashboard.getPanel());
				addPanneau(Pan_dashboard.getPanel());
			}
		});
		btnAccueil.setForeground(Color.WHITE);
		btnAccueil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAccueil.setBackground(new Color(0,51,110));
		
		btnProduit = new JButton("Produits");
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
					btnProduit.setBackground(new Color(0,51,110));
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

				addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnProduit.setForeground(Color.WHITE);
		btnProduit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProduit.setBackground(new Color(0,51,110));
		
		btnCategorie = new JButton("Catégorie");
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
					btnCategorie.setBackground(new Color(0,51,110));
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

				addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnCategorie.setForeground(Color.WHITE);
		btnCategorie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCategorie.setBackground(new Color(0,51,110));
		
		btnVente = new JButton("Ventes");
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
					btnVente.setBackground(new Color(0,51,110));
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

				addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnVente.setForeground(Color.WHITE);
		btnVente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVente.setBackground(new Color(0,51,110));
		
		btnFacture = new JButton("Factures");
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
					btnFacture.setBackground(new Color(0,51,110));
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

				addPanneau(UI_pan_Liste_Produit.getPanel());
			}
		});
		btnFacture.setForeground(Color.WHITE);
		btnFacture.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFacture.setBackground(new Color(0,51,110));
		
		btnFournisseur = new JButton("Fournisseurs");
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
					btnFournisseur.setBackground(new Color(0,51,110));
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
//				scrollPane.setViewportView(UI_pan_Liste_Fournisseur.getPanel());
				addPanneau(UI_pan_Liste_Fournisseur.getPanel());
				co.afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
			}
		});
		btnFournisseur.setForeground(Color.WHITE);
		btnFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFournisseur.setBackground(new Color(0,51,110));
		
		btnParametre = new JButton("Parametre");
		btnParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				isClicked();
				click = "Reinitialiser";
				Dialogue d = new Dialogue("Voulez-vous  reinitialiser ce table",Color.RED);
				Dialogue.fermerFenetre(true);
			}
		});
		btnParametre.setForeground(Color.WHITE);
		btnParametre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnParametre.setBackground(new Color(0,51,110));
		
		btnNewButton_2_6 = new JButton("");
		btnNewButton_2_6.setForeground(Color.WHITE);
		btnNewButton_2_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_6.setBackground(new Color(0,51,110));
		
		btnClient = new JButton("Clients");
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
					btnClient.setBackground(new Color(0,51,110));
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
//				scrollPane.setViewportView(UI_pan_Liste_Fournisseur.getPanel());
				addPanneau(UI_pan_Liste_Fournisseur.getPanel());
				co.afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
			}
		});
		
		btnClient.setForeground(Color.WHITE);
		btnClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClient.setBackground(new Color(0,51,110));
		
		btnCommande = new JButton("Commandes");
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
					btnCommande.setBackground(new Color(0,51,110));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCliquer(8);
				btnCommande.setBackground(new Color(0,51,153));
				b[1] = false;b[2] = false;b[3] = false;b[4] = false;b[5] = false;b[6] = false;b[7] = false;b[8] = true;
			}
		});
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClicked(false);
				click = "Commandes";
				typeCollaborateur = "Commande";
//				scrollPane.setViewportView(Pan_dashboard.getPanel());
				addPanneau(UI_pan_Liste_Fournisseur.getPanel());
				co.afficheListe(UI_pan_Liste_Fournisseur.getTable(),Menu.getTypeCollaborateur(),"");
			}
		});
		
		btnCommande.setForeground(Color.WHITE);
		btnCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCommande.setBackground(new Color(0,51,110));
	}
	
	public void btnCliquer(int nb) {
		switch(nb) {
		case 1:
			btnAccueil.setBackground(new Color(0,152, 255));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,51,110));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 2:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,152, 255));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,51,110));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 3:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,152, 255));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,51,110));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 4:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,152, 255));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,51,110));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 5:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,152, 255));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,51,110));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 6:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,152, 255));
			btnClient.setBackground(new Color(0,51,110));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 7:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,152, 255));
			btnCommande.setBackground(new Color(0,51,110));
			break;
		case 8:
			btnAccueil.setBackground(new Color(0,51,110));
			btnProduit.setBackground(new Color(0,51,110));
			btnCategorie.setBackground(new Color(0,51,110));
			btnVente.setBackground(new Color(0,51,110));
			btnFacture.setBackground(new Color(0,51,110));
			btnFournisseur.setBackground(new Color(0,51,110));
			btnClient.setBackground(new Color(0,51,110));
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
//	public static JScrollPane getScrollPane() {
//		return scrollPane;
//	}
//	public static void setScrollPane(JScrollPane scrollPane) {
//		Menu.scrollPane = scrollPane;
//	}
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
}
