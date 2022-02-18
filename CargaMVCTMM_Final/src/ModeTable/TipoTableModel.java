/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeTable;

import java.util.ArrayList;
import java.util.List;
import Model.Tipo;

/**
 *
 * @author otávio
 */
public class TipoTableModel extends UtilTableModel<Tipo>{

    public TipoTableModel() {
        super(new ArrayList<Tipo>());
    }

    public TipoTableModel(List<Tipo> lista) {
        super(lista);
        columnNames = new String[]{"ID", "Tipo"};
        classes = new Class[]{Integer.class,
                              String.class,};        
              
    }
    
    
    

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Tipo categoria = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return categoria.getCodigo();
            case 1:
                return categoria.getNome();
            default:
                return null;
        }
    }
    
}
