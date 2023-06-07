package uiApplication.produit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import menu.Menu;


@SuppressWarnings("serial")
public class Categorie extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JDialog dialog ;
	private JButton okButton;
	private JPanel buttonPane;
	private static String contenuMessage;
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
            java.util.logging.Logger.getLogger(Categorie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categorie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categorie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categorie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Categorie d = new Categorie(contenuMessage,Color.WHITE);
                d.dialog.setVisible(true);
            }
        });
	}
	/**
	 * Create the dialog.
	 */
	public Categorie(String contenuMessage,Color couleur) {
		dialog = new JDialog();
		dialog.setLocationRelativeTo(null);
		
		dialog.getContentPane().setBackground(new Color(0, 102, 153));
		dialog.setSize(450, 161);
		
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setBackground(new Color(0, 0, 51));
		textField.setSelectedTextColor(Color.ORANGE);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setBackground(new Color(0, 0, 51));
		textField_1.setSelectedTextColor(Color.ORANGE);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		textField_1.setColumns(10);
		{
			buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 51));
			{
				okButton = new JButton("OK");
				okButton.setBounds(350, 5, 79, 29);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if((Menu.getClick() == "Reinitialiser") && Menu.isClicked()==true) {
								System.out.println("Mode : "+Menu.getClick());
								fermerFenetre(false);
						}
					}
				});
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("Arial", Font.PLAIN, 14));
				okButton.setBackground(new Color(0, 102, 204));
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.setBounds(6, 5, 77, 29);
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fermerFenetre(false);
				}
			});
			btnAnnuler.setForeground(Color.WHITE);
			btnAnnuler.setFont(new Font("Arial", Font.PLAIN, 14));
			btnAnnuler.setBackground(new Color(204, 51, 51));
			btnAnnuler.setActionCommand("OK");
		}
		GroupLayout groupLayout = new GroupLayout(dialog.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
		);
		
		JLabel lblNewLabel = new JLabel("Id Categorie :");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblNomCategorie = new JLabel("Nom Categorie :");
		lblNomCategorie.setForeground(Color.WHITE);
		lblNomCategorie.setFont(new Font("Calibri", Font.PLAIN, 18));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNomCategorie, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
					.addGap(74))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textField_1)
							.addGap(7)))
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNomCategorie, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1))
		);
		contentPanel.setLayout(gl_contentPanel);
		buttonPane.setLayout(null);
		buttonPane.add(btnAnnuler);
		buttonPane.add(okButton);
		dialog.getContentPane().setLayout(groupLayout);
	}
	public static JDialog getDialog() {
		return dialog;
	}
	public static void fermerFenetre(boolean fen1) {
        Categorie.dialog.setVisible(fen1);
        
	}
	public static void setDialog(JDialog dialog) {
		Categorie.dialog = dialog;
	}
	public static String getContenuMessage() {
		return contenuMessage;
	}
	public void setContenuMessage(String contenuMessage) {
		Categorie.contenuMessage = contenuMessage;
	}
	static boolean okBtn =  false;
	private JButton btnAnnuler;
	private JTextField textField;
	private JTextField textField_1;
	public  boolean isOkBtn() {
		return Categorie.okBtn;
	}
	public static  void setOkBtn(boolean okBtn) {
		Categorie.okBtn = okBtn;
	}
}
