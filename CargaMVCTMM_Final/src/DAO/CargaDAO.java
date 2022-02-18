
package DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import Model.Tipo;
import Model.Encarregado;
import Model.Carga;
/**
 *
 * @author otávio
 */

public class CargaDAO extends AbstractDao<Carga> implements Serializable  {

    
    
    @Override
    public Carga create(Carga entity) {
        em.getTransaction().begin();
        TipoDAO daoCategoria = new TipoDAO();
        Tipo c = daoCategoria.findById(entity.getTipo().getCodigo());
        entity.setTipo(c);

        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity); 
        
        return entity;
    }

    @Override
    public boolean delete(Carga t) {
    
        
        em.getTransaction().begin();
        boolean destroy = this.destroy(t.getCodigo());
        em.getTransaction().commit();
        return destroy;
    }

    @Override
    public Carga update(Carga t) {
        em.getTransaction().begin();
        t = this.getEntityManager().merge(t);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public Carga findById(int id) {
        return this.findById((long) id);
    }

    @Override
    public Carga findById(long id) {
        Carga item = em.find(Carga.class, id);
        return item;
    }

    @Override
    public List<Carga> find(Carga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carga> findAll() {
        javax.persistence.criteria.CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Carga.class));
        return em.createQuery(cq).getResultList();
    }
    
    public boolean destroy(Long id) {
            Carga produto;
            produto = em.getReference(Carga.class, id);
            if(Objects.equals(id, produto.getCodigo())){
                em.remove(produto);
               return true;
            }
            return false;
    }
    
}
