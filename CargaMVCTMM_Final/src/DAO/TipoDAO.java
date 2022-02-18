
package DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import Model.Tipo;
/**
 *
 * @author otávio
 */

public class TipoDAO extends AbstractDao<Tipo> implements Serializable{

    @Override
    public Tipo create(Tipo entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity); 

        return entity;
    }

    @Override
    public boolean delete(Tipo t) {
        em.getTransaction().begin();
        boolean destroy = this.destroy(t.getCodigo());
        em.getTransaction().commit();
        return destroy;
    }

    @Override
    public Tipo update(Tipo t) {
        em.getTransaction().begin();
        t = this.getEntityManager().merge(t);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public Tipo findById(int id) {
        return this.findById((long) id);
    }

    @Override
    public Tipo findById(long id) {
        Tipo item = em.find(Tipo.class, id);
        return item;
    }

    @Override
    public List<Tipo> find(Tipo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tipo> findAll() {
        javax.persistence.criteria.CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tipo.class));
        return em.createQuery(cq).getResultList();
    }
    
    public boolean destroy(Long id) {
            
            Tipo categoria;
            categoria = em.getReference(Tipo.class, id);
            if(Objects.equals(id, categoria.getCodigo())){
                em.remove(categoria);
            
               return true;
            }
            return false;
    }
    
}
