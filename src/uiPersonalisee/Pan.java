package uiPersonalisee;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pan extends JPanel {

	/**
	 * Create the panel.
	 */
	static JLabel label = new JLabel();
	Color color;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Pan(String path) {
		setLayout(new BorderLayout(0, 0));
		
		PanneauPersonalise panImageView = new PanneauPersonalise(10, 10, 10, 10, color);
		add(panImageView, BorderLayout.CENTER);
		panImageView.setLayout(new BorderLayout(0, 0));
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		panImageView.add(label, BorderLayout.CENTER);
		Zonne_d_Image d = new Zonne_d_Image();
	   	label.setIcon(d.resizeImage(path, null, label, 100));

	}
	

}
