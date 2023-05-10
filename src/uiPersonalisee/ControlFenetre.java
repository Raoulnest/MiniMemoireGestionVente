package uiPersonalisee;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class ControlFenetre extends JPanel {

	/**
	 * Create the panel.
	 */
	private boolean max = true;
	
	/**
	 * @wbp.parser.constructor
	 */
	public ControlFenetre(JDialog diag) {
		setBackground(new Color(0, 102, 204));
		
		JLabel fermer = new JLabel("x");
		
				fermer.setForeground(new Color(0, 102, 255));
				fermer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						fermer.setForeground(Color.red);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						fermer.setForeground(new Color(0, 10, 153));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						diag.setVisible(false);
					}
				});
				
				fermer.setHorizontalAlignment(SwingConstants.CENTER);
				fermer.setForeground(new Color(0, 10, 153));
				fermer.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(439, Short.MAX_VALUE)
					.addComponent(fermer, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(fermer, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
					.addGap(9))
		);
		setLayout(groupLayout);

	}
	
	public ControlFenetre(JFrame frame) {
		setBackground(color);
		
		JLabel minimiser = new JLabel("-");
		minimiser.setHorizontalAlignment(SwingConstants.CENTER);
		minimiser.setForeground(new Color(0,58,255));
		minimiser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimiser.setForeground(new Color(255, 153, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimiser.setForeground(new Color(0,58,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
			});
		minimiser.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel maximiser = new JLabel("+");
		maximiser.setForeground(new Color(0,58,255));
		maximiser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				maximiser.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				maximiser.setForeground(new Color(0,58,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(max) {
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
					frame.setMaximizedBounds(env.getMaximumWindowBounds());
					max = false;
				}else {
					frame.setExtendedState(JFrame.NORMAL);
					max = true;
				}
			}
		});
		maximiser.setHorizontalAlignment(SwingConstants.CENTER);
		maximiser.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel fermer = new JLabel("x");
		
				fermer.setForeground(new Color(0,58,255));
				fermer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						fermer.setForeground(Color.red);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						fermer.setForeground(new Color(0,58,255));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
//						frame.setVisible(false);
						System.exit(0);
					}
				});
				
				fermer.setHorizontalAlignment(SwingConstants.CENTER);
				fermer.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(minimiser, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(maximiser, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fermer, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(fermer, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(maximiser, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE))
						.addComponent(minimiser, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE))
					.addGap(9))
		);
		setLayout(groupLayout);
	}
	private Color color = new Color(0, 0, 51);
}
