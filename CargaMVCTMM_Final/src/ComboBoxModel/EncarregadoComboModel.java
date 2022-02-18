/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComboBoxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import Model.Encarregado;

/**
 *
 * @author otávio
 */
public class EncarregadoComboModel extends AbstractListModel<Encarregado> implements ComboBoxModel<Encarregado> {
    
    
    private List<Encarregado> listFornecedor;
    private Encarregado selectedFornecedor;
    private final static int FIRSTINDEX = 0;
 
    public EncarregadoComboModel() {
        this.listFornecedor = new ArrayList<Encarregado>();
    }
     
    public EncarregadoComboModel(List<Encarregado> listFornecedor) {
        this();
        this.listFornecedor.addAll(listFornecedor);
        if (getSize() > 0) {
            setSelectedItem(this.listFornecedor.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Encarregado getElementAt(int index) {
        return listFornecedor.get(index);
    }
 
    @Override
    public int getSize() {
        return listFornecedor.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return this.selectedFornecedor;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedFornecedor = (Encarregado) anItem;
    }
     
    public void addFornecedor(Encarregado fornecedor) {
        listFornecedor.add(fornecedor);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listFornecedor.get(getSize() - 1));
    }
     
    public void addListCategoria(List<Encarregado> fornecedor) {
        int primeiraLinha = getSize();
        listFornecedor.addAll(fornecedor);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + fornecedor.size());
        setSelectedItem(listFornecedor.get(getSize() - 1));
    }
     
    public void removeCategoria() {
        listFornecedor.remove((Encarregado)getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listFornecedor.get(FIRSTINDEX));
    }
     
    public void clear() {
        listFornecedor.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
    
}
