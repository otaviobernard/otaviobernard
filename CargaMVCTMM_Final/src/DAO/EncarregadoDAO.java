/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import Model.Encarregado;

/**
 *
 * @author otávio
 */
public class EncarregadoDAO extends AbstractDao<Encarregado> implements Serializable {

    @Override
    public Encarregado create(Encarregado entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity); 

        return entity;
    }

    @Override
    public boolean delete(Encarregado t) {
        em.getTransaction().begin();
        boolean destroy = this.destroy(t.getCodigo());
        em.getTransaction().commit();
        return destroy;
    }

    @Override
    public Encarregado update(Encarregado t) {
        em.getTransaction().begin();
        t = this.getEntityManager().merge(t);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public Encarregado findById(int id) {
        return this.findById((long) id);
    }

    @Override
    public Encarregado findById(long id) {
        Encarregado item = em.find(Encarregado.class, id);
        return item;
    }

    @Override
    public List<Encarregado> find(Encarregado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Encarregado> findAll() {
        javax.persistence.criteria.CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Encarregado.class));
        return em.createQuery(cq).getResultList();
    }
    
    public boolean destroy(Long id) {
            
            Encarregado fornecedor;
            fornecedor = em.getReference(Encarregado.class, id);
            if(Objects.equals(id, fornecedor.getCodigo())){
                em.remove(fornecedor);
            
               return true;
            }
            return false;
    }
}
