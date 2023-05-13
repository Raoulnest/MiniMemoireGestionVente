package uiPersonalisee;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControlImageChooser {
	private static String fileName="";
	public ControlImageChooser() {}
	public Image OuvrirImage(PanneauPersonalise p, JLabel label,File file, Image image) throws IOException {
        JFileChooser jfile = new JFileChooser();
        FileNameExtensionFilter filtre = new FileNameExtensionFilter(".images", "jpg", "png");
        jfile.addChoosableFileFilter(filtre);
        int status = jfile.showOpenDialog(p);
        file = jfile.getSelectedFile();
        if (status == JFileChooser.APPROVE_OPTION) {
        	image = ImageIO.read(file);
        	Zonne_d_Image d = new Zonne_d_Image();
        	String path = file.getAbsolutePath();
        	label.setIcon(d.resizeImage(path, null, label,100));
        	fileName = file.getName();
        }
        return image;
 }
	public static String getFileName() {
		return fileName;
	}
	public static void setFileName(String fileName) {
		ControlImageChooser.fileName = fileName;
	}
	
}
