package uiPersonalisee;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablePersonaliser extends DefaultTableCellRenderer {
	String path;
public TablePersonaliser(String path) {
	this.path = path;
}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Pan p = new Pan(path);
		if(isSelected == true && row % 2 == 0) {
			p.setColor(Color.white);
		}else {
			p.setColor(com.getBackground());
		}
		return p;
	}

}
