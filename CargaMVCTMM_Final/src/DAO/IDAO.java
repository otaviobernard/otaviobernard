package DAO;

import java.util.List;
/**
 *
 * @author otávio
 */
public interface IDAO<T> {
    public  T create(T t);
    public boolean delete(T t);
    public  T update(T t);    

    public  T findById(int id);
    public  T findById(long id);
    
    public  List<T> find(T t);
    public  List<T> findAll();
}
