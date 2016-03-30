/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.daos;

import br.ifirst.karine.utils.EMF;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Wanderson
 * @param <PK>
 * @param <T>
 */
public abstract class AbstractDao<PK, T> implements IDao<PK, T> {

    @PersistenceContext(unitName = "karine.0PU")
    protected EntityManager em;

    protected final Class<T> entityClass;

    public AbstractDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.em = EMF.get().createEntityManager();

    }

    @Override
    public void create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
        }

    }

    @Override
    public void edit(T entity) {

        try {
            em.getTransaction().begin();
            em.persist(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void remove(T entity) {

        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
        }

    }

    @Override
    public T find(PK id) {
        return em.find(entityClass, id);

    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public long count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult());
    }
    
    

}
