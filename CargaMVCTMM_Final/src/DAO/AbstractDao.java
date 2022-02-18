package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author otávio
 */
public abstract class AbstractDao<T> implements IDAO<T>{

    
    
    

    protected EntityManagerFactory factory;
    protected EntityManager em;   
    
    public AbstractDao() {
        factory = Persistence.createEntityManagerFactory("CargaPU");        
        em = getEntityManager();
    }
    
    public EntityManager getEntityManager(){
        if (em == null){
            em = factory.createEntityManager();
        }
        return em;
    } 
    
    
    
    
    

    
    
    
    
}
