
package Control;

import java.util.List;
/**
 *
 * @author otávio
 */

public interface IControleSimples<T> {
    public void showInicialScreen();

    public T        create();
    public void     read(T objeto);
    public T        update(T objeto);    
    public boolean  delete(T objeto);
    
    public void print(); 
    
    
    public List<T> getAll();
    
    public boolean  filter(String column, String valor);
    public T        getAObject(); 
}
