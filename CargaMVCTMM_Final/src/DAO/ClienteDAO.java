
package DAO;

import Model.Cliente;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author otávio
 */
public class ClienteDAO extends AbstractDao<Cliente> implements Serializable {


    
    @Override
    public Cliente create(Cliente entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity); 

        return entity;     
    }

    
        @Override
    public boolean delete(Cliente t) {
        em.getTransaction().begin();
        boolean destroy = this.destroy(t.getCodigo());
        em.getTransaction().commit();
        return destroy;
    }

    @Override
    public Cliente update(Cliente t) {
        em.getTransaction().begin();
        t = this.getEntityManager().merge(t);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public Cliente findById(int id) {
        return this.findById((long) id);
    }

    @Override
    public Cliente findById(long id) {
        Cliente item = em.find(Cliente.class, id);
        return item;
    }

    @Override
    public List<Cliente> find(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() {
        javax.persistence.criteria.CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cliente.class));
        return em.createQuery(cq).getResultList();
    }
    
    public boolean destroy(Long id) {
            
            Cliente funcionario;
            funcionario = em.getReference(Cliente.class, id);
            if(Objects.equals(id, funcionario.getCodigo())){
                em.remove(funcionario);
            
               return true;
            }
            return false;
    }
    
 


    
}
