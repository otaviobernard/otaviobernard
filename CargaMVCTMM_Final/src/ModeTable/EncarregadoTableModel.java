/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeTable;

import java.util.ArrayList;
import java.util.List;
import Model.Encarregado;

/**
 *
 * @author otávio
 */
public class EncarregadoTableModel extends UtilTableModel<Encarregado> {

    public EncarregadoTableModel() {
        this(new ArrayList<Encarregado>());
    }
    
    public EncarregadoTableModel(List<Encarregado> lista) {
        super(lista);
        columnNames = new String[]{"ID", "Encarregado"};
        classes = new Class[]{Integer.class,
                              String.class};        
              
    }
    
    
    

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Encarregado fornecedor = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return fornecedor.getCodigo();
            case 1:
                return fornecedor.getNome();
            default:
                return null;
        }
    }
    
}
