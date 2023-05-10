package uiPersonalisee;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class ScrollPersonalise extends JScrollBar{
    public ScrollPersonalise() {
        setUI(getUI());
        setPreferredSize(new Dimension(8 , 8));
    }
    
}