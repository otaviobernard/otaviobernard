/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeTable;

import java.util.ArrayList;
import java.util.List;
import Model.Carga;

/**
 *
 * @author otávio
 */
public class CargaTableModel extends UtilTableModel<Carga>{

    public CargaTableModel() {
        super(new ArrayList<Carga>());
    }
    
    public CargaTableModel(List<Carga> lista) {
        super(lista);
        columnNames = new String[]{"ID", "Carga", "Marca", "PrecoCarga"};
        classes = new Class[]{Integer.class,
                              String.class,
                              String.class,
                              Double.class};        
              
    }
    
    
    

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Carga produto = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return produto.getCodigo();
            case 1:
                return produto.getNome();
            case 2:
                return produto.getMarca();    
            case 3:
                return produto.getPrecoCarga();    
            default:
                return null;
        }
    }
    
    
    
    
    
}
