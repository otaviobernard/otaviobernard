package ComboBoxModel;
 
import Model.Tipo;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
 /**
 *
 * @author otávio
 */
public class TipoComboModel extends AbstractListModel<Tipo> implements ComboBoxModel<Tipo> {
 
    private List<Tipo> listCategoria;
    private Tipo selectedCategoria;
    private final static int FIRSTINDEX = 0;
 
    public TipoComboModel() {
        this.listCategoria = new ArrayList<Tipo>();
    }
     
    public TipoComboModel(List<Tipo> listCategoria) {
        this();
        this.listCategoria.addAll(listCategoria);
        if (getSize() > 0) {
            setSelectedItem(this.listCategoria.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Tipo getElementAt(int index) {
        return listCategoria.get(index);
    }
 
    @Override
    public int getSize() {
        return listCategoria.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return this.selectedCategoria;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedCategoria = (Tipo) anItem;
    }
     
    public void addCategoria(Tipo categoria) {
        listCategoria.add(categoria);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listCategoria.get(getSize() - 1));
    }
     
    public void addListCategoria(List<Tipo> categorias) {
        int primeiraLinha = getSize();
        listCategoria.addAll(categorias);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + categorias.size());
        setSelectedItem(listCategoria.get(getSize() - 1));
    }
     
    public void removeCategoria() {
        listCategoria.remove((Tipo)getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listCategoria.get(FIRSTINDEX));
    }
     
    public void clear() {
        listCategoria.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
}
