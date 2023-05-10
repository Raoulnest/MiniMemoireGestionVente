package uiPersonalisee;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zonne_d_Image extends JPanel {
	public Zonne_d_Image() {}
	public void paintComponent(Graphics g){
		Image img = null;
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	public ImageIcon resizeImage(String imagePath, byte[] pic,JLabel label) {
		ImageIcon myImage = null;
		if(imagePath != null) {
			myImage = new ImageIcon(imagePath);
		}else {
			myImage = new ImageIcon(pic);
		}
		
		if(label.getWidth() == 0 && label.getHeight() == 0) {
			Image  img2 = myImage.getImage().getScaledInstance(label.getWidth()+30, label.getHeight()+30, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(img2);
			return image;
		}else {
			Image img2 = myImage.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(img2);
			return image;
		}
	}
}
