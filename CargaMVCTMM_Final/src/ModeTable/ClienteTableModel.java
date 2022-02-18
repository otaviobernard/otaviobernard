/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeTable;

import java.util.ArrayList;
import java.util.List;
import Model.Cliente;

/**
 *
 * @author otávio
 */
public class ClienteTableModel extends UtilTableModel<Cliente> {

    public ClienteTableModel() {
        super(new ArrayList<Cliente>());
    }
    
    public ClienteTableModel(List<Cliente> lista) {
        super(lista);
        columnNames = new String[]{"ID", "Cliente", "CPF"};
        classes = new Class[]{Integer.class,
                              String.class,
                              Integer.class};        
              
    }
    
    
    

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Cliente funcionario = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return funcionario.getCodigo();
            case 1:
                return funcionario.getNome();
            case 2:
                return funcionario.getCpf();   
            default:
                return null;
        }
    }
    
}
