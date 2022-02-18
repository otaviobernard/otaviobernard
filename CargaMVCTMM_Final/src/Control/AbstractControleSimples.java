package Control;

import DAO.IDAO;
import View.IViewSimplesCRUD;
import java.util.List;


/**
 *
 * @author otávio
 */

public abstract class AbstractControleSimples<T> implements IControleSimples<T> {

    protected IDAO<T> dao;
    protected IViewSimplesCRUD<T> crud;
 
    @Override
    public T getAObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.       
    }    

    @Override
    public List<T> getAll() {
        return dao.findAll();
        //return null;
    }
    
    
    
}
