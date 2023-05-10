package uiPersonalisee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableDark extends JTable{
    	public TableDark() {
        super();
		EnteteTable t = new EnteteTable();
		getTableHeader().setDefaultRenderer(t);
		getTableHeader().setPreferredSize(new Dimension(0,35));
                setDefaultRenderer(Object.class, new ContenuTable());
                setRowHeight(getTailleLigne());
                
	}
        int tailleLigne = 30;

    public int getTailleLigne() {
        return tailleLigne;
    }

    public void setTailleLigne(int tailleLigne) {
        this.tailleLigne = tailleLigne;
    }
        
        public void fixTable(JScrollPane scrollPane){
            scrollPane.setVerticalScrollBar(new ScrollPersonalise());
            JPanel p = new JPanel();
            p.setBackground(new Color(30,30,30));
            scrollPane.setCorner(JScrollPane.UPPER_LEADING_CORNER, p);
            scrollPane.getViewport().setBackground(new Color(30,30,30));
        
    }
	private class EnteteTable extends DefaultTableCellRenderer{
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			com.setBackground(bgColor);
			com.setForeground(fgColor);
                        com.setFont(com.getFont().deriveFont(Font.BOLD, taillePolice));
			return com;
		}
                Color bgColor = new Color(30,30,30);
                Color fgColor = new Color(200,200,200);
                int taillePolice = 12;

        public Color getBgColor() {
            return bgColor;
        }

        public void setBgColor(Color bgColor) {
            this.bgColor = bgColor;
        }

        public Color getFgColor() {
            return fgColor;
        }

        public void setFgColor(Color fgColor) {
            this.fgColor = fgColor;
        }

        public int getTaillePolice() {
            return taillePolice;
        }

        public void setTaillePolice(int taillePolice) {
            this.taillePolice = taillePolice;
        }

	}
        private class ContenuTable extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com =super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if(isCellSelected(row, column)){
                if( row % 2 ==0){
                    com.setBackground(new Color(33,103,153));
                    
                    com.setForeground(fgColor);
                }else{
                    com.setBackground(new Color(29,36,127));
                    com.setForeground(fgColor);
                }
            }else{
                if( row % 2 ==0){
                    com.setBackground(new Color(50,50,50));
                    
                    com.setForeground(fgColor);
                }else{
                    com.setBackground(bgColor);
                    com.setForeground(fgColor);
                }
            }
            setBorder(new EmptyBorder(0,5,0,5));
            return com ;
        }
         Color bgColor = new Color(30,30,30);
         Color fgColor = new Color(200,200,200);
         Color bgColorSelectedI = new Color(200,200,200);
         Color bgColorSelectedP = new Color(200,200,200);

        public Color getBgColor() {
            return bgColor;
        }

        public void setBgColor(Color bgColor) {
            this.bgColor = bgColor;
        }

        public Color getFgColor() {
            return fgColor;
        }

        public void setFgColor(Color fgColor) {
            this.fgColor = fgColor;
        }

        public Color getBgColorSelectedI() {
            return bgColorSelectedI;
        }

        public void setBgColorSelectedI(Color bgColorSelectedI) {
            this.bgColorSelectedI = bgColorSelectedI;
        }

        public Color getBgColorSelectedP() {
            return bgColorSelectedP;
        }

        public void setBgColorSelectedP(Color bgColorSelectedP) {
            this.bgColorSelectedP = bgColorSelectedP;
        }
            
        }
}

