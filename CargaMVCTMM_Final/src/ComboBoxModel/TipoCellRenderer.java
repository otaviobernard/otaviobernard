package ComboBoxModel;

import Model.Tipo;
import java.awt.Component;
 
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
 /**
 *
 * @author otávio
 */
 
public class TipoCellRenderer extends DefaultListCellRenderer {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Tipo) {
            Tipo categoria = (Tipo) value;
            setText(categoria.getNome());
        }
        return this;
    }
}
