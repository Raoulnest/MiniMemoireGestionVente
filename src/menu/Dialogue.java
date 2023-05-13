package menu;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class Dialogue extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel message;
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
            java.util.logging.Logger.getLogger(Dialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Dialogue d = new Dialogue(contenuMessage,Color.WHITE);
                d.dialog.setVisible(true);
            }
        });
	}
	/**
	 * Create the dialog.
	 */
	public Dialogue(String contenuMessage,Color couleur) {
		dialog = new JDialog();
		dialog.setUndecorated(true);
		dialog.setLocationRelativeTo(null);
		
		dialog.getContentPane().setBackground(new Color(0, 102, 153));
		dialog.setSize(450, 161);
		
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			message = new JLabel(contenuMessage);
			message.setHorizontalAlignment(SwingConstants.CENTER);
			message.setForeground(couleur);
			message.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(message, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(message, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
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
		buttonPane.setLayout(null);
		buttonPane.add(btnAnnuler);
		buttonPane.add(okButton);
		dialog.getContentPane().setLayout(groupLayout);
	}
	public static JDialog getDialog() {
		return dialog;
	}
	public static void fermerFenetre(boolean fen1) {
        Dialogue.dialog.setVisible(fen1);
        
	}
	public static void setDialog(JDialog dialog) {
		Dialogue.dialog = dialog;
	}
	public static String getContenuMessage() {
		return contenuMessage;
	}
	public void setContenuMessage(String contenuMessage) {
		Dialogue.contenuMessage = contenuMessage;
	}
	static boolean okBtn =  false;
	private JButton btnAnnuler;
	public  boolean isOkBtn() {
		return Dialogue.okBtn;
	}
	public static  void setOkBtn(boolean okBtn) {
		Dialogue.okBtn = okBtn;
	}
}
